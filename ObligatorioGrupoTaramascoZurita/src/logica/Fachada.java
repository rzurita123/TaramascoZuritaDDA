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
public class Fachada {
        
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaJuego sJuego = new SistemaJuego();
    
    //SINGLETON

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada() {
    }
    
    //DELEGACIONES

    public void agregarFiguras() {
        sJuego.agregarFiguras();
    }

    public ArrayList<Figura> getFiguras() {
        return sJuego.getFiguras();
    }

    public void agregarJugador(String cedula, String password, String nombreCompleto, int saldo) {
        sAcceso.agregarJugador(cedula, password, nombreCompleto, saldo);
    }
    
    public ArrayList<Mesa> getMesasAbiertas(){
        return sJuego.getMesasAbiertas();
    }
    
    public void agregarMesa(int minJugadores, int apuestaBase, int porcentajeComision) {
        sJuego.agregarMesa(minJugadores, apuestaBase, porcentajeComision);
    }

    public Figura getFiguraMasAlta(ArrayList<Carta> cartas) {
        return sJuego.getFiguraMasAlta(cartas);
    }

    public Jugador loginJugador(String cedula, String password) {
        return sAcceso.loginJugador(cedula, password);
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        sAcceso.agregarAdministrador(cedula, password, nombreCompleto);
    }

    public Administrador loginAdministrador(String cedula, String password) {
        return sAcceso.loginAdministrador(cedula, password);
    }
    
    
}
