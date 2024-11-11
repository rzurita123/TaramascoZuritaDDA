/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

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
        ACCION_PENDIENTE, APUESTA_INICIADA, APUESTA_PAGADA, NO_PAGO_APUESTA
    }
    public EstadoJugador estadoJugador;
    public Mesa mesa;
    public Apuesta ultimaApuesta;

    public Jugador(String cedula, String contraseña, String nombreCompleto, int saldo) {
        super(cedula, contraseña, nombreCompleto);
        this.saldo = saldo;
        this.estadoJugador = EstadoJugador.ACCION_PENDIENTE;
        this.ultimaApuesta = new Apuesta(0);
    }

    public void apostar(int monto, boolean actualizarEstadoMano) {
        this.saldo -= monto;
        this.ultimaApuesta = new Apuesta(monto);
        System.out.println("Saldo restante: " + this.saldo);
        System.out.println("Monto apostado: " + monto);
        mesa.setPozo(mesa.getPozo() + monto);
        if(actualizarEstadoMano){
            mesa.getManoActual().setEstadoMano(EstadoMano.APUESTA_INICIADA);
        }
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
        return "Nombre: " + nombreCompleto + " | " + "Estado: " + estadoJugador + " | " + "Última apuesta: " + ultimaApuesta.getMonto();
    }


    
    
}
