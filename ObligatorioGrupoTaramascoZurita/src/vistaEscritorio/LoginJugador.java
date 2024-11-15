/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLoginAbstracto;
import controlador.ControladorLoginJugador;
import java.awt.Frame;
import logica.Jugador;
import iuGrafica.Menu;

/**
 *
 * @author PC
 */
public class LoginJugador extends LoginAbstracto{

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal, "Login JUGADORES");
    }

    @Override
    public ControladorLoginAbstracto crearControlador() {
        return new ControladorLoginJugador(this);
    }

    @Override
    public void proximoCasoUso(Object retorno) {
        new Menu((Jugador)retorno).setVisible(true);
    }

}
