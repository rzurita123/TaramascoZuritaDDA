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
public class Fachada extends Observable {
        
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaJuego sJuego = new SistemaJuego();
    
    //SINGLETON

    private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }

    public enum Eventos{seCreoMesa};
    
    private Fachada () {
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

    public int recaudacionMesa(){
        return sJuego.recaudacionMesa();
    }
    
    public ArrayList<Mesa> getMesasAbiertas(){
        return sJuego.getMesasAbiertas();
    }

    public ArrayList<Mesa> getMesas() {
        return sJuego.getMesas();
    }

    public Sesion getSesion(Usuario user) {
        return sAcceso.getSesion(user);
    }
    
    public String agregarMesa(int minJugadores, int apuestaBase, int porcentajeComision) {
        return sJuego.agregarMesa(minJugadores, apuestaBase, porcentajeComision);
    }

    public Figura getFiguraMasAlta(ArrayList<Carta> cartas) {
        return sJuego.getFiguraMasAlta(cartas);
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        sAcceso.agregarAdministrador(cedula, password, nombreCompleto);
    }

    public Jugador loginJugador(String cedula, String password) {
        return sAcceso.loginJugador(cedula, password);
    }

    public Administrador loginAdministrador(String cedula, String password) {
        return sAcceso.loginAdministrador(cedula, password);
    }

    public void logout(Sesion sesion){
        sAcceso.logout(sesion);
    }

    public boolean yaLogueado(Object user) {
        return sAcceso.yaLogueado((Usuario) user);
    }

    protected Usuario validarLoginJugador(String nom, String pwd) {
        return sAcceso.validarLoginJugador(nom, pwd);
    }

    protected Administrador validarLoginAdministrador(String nom, String pwd) {
        return sAcceso.validarLoginAdministrador(nom, pwd);
    }

    
}
