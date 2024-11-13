package controlador;

import java.util.ArrayList;

import logica.Carta;
import logica.Fachada;
import logica.Figura;
import logica.Jugador;
import logica.JugadorException;
import logica.Mesa;
import logica.MesaException;
import observador.Observable;
import observador.Observador;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carry
 */
public class ControladorIngresoAMesa implements Observador{
    private VistaIngresoAMesa vistaIngresoAMesa;
    private Jugador jugador;
    private Mesa mesaSeleccionada;

    public ControladorIngresoAMesa(VistaIngresoAMesa vista, Jugador j) {
        vistaIngresoAMesa = vista;
        this.jugador = j;
        mostrarDatosJugador();
        cargarMesasAbiertas();
    }

    public void ingresarAMesa(){
        try{
            mesaSeleccionada.agregarJugador(jugador);
        } catch (MesaException e) {
            vistaIngresoAMesa.mostrarError(e.getMessage());
        }
    }

    public void seleccionMesa(Mesa seleccionada) {
        if(seleccionada==null){
            vistaIngresoAMesa.borrarDetalles();
        } else {
            mesaSeleccionada = seleccionada;
            vistaIngresoAMesa.mostrarDetalles(seleccionada.getId(),
                                        seleccionada.getMinJugadores(),
                                        seleccionada.getApuestaBase(),
                                        seleccionada.getJugadoresActuales(),
                                        seleccionada.getPorcentajeComision());
        }
    }

    public void mostrarDatosJugador(){
        vistaIngresoAMesa.mostrarDatosJugador(jugador.getNombreCompleto(), jugador.getSaldo());
    }

    public void cargarMesasAbiertas(){
        vistaIngresoAMesa.cargarMesasAbiertas(Fachada.getInstancia().getMesasAbiertas());
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        /*if(evento.equals(Mesa.eventos.cambioIniciada)){
            System.out.println("La mesa se ha iniciado");
            this.iniciarMesa();
        } */
    }


}
