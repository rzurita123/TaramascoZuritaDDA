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

    public ArrayList<Carta> getCartas() {
        return cartas;
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

    public Jugador(String cedula, String contraseña, String nombreCompleto, double saldo) {
        super(cedula, contraseña, nombreCompleto);
        this.saldo = saldo;
    }
    
    public boolean validarSaldo(double apuestaBase) {
        return this.saldo > apuestaBase * 10;
    }

    public double getSaldo() {
        return saldo;
    }


    
    
}
