/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iuGrafica;

import java.awt.Frame;
import logica.Fachada;
import logica.Usuario;

/**
 *
 * @author PC
 */
public class LoginAdministrador extends LoginAbstracto{

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal, "Login ADMINISTRADOR");
    }

    @Override
    public Usuario llamarLogin(String nombre, String password) {
        return Fachada.getInstancia().loginAdministrador(nombre, password);
    }

    @Override
    public void proximoCasoUso(Usuario usuario) {
        
    }

    
}
