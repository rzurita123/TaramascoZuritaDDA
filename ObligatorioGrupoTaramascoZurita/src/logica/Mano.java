/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

import observador.Observable;
/**
 *
 * @author sabrina
 */
public class Mano extends Observable {
    private Jugador jugadorGanador;
    private EstadoMano estadoMano;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private int jugadasRealizadas = 0;

    public enum EstadoMano {
        ESPERANDO_APUESTA, APUESTA_INICIADA, PIDIENDO_CARTAS, TERMINADA
    }
    public enum eventos {cambioEstadoMano};
    public Mano(ArrayList<Jugador> jugadoresMesa) {
        //Cuando arranca la mano tiene a todos los jugadores de la mesa.
        System.out.println("CREO UNA NUEVA MANO CON JUGADORES: " + jugadoresMesa.size());
        jugadores = jugadoresMesa;
        this.estadoMano = EstadoMano.ESPERANDO_APUESTA;
        avisar(eventos.cambioEstadoMano);
        System.out.println("AVISÉ LA MANO");
    }
    //Constructor para mano cuando la mesa no inició.
    public Mano() {

    }

    public boolean apostar(int monto, Jugador jugador) {
        //TODO: Manejar SOUTS con excepciones.
         if (monto <= 0 || monto > jugador.getSaldo()) {
            System.out.println("Apuesta inválida. El monto debe ser positivo y dentro del saldo del jugador.");
            return false;
        }
        jugador.descontarSaldo(monto, false);
        //pozo += monto;
        estadoMano = EstadoMano.APUESTA_INICIADA;
        System.out.println("Estado actual de la mano: " + estadoMano);
        avisar(eventos.cambioEstadoMano);
        validarEstadoJugadores();
        System.out.println("El jugador " + jugador.getNombreCompleto() + " ha iniciado una apuesta de $" + monto);
        System.out.println("Estado actual de la mano: " + estadoMano);
        return true;
    }

    public void validarEstadoJugadores(){
        boolean ningunoAposto = true;
        boolean quedanSinJugar = false;
        System.out.println("CANTIDAD JUGADORES: " + jugadores.size());
        for (Jugador j : jugadores) {
            //Caso alguno hizo una apuesta
            System.out.println("Estado del jugador " + j.getNombreCompleto() + ": " + j.getEstadoJugador());
            if(j.getEstadoJugador() != Jugador.EstadoJugador.NO_PAGO_APUESTA && j.getEstadoJugador() != Jugador.EstadoJugador.APUESTA_INICIADA){
                ningunoAposto = false;
            }
            if(j.getEstadoJugador() == Jugador.EstadoJugador.ACCION_PENDIENTE){
                quedanSinJugar = true;
            }
        }
        //Si ninguno apostó, la mano termina. Si alguno apostó y todos jugaron, se piden cartas.
        if (ningunoAposto){
            estadoMano = EstadoMano.TERMINADA;
            avisar(eventos.cambioEstadoMano);
        } else if (!quedanSinJugar) {
            estadoMano = EstadoMano.PIDIENDO_CARTAS;
            avisar(eventos.cambioEstadoMano);
        }
    }

    public void noApostar(Jugador jugador){
        jugador.noPagar();
    }

    public int getJugadasRealizadas() {
        return jugadasRealizadas;
    }

    public void setJugadasRealizadas(int jugadasRealizadas) {
        this.jugadasRealizadas = jugadasRealizadas;
    }

    public EstadoMano getEstadoMano() {
        return estadoMano;
    }

    public void setEstadoMano(EstadoMano estadoMano) {
        this.estadoMano = estadoMano;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }


}
