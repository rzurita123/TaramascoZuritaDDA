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
public class Mesa {
    private static int contador = 0;
    private int id;
    private int minJugadores;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Mano> manos = new ArrayList();
    private Mano manoActual;
    private double apuestaBase;
    private int jugadoresActuales;
    private int porcentajeComision;
    private EstadoMesa estadoMesa;

    public Mesa(int minJugadores, double apuestaBase, int porcentajeComision) {
        this.id = ++contador;
        this.minJugadores = minJugadores;
        this.apuestaBase = apuestaBase;
        this.porcentajeComision = porcentajeComision;
        this.estadoMesa = EstadoMesa.ABIERTA;
        this.jugadoresActuales = 0;
    }
    
    public boolean esAbierta() {
        return estadoMesa == EstadoMesa.ABIERTA;
    }
    
    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinJugadores() {
        return minJugadores;
    }

    public void setMinJugadores(int minJugadores) {
        this.minJugadores = minJugadores;
    }

    public double getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(double apuestaBase) {
        this.apuestaBase = apuestaBase;
    }

    public int getJugadoresActuales() {
        return jugadoresActuales;
    }

    public void setJugadoresActuales(int jugadoresActuales) {
        this.jugadoresActuales = jugadoresActuales;
    }

    public int getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(int porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }
    
    @Override
public String toString() {
    return "Número de mesa: " + id + "\n";
}
}