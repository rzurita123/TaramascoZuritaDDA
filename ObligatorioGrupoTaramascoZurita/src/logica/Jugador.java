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
    public Figura figura;

    public Jugador(String cedula, String contraseña, String nombreCompleto, int saldo) {
        super(cedula, contraseña, nombreCompleto);
        this.saldo = saldo;
        this.estadoJugador = EstadoJugador.ACCION_PENDIENTE;
        this.ultimaApuesta = new Apuesta(0);
    }

    //Jugador analiza cual es la mejor figura que tiene con sus cartas.
    public Figura figuraMasAlta() {
        figura = Fachada.getInstancia().getFiguraMasAlta(cartas);
        return figura;
    }

    public boolean descontarSaldo(int monto, boolean esApuestaBase){
        if(this.saldo < monto){
            return false;
        } else {
            this.ultimaApuesta.setMonto(monto);
            if(!esApuestaBase){
                this.estadoJugador = EstadoJugador.APUESTA_INICIADA;
            }
            this.saldo -= monto;
            mesa.agregarApuesta(monto);
            return true;
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
        return "Nombre: " + nombreCompleto + " | " + "Situación: " + estadoJugador + " | " + "Última apuesta: " + ultimaApuesta.getMonto();
    }


    
    
}
