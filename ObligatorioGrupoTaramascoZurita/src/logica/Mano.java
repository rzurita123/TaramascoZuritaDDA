/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author sabrina
 */
public class Mano {
    private Jugador jugadorGanador;
    private EstadoMano estadoMano;
    public enum EstadoMano {
        ESPERANDO_APUESTA, APUESTA_INICIADA, PIDIENDO_CARTAS, TERMINADA
    }

    public Mano() {
        this.estadoMano = EstadoMano.ESPERANDO_APUESTA;
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
