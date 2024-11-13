/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;

import logica.Figura;
import logica.Jugador;
import logica.Mano;
import logica.Mesa;

/**
 *
 * @author Carry
 */
public interface VistaIngresoAMesa {
    public void mostrarDatosJugador(String nombre, int saldo);
    public void cargarMesasAbiertas(ArrayList<Mesa> listaMesas);
    public void mostrarError(String mensaje);
    public void mostrarDetalles(int id, int minJugadores, int apuestaBase, int jugadoresActuales, int porcentajeComision);
    public void borrarDetalles();
}
