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
        j.agregarObservador(this);
        this.mesa = jugador.getMesa();
        mesa.agregarObservador(this);
        mano = mesa.getManoActual();
        mano.agregarObservador(this);
        if(mesa.esIniciada()){
            this.iniciarMesa();
        }
        else{
            vistaPoker.mostrarMensajeInicial(mesa.getJugadoresActuales(), mesa.getMinJugadores());
        }
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
        } else {
            // Muestra un mensaje de error en la vista si la apuesta no es válida
            vistaPoker.mostrarError("La apuesta no se pudo realizar. Verifica el monto y el saldo disponible.");
        }
    }

    public void noApostar(){
        mano.noApostar(jugador);
    }

    public void terminarMano(){
        System.out.println("La mano ha terminado");
        mesa.comienzoMano();
    }

    public void pagar(){
        //TODO: Que pasa si no le da la $?
        boolean saldoDescontado = jugador.pagar(mesa.getUltimaApuesta());
        if (saldoDescontado){
            vistaPoker.ocultarMensajeApuesta();
        }
    }

    public void noPagar(){
        jugador.noPagar();
        vistaPoker.ocultarMensajeApuesta();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        System.out.println("Evento: " + evento + " Origen: " + origen);
        //Eventos mesa
        if(origen instanceof Mesa){
            if(evento.equals(Mesa.eventos.cambioIniciada)){
                this.iniciarMesa();
            }
            else if(evento.equals(Mesa.eventos.nuevaMano)){
                mano = mesa.getManoActual();
                mano.agregarObservador(this);
            }
        }
        //Eventos mano
        if(origen instanceof Mano){
            //Cambio de estado
            if(evento.equals(Mano.eventos.cambioEstadoMano)) {
                Mano.EstadoMano estado = mano.getEstadoMano();
                vistaPoker.mostrarEstadoMano(estado);
                if (estado == EstadoMano.TERMINADA) {
                    terminarMano();
                } else if (estado == EstadoMano.APUESTA_INICIADA) {
                    if(jugador.getEstadoJugador() != Jugador.EstadoJugador.APUESTA_INICIADA){
                        vistaPoker.mostrarMensajeApuesta(mesa.getUltimaApuesta(), jugador.getNombreCompleto());
                    }
                    
                }
            }
        }
        //Eventos jugador
        if(origen instanceof Jugador){
            if(evento.equals(Jugador.eventos.cambioEstadoJugador)){
                if(jugador.getEstadoJugador() == Jugador.EstadoJugador.NO_PAGO_APUESTA){
                    mano.getJugadores().remove(jugador);
                }
                mano.validarEstadoJugadores();
            }
        }
        this.actualizarDatosPantalla();
    }
}
