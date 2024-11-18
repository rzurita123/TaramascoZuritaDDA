/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

import logica.Jugador.EstadoJugador;
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
    private Apuesta ultimaApuesta;
    private int porcentajeComision;
    private EstadoMesa estadoMesa;
    private Mazo mazo;
    public enum EstadoMesa {
        ABIERTA, FINALIZADA, INICIADA
    }
    public enum eventos {cambioIniciada, nuevaMano, seCambiaronCartas, quedoUnJugador};

    public Mesa(int minJugadores, int apuestaBase, int porcentajeComision) {
        this.id = ++contador;
        this.minJugadores = minJugadores;
        this.apuestaBase = apuestaBase;
        this.ultimaApuesta = new Apuesta();
        this.porcentajeComision = porcentajeComision;
        this.estadoMesa = EstadoMesa.ABIERTA;
        this.jugadoresActuales = 0;
        this.pozo = 0;
        this.mazo = new Mazo();
        this.manoActual = new Mano();
    }



    //Cuando un jugador quiere volver a jugar. Si tiene saldo, se lo agrega. si todos estan listos, inicia la mano.
    public void esperarComienzoSiguienteMano(Jugador j) throws PokerException {
        boolean saldoDescontado = j.descontarSaldo(apuestaBase, true);
        if (!saldoDescontado) {
            quitarJugador(j);
        } else {
            j.setEstadoJugador(EstadoJugador.ACCION_PENDIENTE);
        }
        boolean todosProntos = validarEstadoJugadores();
        if (todosProntos) {
            nuevaMano();
        }
        if (!saldoDescontado) {
            throw new PokerException("No tienes saldo para continuar jugando.");
        }
    }

    public void validarCantidadJugadores(){
        if(jugadoresActuales == 1){
            manoActual.terminarMano();
            avisar(eventos.quedoUnJugador);
        }
    }

    public int getMontoRecaudado(){
        return pozo;
    }

    public boolean validarEstadoJugadores(){
        boolean todosProntos = true;
        for(Jugador j : jugadores){
            if(j.getEstadoJugador() != EstadoJugador.ACCION_PENDIENTE){
                todosProntos = false;
            }
        }
        return todosProntos;
    }

    public void comienzoMano(){
        //Le resto a cada jugador la apuesta base
        for (Jugador j : jugadores) {
            //Si no se pudo descontar el saldo, elimino al jugador de la mesa.
            if(!j.descontarSaldo(apuestaBase, true)){
                quitarJugador(j);
            }
        }
        //Se genera la mano con los jugadores que tengan saldo suficiente.
        nuevaMano();
    }

    public void nuevaMano(){
        System.out.println("JUGADORES MESA: " + jugadores.size());
        manoActual = new Mano(jugadores);
        manos.add(manoActual);
        this.repartir();
        avisar(eventos.nuevaMano);
    }

    public void pedirCartas(Jugador j, ArrayList<Carta> cartasACambiar) throws PokerException{
        //Si el jugador no pagó la apuesta, no puede pedir cartas.
        //Si las cartas del jugador no contienen las cartas a cambiar, no se pueden cambiar.
        if(manoActual.getPidieronCartas().contains(j)){
            throw new PokerException("Ya pediste cartas en esta mano.");
        }
        if(j.getEstadoJugador() == EstadoJugador.NO_PAGO_APUESTA){
            throw new PokerException("No pagaste la apuesta. No puedes pedir cartas.");
        }
        if(manoActual.getEstadoMano() != Mano.EstadoMano.PIDIENDO_CARTAS){
            throw new PokerException("No es posible pedir cartas en este momento.");
        }
        mazo.cambiarCartas(j, cartasACambiar);
        manoActual.pidieronCartas(j);
        avisar(eventos.seCambiaronCartas);
    }

    public void agregarApuesta(int monto, Jugador jugador){
        this.pozo += monto;
        ultimaApuesta.setMonto(monto);
        ultimaApuesta.setJugador(jugador);
    }
    
    public String listadoJugadores(){
       //recorre la lista de jugadores y genera un string con los tostring de cada uno
         String listado = "";
        for (Jugador j : jugadores) {
            listado += j.toString() + "\n";
        }
        return listado;
    }

    public int calcularMontoGanado() {
        int montoGanado = pozo - (pozo * porcentajeComision / 100);
        return montoGanado;
    }
    
    public void agregarJugador(Jugador j) throws PokerException {
        if (!j.validarSaldo(apuestaBase)) {
            throw new PokerException("Saldo insuficiente");
        } else if (this.jugadoresActuales >= this.minJugadores) {
            throw new PokerException("La mesa está llena");
        } else if (j.getMesa() != null) {
            throw new PokerException("El jugador ya está en una mesa");
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
            j.getCartas().clear();
            mazo.repartir(j);
        }
    }

    public void quitarJugador(Jugador j){
        jugadores.remove(j);
        jugadoresActuales--;
        j.setMesa(null);
        validarCantidadJugadores();
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

    public Apuesta getUltimaApuesta() {
        return ultimaApuesta;
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