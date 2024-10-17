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

    public void agregarJugador(String cedula, String password, String nombreCompleto, double saldo) {
        sAcceso.agregarJugador(cedula, password, nombreCompleto, saldo);
    }

    public Jugador loginJugador(String cedula, String password) {
        return sAcceso.loginAgenda(cedula, password);
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        sAcceso.agregarAdministrador(cedula, password, nombreCompleto);
    }

    public Administrador loginAdministrador(String cedula, String password) {
        return sAcceso.loginAdministrador(cedula, password);
    }
    
    
}
