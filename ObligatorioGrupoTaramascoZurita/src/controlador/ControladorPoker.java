package controlador;
import logica.Fachada;
import logica.Figura;
import logica.Jugador;
import logica.Mano;
import logica.Mesa;
import logica.Mano.EstadoMano;
import observador.Observable;
import observador.Observador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carry
 */
public class ControladorPoker implements Observador{
    private VistaPoker vistaPoker;
    private Mesa mesa;
    private Jugador jugador;
    private Mano mano;
    public ControladorPoker(VistaPoker vistaPoker, Jugador j) {
        this.vistaPoker = vistaPoker;
        this.jugador = j;
        this.mesa = jugador.getMesa();
        mesa.agregarObservador(this);
        mano = mesa.getManoActual();
        if(mesa.esIniciada()){
            this.iniciarMesa();
        }
        else{
            vistaPoker.mostrarMensajeInicial(mesa.getJugadoresActuales(), mesa.getMinJugadores());
        }
        //TODO: Ver si actualizarDatosPantalla se maneja mejor con un observador.
        mano.agregarObservador(this);
        this.actualizarDatosPantalla();
    }

    public void actualizarDatosPantalla(){
        vistaPoker.actualizarDatosPantalla(jugador.getNombreCompleto(), jugador.getSaldo(), mesa.getId(), mesa.getPozo(), mesa.getManos().size(), mesa.getManoActual().getEstadoMano());
    }

    public void iniciarMesa(){
        //se llama cuando se observó que la mesa pasó a iniciada.
        vistaPoker.mostrarCartas(jugador, mesa);
        vistaPoker.mostrarFigurasDefinidas(Fachada.getInstancia().getFiguras());
        determinarFiguraMasAlta();
        actualizarDatosPantalla();
    }

    public void determinarFiguraMasAlta(){
        Figura figura = jugador.figuraMasAlta();
        vistaPoker.mostrarFiguraMasAlta(figura);
    }

    public void apostar(int monto){
        boolean apuestaRealizada = mano.apostar(monto, jugador);
        if (apuestaRealizada) {
            // Actualizar la vista con el valor de la apuesta y el estado de la mano
            vistaPoker.mostrarApuestaRealizada(jugador.getNombreCompleto(), monto);
            vistaPoker.mostrarEstadoMano(mano.getEstadoMano());
            this.actualizarDatosPantalla();
        } else {
            // Muestra un mensaje de error en la vista si la apuesta no es válida
            vistaPoker.mostrarError("La apuesta no se pudo realizar. Verifica el monto y el saldo disponible.");
        }
    }

    public void noApostar(){
        mano.noApostar(jugador);
    }

    public void terminarMano(){
        mesa.comienzoMano();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        //EVENTOS MESA.
        System.out.println("ENTRÉ A ACTUALIZAR");
        System.out.println("EVENTO: " + evento);
        if(evento.equals(Mesa.eventos.cambioIniciada)){
            this.iniciarMesa();
        }
        else if(evento.equals(Mesa.eventos.nuevaMano)){
            mano = mesa.getManoActual();
        }
        else if(evento.equals(Mano.eventos.cambioEstadoMano)) {
            Mano.EstadoMano estado = mano.getEstadoMano();
            vistaPoker.mostrarEstadoMano(estado);
            if (estado == EstadoMano.TERMINADA) {
                terminarMano();
            }
        }
        this.actualizarDatosPantalla();
    }


}
