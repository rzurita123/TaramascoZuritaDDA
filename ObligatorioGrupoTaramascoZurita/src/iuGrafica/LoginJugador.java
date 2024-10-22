/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;

import java.awt.Frame;
import logica.Fachada;
import logica.Usuario;
import logica.Jugador;

/**
 *
 * @author PC
 */
public class LoginJugador extends LoginAbstracto{

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal, "Login jugadores");
    }

    @Override
    public Usuario llamarLogin(String cedula, String password) {
        return Fachada.getInstancia().loginJugador(cedula, password);
    }

    @Override
    public void proximoCasoUso(Usuario usuario) {
        new Menu((Jugador)usuario).setVisible(true);
    }
}
