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
    private static int contador = 0;
    private int id;
    private Jugador jugadorGanador;
    private EstadoMano estadoMano;
    private int apostadoEnLaMano;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Jugador> pidieronCartas = new ArrayList();
    public enum EstadoMano {
        ESPERANDO_APUESTA, APUESTA_INICIADA, PIDIENDO_CARTAS, TERMINADA
    }
    public enum eventos {cambioEstadoMano, nadieAposto};

    public Mano(ArrayList<Jugador> jugadoresMesa) {
        //Cuando arranca la mano tiene a todos los jugadores de la mesa.
        this.id = ++contador;
        jugadores = jugadoresMesa;
        this.estadoMano = EstadoMano.ESPERANDO_APUESTA;
    }
    
    //Constructor para mano cuando la mesa no inició.
    public Mano() {

    }

    public void apostar(int monto, Jugador jugador) throws PokerException{
        if (jugador.getEstadoJugador() == Jugador.EstadoJugador.NO_PAGO_APUESTA) {
            throw new PokerException("Ya no puede apostar");
        }
        if (estadoMano != EstadoMano.ESPERANDO_APUESTA) {
            throw new PokerException("No es posible realizar una apuesta en este momento.");
        }
        if (monto <= 0) {
            throw new PokerException("Apuesta mínima: 1$");
        }
        if (monto > jugador.getSaldo()){
            throw new PokerException("Apuesta máxima $ " + jugador.getSaldo());
        }
        jugador.descontarSaldo(monto, false);
        estadoMano = EstadoMano.APUESTA_INICIADA;
        avisar(eventos.cambioEstadoMano);
        validarEstadoJugadores();
    }

    public void validarEstadoJugadores(){
        boolean quedanSinJugar = false;
        boolean todosNoApostaron = true;
        System.out.println("CANTIDAD JUGADORES: " + jugadores.size());
        for (Jugador j : jugadores) {
            //Caso alguno hizo una apuesta
            System.out.println("Estado del jugador " + j.getNombreCompleto() + ": " + j.getEstadoJugador());
            if(j.getEstadoJugador() == Jugador.EstadoJugador.ACCION_PENDIENTE){
                quedanSinJugar = true;
            }
            if(j.getEstadoJugador() != Jugador.EstadoJugador.NO_APUESTA){
                todosNoApostaron = false;
            }
        }
        //Si ninguno apostó, la mano termina. Si alguno apostó y todos jugaron, se piden cartas.
        if (jugadores.size() == 1 && jugadores.get(0).getEstadoJugador() == Jugador.EstadoJugador.APUESTA_INICIADA) {
            estadoMano = EstadoMano.TERMINADA;
            avisar(eventos.cambioEstadoMano);
        } else if (!quedanSinJugar && !todosNoApostaron) {
            estadoMano = EstadoMano.PIDIENDO_CARTAS;
            avisar(eventos.cambioEstadoMano);
        } else if (todosNoApostaron) {
            estadoMano = EstadoMano.TERMINADA;
            avisar(eventos.nadieAposto);
        }
    }

    public void darVueltaCartas(){
        for (Jugador j : jugadores) {
            j.darVueltaCartas();
        }
    }

    public Jugador determinarGanador() {
        Jugador ganador = null;
        Figura mejorFigura = null;
        for (Jugador jugador : jugadores) {
            Figura figuraActual = jugador.figuraMasAlta(); // Método que retorna la figura del jugador
            ArrayList<Carta> cartasJugador = jugador.getCartas(); // Método que retorna las cartas del jugador
            if (mejorFigura == null) {
                // Primer jugador, inicializamos el ganador
                mejorFigura = figuraActual;
                ganador = jugador;
            } else {
                // Comparamos la figura actual con la mejor figura hasta ahora
                int comparacion = mejorFigura.compararFigura(figuraActual, ganador.getCartas(), cartasJugador);
                if (comparacion < 0) {
                    // La figura actual es mejor, actualizamos el ganador
                    mejorFigura = figuraActual;
                    ganador = jugador;
                }
            }
        }
        return ganador;
    }
    

    public void pidieronCartas(Jugador j){
        pidieronCartas.add(j);
        if(pidieronCartas.size() == jugadores.size()){
            terminarMano();
        }
    }

    public void terminarMano(){
        jugadorGanador = determinarGanador();
        System.out.println("El ganador de la mano es: " + jugadorGanador.getNombreCompleto());
        estadoMano = EstadoMano.TERMINADA;
        avisar(eventos.cambioEstadoMano);
        Fachada.getInstancia().avisar(Fachada.Eventos.huboCambioEnMesa);
    }

    public void noApostar(Jugador j) throws PokerException{
        if(estadoMano != EstadoMano.ESPERANDO_APUESTA){
            throw new PokerException("No es posible indicar que no deseas iniciar una apuesta en este momento.");
        }
        j.setEstadoJugador(Jugador.EstadoJugador.NO_APUESTA);
        validarEstadoJugadores();
    }

    public EstadoMano getEstadoMano() {
        return estadoMano;
    }

    public int getId() {
        return id;
    }

    public int getApostadoEnLaMano() {
        return apostadoEnLaMano;
    }

    public void setApostadoEnLaMano(int apostadoEnLaMano) {
        this.apostadoEnLaMano = apostadoEnLaMano;
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

    public ArrayList<Jugador> getPidieronCartas() {
        return pidieronCartas;
    }

    public void setPidieronCartas(ArrayList<Jugador> pidieronCartas) {
        this.pidieronCartas = pidieronCartas;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    //toString con -Número de mano -Cantidad de jugadores participantes -Total apostado en la mano -Estado actual de la mano (*2) -Nombre del jugador ganador -Nombre de la figura con la que ga
    @Override
    public String toString() {
        String nombreGanador;
        String figuraGanadora;
        if(jugadorGanador != null){
            nombreGanador = jugadorGanador.getNombreCompleto();
            figuraGanadora = jugadorGanador.figuraMasAlta().getNombre();
        } else {
            nombreGanador = "NO DEFINIDO";
            figuraGanadora = "NO DEFINIDA";
        }
        return "Mano " + id + " | " + "Cantidad de Jugadores: " + jugadores.size() + " | " + " Total apostado en la mano " + apostadoEnLaMano + " | " + " Estado actual de la mano " + estadoMano + " | " + " Jugador ganador " + nombreGanador + " | " + " Figura ganadora: " + figuraGanadora;
    }

}
