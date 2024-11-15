/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author sabrina
 */
public class Mano {
    private Jugador jugadorGanador;
    private EstadoMano estadoMano;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private int jugadasRealizadas = 0;

    public enum EstadoMano {
        ESPERANDO_APUESTA, APUESTA_INICIADA, PIDIENDO_CARTAS, TERMINADA
    }

    public Mano() {
        this.estadoMano = EstadoMano.ESPERANDO_APUESTA;
    }

    public boolean apostar(int monto, Jugador jugador) {
        //TODO: Manejar SOUTS con excepciones.
         if (monto <= 0 || monto > jugador.getSaldo()) {
            System.out.println("Apuesta inválida. El monto debe ser positivo y dentro del saldo del jugador.");
            return false;
        }
        jugador.descontarSaldo(monto);
        //pozo += monto;
        estadoMano = EstadoMano.APUESTA_INICIADA;
        System.out.println("El jugador " + jugador.getNombreCompleto() + " ha iniciado una apuesta de $" + monto);
        System.out.println("Estado actual de la mano: " + estadoMano);
        return true;

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

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }


}
