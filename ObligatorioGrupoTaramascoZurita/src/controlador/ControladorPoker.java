package controlador;

import java.util.ArrayList;

import logica.Carta;
import logica.Jugador;
import logica.Mesa;
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
public class ControladorPoker implements Observador{
    private VistaPoker vistaPoker;
    private Mesa mesa;
    private Jugador jugador;

    public ControladorPoker(VistaPoker vistaPoker, Jugador jugador) {
        this.jugador = jugador;
        this.mesa = jugador.getMesa();
        mesa.agregarObservador(this);
        this.vistaPoker = vistaPoker;
        vistaPoker.mostrarMensaje(mesa.getJugadoresActuales(), mesa.getMinJugadores());
        this.actualizarDatosPantalla();
    }

    public void actualizarDatosPantalla(){
        vistaPoker.actualizarDatosPantalla(jugador.getNombreCompleto(), jugador.getSaldo(), mesa.getId(), mesa.getPozo(), mesa.getManos().size(), mesa.getManoActual().getEstadoMano());
    }

    public void iniciarMesa(){
        mesa.iniciarMesa();
        vistaPoker.mostrarCartas(jugador, mesa);
        this.actualizarDatosPantalla();
    }

    public void apostar(int monto, boolean actualizarEstadoMano){
        jugador.apostar(monto, actualizarEstadoMano);
        this.actualizarDatosPantalla();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        //CASO ENTRÓ LA GENTE NECESARIA PARA INICIAR LA MESA
        if(evento.equals(Mesa.eventos.cambioIniciada)){
            this.iniciarMesa();
        }
        else if(evento.equals(Mesa.eventos.cambioCerrada)){
            //TODO: Mostrar interfaz de mesa cerrada
        }
    }


}
