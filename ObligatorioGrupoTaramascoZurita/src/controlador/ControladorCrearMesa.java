package controlador;

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
public class ControladorCrearMesa implements Observador{
    private VistaCrearMesa vistaCrearMesa;
    public ControladorCrearMesa(VistaCrearMesa vista) {
        vistaCrearMesa = vista;
    }

    public void crearMesa(String mJugadores, String aBase, String pComision) {
            //Valido que los string no sean vacios y parseables a int
            if(mJugadores.isEmpty() || aBase.isEmpty() || pComision.isEmpty()){
                vistaCrearMesa.mostrarMensajeError("Debe completar todos los campos");
                return;
            }
            //valido que solo contenga numeros
            if(!mJugadores.matches("[0-9]+") || !aBase.matches("[0-9]+") || !pComision.matches("[0-9]+")){
                vistaCrearMesa.mostrarMensajeError("Los campos deben contener solo números");
                return;
            }
            //parseo a int
            int minJugadores = Integer.parseInt(mJugadores);
            int apuestaBase = Integer.parseInt(aBase);
            int porcentajeComision = Integer.parseInt(pComision);
            String ret = Fachada.getInstancia().agregarMesa(minJugadores, apuestaBase, porcentajeComision);
            if(ret == null){
                vistaCrearMesa.mostrarMensajeExito();
            } else{
                vistaCrearMesa.mostrarMensajeError(ret);
            }
            //cargarMesas();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        /* if(evento.equals(Fachada.Eventos.seCreoMesa)){
            this.iniciarMesa();
        }  */
    }


}
