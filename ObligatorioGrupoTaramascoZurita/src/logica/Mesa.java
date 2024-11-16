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
    private int ultimaApuesta;
    private int porcentajeComision;
    private EstadoMesa estadoMesa;
    private Mazo mazo;
    public enum EstadoMesa {
        ABIERTA, FINALIZADA, INICIADA
    }
    public enum eventos {cambioIniciada, nuevaMano};

    public Mesa(int minJugadores, int apuestaBase, int porcentajeComision) {
        this.id = ++contador;
        this.minJugadores = minJugadores;
        this.apuestaBase = apuestaBase;
        this.ultimaApuesta = 0;
        this.porcentajeComision = porcentajeComision;
        this.estadoMesa = EstadoMesa.ABIERTA;
        this.jugadoresActuales = 0;
        this.pozo = 0;
        this.mazo = new Mazo();
        this.manoActual = new Mano();
    }

    public void apostar(Jugador j, int apuesta) {
        this.pozo += apuesta;
        manoActual.setJugadasRealizadas(manoActual.getJugadasRealizadas() + 1);
    }

    public void comienzoMano(){
        //Le resto a cada jugador la apuesta base
        for (Jugador j : jugadores) {
            //Si no se pudo descontar el saldo, elimino al jugador de la mesa.
            if(!j.descontarSaldo(apuestaBase, true)){
                jugadores.remove(j);
            }
        }
        //Se genera la mano con los jugadores que tengan saldo suficiente.
        System.out.println("JUGADORES MESA: " + jugadores.size());
        manoActual = new Mano(jugadores);
        avisar(eventos.nuevaMano);
        this.pozo += jugadores.size() * apuestaBase;
        this.repartir();
    }

    public void agregarApuesta(int monto){
        this.pozo += monto;
        ultimaApuesta = monto;
    }
    
    public String listadoJugadores(){
       //recorre la lista de jugadores y genera un string con los tostring de cada uno
         String listado = "";
        for (Jugador j : jugadores) {
            listado += j.toString() + "\n";
        }
        return listado;
    }
    
    public void agregarJugador(Jugador j) throws MesaException {
        if (j.getSaldo() < this.apuestaBase) {
            throw new MesaException("Saldo insuficiente");
        } else if (this.jugadoresActuales >= this.minJugadores) {
            throw new MesaException("La mesa está llena");
        } else if (j.getMesa() != null) {
            throw new MesaException("El jugador ya está en una mesa");
        } else {
            this.jugadoresActuales++;
            this.jugadores.add(j);
            j.setMesa(this);
            //avisar(eventos.entroJugador);
        }
        //Después de agregar al jugador, valido estado de la mesa
        if (this.jugadoresActuales == this.minJugadores) {
            estadoMesa = EstadoMesa.INICIADA;
            comienzoMano();
            avisar(eventos.cambioIniciada);
        }
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

    public int getUltimaApuesta() {
        return ultimaApuesta;
    }

    public void setUltimaApuesta(int ultimaApuesta) {
        this.ultimaApuesta = ultimaApuesta;
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