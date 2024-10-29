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
public class Jugador extends Usuario{
    private double saldo;
    private ArrayList<Carta> cartas = new ArrayList();
    private ArrayList<Mano> manos = new ArrayList();
    public enum EstadoJugador {
        ACCION_PENDIENTE, APUESTA_INICIADA, APUESTA_PAGADA, NO_PAGO_APUESTA
    }
    public EstadoJugador estadoJugador;
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public Jugador(String cedula, String contraseña, String nombreCompleto, double saldo) {
        super(cedula, contraseña, nombreCompleto);
        this.saldo = saldo;
        this.estadoJugador = EstadoJugador.ACCION_PENDIENTE;
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

    
    
    public boolean validarSaldo(double apuestaBase) {
        return this.saldo > apuestaBase * 10;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return nombreCompleto + " | " + estadoJugador;
    }
    
    
}
