/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.lang.reflect.Array;
import java.util.ArrayList;

import logica.Mano.EstadoMano;
import logica.Mesa.EstadoMesa;

/**
 *
 * @author sabrina
 */
public class Jugador extends Usuario{
    private int saldo;
    private ArrayList<Carta> cartas = new ArrayList();
    private ArrayList<Mano> manos = new ArrayList();
    public enum EstadoJugador {
        ACCION_PENDIENTE, NO_APUESTA, APUESTA_INICIADA, APUESTA_PAGADA, NO_PAGO_APUESTA
    }
    public enum eventos {cambioEstadoJugador};
    public EstadoJugador estadoJugador;
    public Mesa mesa;
    public int ultimaApuesta;
    public Figura figura;

    public Jugador(String cedula, String contraseña, String nombreCompleto, int saldo) {
        super(cedula, contraseña, nombreCompleto);
        this.saldo = saldo;
        this.estadoJugador = EstadoJugador.ACCION_PENDIENTE;
        this.ultimaApuesta = 0;
    }

    //Jugador analiza cual es la mejor figura que tiene con sus cartas.
    public Figura figuraMasAlta() {
        figura = Fachada.getInstancia().getFiguraMasAlta(cartas);
        return figura;
    }

    public boolean descontarSaldo(int monto, boolean esApuestaBase){
        if(this.saldo < monto){
            return false;
        }
        this.ultimaApuesta = monto;
        if(!esApuestaBase){
            this.estadoJugador = EstadoJugador.APUESTA_INICIADA;
        }
        this.saldo -= monto;
        mesa.agregarApuesta(monto, this);
        return true;
    }

    public void darVueltaCartas(){
        for (Carta carta : cartas) {
            carta.setVisible(true);
        }
    }

    public ArrayList<Carta> cartasACambiar(){
        ArrayList<Carta> aCambiar = new ArrayList();
        for (Carta carta : cartas) {
            if (!carta.estaVisible()){
                aCambiar.add(carta);
            }
        }
        return aCambiar;
    }

    public void pagar(int monto) throws PokerException {
        Mano mano = mesa.getManoActual();
        if(mano.getEstadoMano() != EstadoMano.APUESTA_INICIADA){
            throw new PokerException("No es posible pagar una apuesta en este momento.");
        }
        if(monto > saldo){
            throw new PokerException("Saldo insuficiente");
        }
        if(estadoJugador == EstadoJugador.APUESTA_PAGADA){
            throw new PokerException("Ya pagaste esta apuesta.");
        }
        if(mesa.getUltimaApuesta().getJugador().equals(this)){
            throw new PokerException("Tú iniciaste esta apuesta");
        }
        this.ultimaApuesta = monto;
        this.estadoJugador = EstadoJugador.APUESTA_PAGADA;
        this.saldo -= monto;
        mesa.agregarApuesta(monto, this);
        avisar(eventos.cambioEstadoJugador);
    }

    public void noPagar() throws PokerException {
        Mano mano = mesa.getManoActual();
        if(mano.getEstadoMano() != EstadoMano.APUESTA_INICIADA){
            throw new PokerException("No es posible pasar en este momento.");
        }if(estadoJugador == EstadoJugador.NO_PAGO_APUESTA){
            throw new PokerException("Ya pasaste esta apuesta.");
        }if(mesa.getUltimaApuesta().getJugador().equals(this)){
            throw new PokerException("Tú iniciaste esta apuesta");
        }
        this.estadoJugador = EstadoJugador.NO_PAGO_APUESTA;
        avisar(eventos.cambioEstadoJugador);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setEstadoJugador(EstadoJugador estadoJugador) {
        this.estadoJugador = estadoJugador;
    }

    public EstadoJugador getEstadoJugador() {
        return estadoJugador;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public ArrayList<Mano> getManos() {
        return manos;
    }

    public void setManos(ArrayList<Mano> manos) {
        this.manos = manos;
    }
    
    public boolean validarSaldo(int apuestaBase) {
        return this.saldo > apuestaBase * 10;
    }

    public int getSaldo() {
        return saldo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + " | " + "Situación: " + estadoJugador + " | " + "Última apuesta: " + ultimaApuesta;
    }
    
}
