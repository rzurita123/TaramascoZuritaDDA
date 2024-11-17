package logica;

public class Apuesta {
    private int monto;
    private Jugador jugador;

    public Apuesta(int monto, Jugador jugador) {
        this.monto = monto;
        this.jugador = jugador;
    }

    public Apuesta() {
        this.monto = 0;
        this.jugador = null;
    }

    public int getMonto() {
        return monto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
