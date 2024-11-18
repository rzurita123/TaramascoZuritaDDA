package controlador;

import java.lang.reflect.Array;
import java.util.ArrayList;

import logica.Administrador;
import logica.Fachada;
import logica.Jugador;
import logica.Mesa;
import logica.PokerException;
import observador.Observable;
import observador.Observador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carry
 */
public class ControladorAdministrarMesas implements Observador{
    private VistaAdministrarMesas vistaAdministrarMesas;
    private Administrador administrador;
    private Mesa mesaSeleccionada;
    private Fachada fachada = Fachada.getInstancia();

    public ControladorAdministrarMesas(VistaAdministrarMesas vista, Administrador a) {
        vistaAdministrarMesas = vista;
        this.administrador = a;
        cargarMesas();
        fachada.agregarObservador(this);
    }

    public void logout(Administrador admin){
        fachada.quitarObservador(this);
        fachada.logout(fachada.getSesion(admin));
    }

    public void seleccionMesa(Mesa seleccionada) {
        //Tengo que cargar la lista de manos
        if(seleccionada==null){
            vistaAdministrarMesas.borrarManos();
        } else {
            mesaSeleccionada = seleccionada;
            vistaAdministrarMesas.mostrarManos(seleccionada.getManos());
        }

    }

    public void calcularMontoRecaudado(ArrayList<Mesa> mesas){
        vistaAdministrarMesas.mostrarMontoRecaudado(Fachada.getInstancia().recaudacionMesa());
    }

    public void cargarMesas(){
        vistaAdministrarMesas.cargarMesas(Fachada.getInstancia().getMesas());
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Fachada.Eventos.seCreoMesa)){
            vistaAdministrarMesas.actualizarMesas(Fachada.getInstancia().getMesas());
        } 
    }


}
