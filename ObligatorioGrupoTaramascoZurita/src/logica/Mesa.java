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
public class Mesa extends Observable{
    private static int contador = 0;
    private int id;
    private int minJugadores;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Mano> manos = new ArrayList();
    private Mano manoActual;
    private double pozo;
    private double apuestaBase;
    private int jugadoresActuales;
    private int porcentajeComision;
    private EstadoMesa estadoMesa;
    public enum EstadoMesa {
        ABIERTA, FINALIZADA, INICIADA
    }
    public enum eventos {cambioIniciada, cambioCerrada};

    public Mesa(int minJugadores, double apuestaBase, int porcentajeComision) {
        this.id = ++contador;
        this.minJugadores = minJugadores;
        this.apuestaBase = apuestaBase;
        this.porcentajeComision = porcentajeComision;
        this.estadoMesa = EstadoMesa.ABIERTA;
        this.manoActual = new Mano();
        this.jugadoresActuales = 0;
        this.pozo = 0;
    }
    
    public String listadoJugadores(){
       //recorre la lista de jugadores y genera un string con los tostring de cada uno
         String listado = "";
        for (Jugador j : jugadores) {
            listado += j.toString() + "\n";
        }
        return listado;
    }
    
    public boolean agregarJugador(Jugador j) {
        boolean agregueJugador = false;
        if (this.jugadoresActuales < this.minJugadores) {
            this.jugadoresActuales++;
            this.jugadores.add(j);
            agregueJugador = true;
        }
        //Después de agregar al jugador, valido estado de la mesa
        if (this.jugadoresActuales == this.minJugadores) {
            estadoMesa = EstadoMesa.INICIADA;
            avisar(eventos.cambioIniciada);
        }
        return agregueJugador;
    }
    
    public boolean esAbierta() {
        return estadoMesa == EstadoMesa.ABIERTA;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Mesa.contador = contador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Mano> getManos() {
        return manos;
    }

    public void setManos(ArrayList<Mano> manos) {
        this.manos = manos;
    }

    public Mano getManoActual() {
        return manoActual;
    }

    public void setManoActual(Mano manoActual) {
        this.manoActual = manoActual;
    }

    public double getPozo() {
        return pozo;
    }

    public void setPozo(double pozo) {
        this.pozo = pozo;
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