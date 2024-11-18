package controlador;
import java.util.ArrayList;

import logica.Carta;
import logica.Fachada;
import logica.Figura;
import logica.Jugador;
import logica.Mano;
import logica.Mesa;
import logica.PokerException;
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
        if(mesa != null){
            mesa.agregarObservador(this);
        }
        mano = mesa.getManoActual();
        mano.agregarObservador(this);
        if(mesa.esIniciada()){
            this.iniciarMano();
        }
        else{
            vistaPoker.mostrarMensajeInicial(mesa.getJugadoresActuales(), mesa.getMinJugadores());
        }
        this.actualizarDatosPantalla();
    }

    public void actualizarDatosPantalla(){
        vistaPoker.actualizarDatosPantalla(jugador.getNombreCompleto(), jugador.getSaldo(), mesa);
    }

    public void iniciarMano(){
        //se llama cuando se observó que la mesa pasó a iniciada.
        vistaPoker.mostrarCartas(jugador, mesa);
        vistaPoker.resetLabels();
        vistaPoker.mostrarFigurasDefinidas(Fachada.getInstancia().getFiguras());
        determinarFiguraMasAlta();
    }

    public void recargarPanel(){
        vistaPoker.recargarPanel();
    }

    public void determinarFiguraMasAlta(){
        Figura figura = jugador.figuraMasAlta();
        vistaPoker.mostrarFiguraMasAlta(figura);
    }

    public void apostar(String monto){
        //Valido que la apuesta no sean vacia
        if(monto.isEmpty()){
            vistaPoker.mostrarError("Debe completar el campo de apuesta");
            return;
        }
        //valido que solo contenga numeros
        if(!monto.matches("[0-9]+")){
            vistaPoker.mostrarError("El campo de apuesta debe contener solo números");
            return;
        }
        
        int montoInt = Integer.parseInt(monto);
        try {
            mano.apostar(montoInt, jugador);
        } catch (PokerException e) {
            vistaPoker.mostrarError(e.getMessage());
        }
        // Actualizar la vista con el valor de la apuesta y el estado de la mano
        vistaPoker.mostrarApuestaRealizada(jugador.getNombreCompleto(), montoInt);
        vistaPoker.mostrarEstadoMano(mano.getEstadoMano());
    }

    public void noApostar(){
        try {
            mano.noApostar(jugador);
        } catch (PokerException e) {
            vistaPoker.mostrarError(e.getMessage());
        }
    }

    public void terminarMano(){
        //Determinar ganador
        Jugador ganador = mano.determinarGanador();
        Figura figuraGanadora = ganador.figuraMasAlta();
        int montoGanado = mesa.calcularMontoGanado();
        //Tengo que mostrar, la figura ganadora, el jugador ganador, y el pozo.
        vistaPoker.mostrarGanador(ganador, figuraGanadora);
        mesa.getManoActual().darVueltaCartas();
        if (jugador == ganador) {
            vistaPoker.mostrarGanaste(montoGanado);
        }
    }

    public void comenzarMano(){
        try {
            mesa.esperarComienzoSiguienteMano(jugador);
        } catch (PokerException e) {
            vistaPoker.mostrarCartelError(e.getMessage());
            vistaPoker.cerrarVentana();
        }
    }

    public void pagar(){
        try {
            jugador.pagar(mesa.getUltimaApuesta().getMonto());
        } catch (PokerException e) {
            vistaPoker.mostrarError(e.getMessage());
        }
        
    }
    
    public int pedirCartas(){
        //Se valida cuantas de las cartas estan dadas vuelta, esas se descartan y se piden nuevas
        ArrayList<Carta> cartasACambiar = jugador.cartasACambiar();
        int cantidadCartasPedidas = cartasACambiar.size();
        try {
            mesa.pedirCartas(jugador, cartasACambiar);
        } catch (PokerException e) {
            vistaPoker.mostrarError(e.getMessage());
        }
        return cantidadCartasPedidas;
    }

    public void noPagar(){
        try {
            jugador.noPagar();
        } catch (PokerException e) {
            vistaPoker.mostrarError(e.getMessage());
        }
    }

    public void quitarJugadorDeMesa(){
        mesa.quitarJugador(jugador);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        System.out.println("Evento: " + evento + " Origen: " + origen);
        //Eventos mesa
        if(origen instanceof Mesa){
            if(evento.equals(Mesa.eventos.cambioIniciada)){
                this.iniciarMano();
            }
            else if(evento.equals(Mesa.eventos.nuevaMano)){
                mano.quitarObservador(this);
                mano = mesa.getManoActual();
                mano.agregarObservador(this);
                this.iniciarMano();
            } else if(evento.equals(Mesa.eventos.seCambiaronCartas)){
                vistaPoker.mostrarCartas(jugador, mesa);
                determinarFiguraMasAlta();
            } else if(evento.equals(Mesa.eventos.quedoUnJugador)){
                vistaPoker.mostrarQuedaUnJugador();
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
                        vistaPoker.mostrarMensajeApuesta(mesa.getUltimaApuesta());
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
