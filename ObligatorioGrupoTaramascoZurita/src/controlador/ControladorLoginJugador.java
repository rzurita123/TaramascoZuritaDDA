/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import logica.Fachada;

/**
 *
 * @author sabrina
 */
public class ControladorLoginJugador extends ControladorLoginAbstracto{

    public ControladorLoginJugador(VistaLogin vista){
        super(vista);
    }
    
    @Override
    public Object llamarLogin(String usuario, String password) {
        return Fachada.getInstancia().loginJugador(usuario, password);
    }
    


}

