/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;

import logica.Apuesta;
import logica.Figura;
import logica.Jugador;
import logica.Mano;
import logica.Mesa;

/**
 *
 * @author Carry
 */
public interface VistaPoker {
    public void mostrarMensajeInicial(int jugadoresActuales, int minJugadores);
    public void actualizarDatosPantalla(String nombreJugador, int saldoJugador, int idMesa, int pozoMesa, int manosMesa, Mano.EstadoMano estadoMano);
    public void mostrarCartas(Jugador jugador, Mesa mesa);
    public void mostrarFiguraMasAlta(Figura figura);
    public void mostrarFigurasDefinidas(ArrayList<Figura> figuras);
    public void mostrarApuestaRealizada(String nombre, int monto);
    public void mostrarEstadoMano(Mano.EstadoMano estadoMano);
    public void mostrarError(String mensaje);
    public void mostrarMensajeApuesta(Apuesta apuesta);
    public void mostrarGanador(Jugador jugador, Figura figura);
    public void mostrarGanaste(int montoGanado);
}
