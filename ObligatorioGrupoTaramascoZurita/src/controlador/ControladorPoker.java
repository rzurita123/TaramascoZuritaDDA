package controlador;

import java.util.ArrayList;

import logica.Carta;
import logica.Fachada;
import logica.Figura;
import logica.Jugador;
import logica.Mano;
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
    private Mano mano;
    public ControladorPoker(VistaPoker vistaPoker, Jugador j) {
        this.vistaPoker = vistaPoker;
        this.jugador = j;
        this.mesa = jugador.getMesa();
        this.mano = mesa.getManoActual();
        mesa.agregarObservador(this);
        if(mesa.esIniciada()){
            this.iniciarMesa();
        }
        else{
            vistaPoker.mostrarMensajeInicial(mesa.getJugadoresActuales(), mesa.getMinJugadores());
        }
        //TODO: Ver si actualizarDatosPantalla se maneja mejor con un observador.
        this.actualizarDatosPantalla();
    }

    public void actualizarDatosPantalla(){
        vistaPoker.actualizarDatosPantalla(jugador.getNombreCompleto(), jugador.getSaldo(), mesa.getId(), mesa.getPozo(), mesa.getManos().size(), mesa.getManoActual().getEstadoMano());
    }

    public void iniciarMesa(){
        vistaPoker.mostrarCartas(jugador, mesa);
        vistaPoker.mostrarFigurasDefinidas(Fachada.getInstancia().getFiguras());
        determinarFiguraMasAlta();
        actualizarDatosPantalla();
    }

    public void determinarFiguraMasAlta(){
        Figura figura = jugador.figuraMasAlta();
        vistaPoker.mostrarFiguraMasAlta(figura);
        System.out.println("Figura: " + figura.getNombre());
    }

    public void apostar(int monto){
        //TODO: METODO APARTE PARA APUESTA INICIAL.
        boolean apuestaRealizada = mano.apostar(monto, jugador);
        if (apuestaRealizada) {
            // Actualizar la vista con el valor de la apuesta y el estado de la mano
            vistaPoker.mostrarApuestaRealizada(jugador.getNombreCompleto(), monto);
            vistaPoker.mostrarEstadoMano(mano.getEstadoMano());
            this.actualizarDatosPantalla();
        } else {
            // Muestra un mensaje de error en la vista si la apuesta no es válida
            vistaPoker.mostrarError("La apuesta no se pudo realizar. Verifica el monto y el saldo disponible.");
        }
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        //CASO ENTRÓ LA GENTE NECESARIA PARA INICIAR LA MESA
        if(evento.equals(Mesa.eventos.cambioIniciada)){
            System.out.println("La mesa se ha iniciado");
            this.iniciarMesa();
        }
        else if(evento.equals(Mesa.eventos.cambioCerrada)){
            //TODO: Mostrar interfaz de mesa cerrada
        }
    }


}
