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
    private int pozo;
    private int apuestaBase;
    private int jugadoresActuales;
    private int porcentajeComision;
    private EstadoMesa estadoMesa;
    private Mazo mazo;
    public enum EstadoMesa {
        ABIERTA, FINALIZADA, INICIADA
    }
    public enum eventos {cambioIniciada, cambioCerrada, entroJugador};

    public Mesa(int minJugadores, int apuestaBase, int porcentajeComision) {
        this.id = ++contador;
        this.minJugadores = minJugadores;
        this.apuestaBase = apuestaBase;
        this.porcentajeComision = porcentajeComision;
        this.estadoMesa = EstadoMesa.ABIERTA;
        this.manoActual = new Mano();
        this.jugadoresActuales = 0;
        this.pozo = 0;
        this.mazo = new Mazo();
    }

    public void comienzoPartida(){
        //Le resto a cada jugador la apuesta base
        for (Jugador j : jugadores) {
            j.apostar(apuestaBase, false);
        }
        this.repartir();
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
            //avisar(eventos.entroJugador);
        }
        //Después de agregar al jugador, valido estado de la mesa
        if (this.jugadoresActuales == this.minJugadores) {
            estadoMesa = EstadoMesa.INICIADA;
            comienzoPartida();
            avisar(eventos.cambioIniciada);
        }
        return agregueJugador;
    }

    public void repartir(){
        //Para cada jugador, llama al metodo repartir de mazo
        for (Jugador j : jugadores) {
            mazo.repartir(j);
        }
    }
    
    public boolean esAbierta() {
        return estadoMesa == EstadoMesa.ABIERTA;
    }

    public boolean esIniciada() {
        return estadoMesa == EstadoMesa.INICIADA;
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

    public int getPozo() {
        return pozo;
    }

    public void setPozo(int pozo) {
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

    public int getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(int apuestaBase) {
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