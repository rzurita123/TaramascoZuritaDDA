/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Jugador;
import logica.Mano;
import logica.Mesa;

/**
 *
 * @author Carry
 */
public interface VistaPoker {
    public void mostrarMensaje(int jugadoresActuales, int minJugadores);
    public void actualizarDatosPantalla(String nombreJugador, int saldoJugador, int idMesa, int pozoMesa, int manosMesa, Mano.EstadoMano estadoMano);
    public void mostrarCartas(Jugador jugador, Mesa mesa);
}
