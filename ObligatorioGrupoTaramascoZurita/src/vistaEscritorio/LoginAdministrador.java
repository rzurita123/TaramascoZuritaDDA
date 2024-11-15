/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLoginAbstracto;
import controlador.ControladorLoginAdministrador;
import java.awt.Frame;

/**
 *
 * @author PC
 */
public class LoginAdministrador extends LoginAbstracto{

    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal, "Login ADMINISTRADOR");    
    }


    @Override
    public ControladorLoginAbstracto crearControlador() {
        return new ControladorLoginAdministrador(this);
    }

    @Override
    public void proximoCasoUso(Object retorno) {
          //new Menu(null, false, (Administrador)u.setVisible(true));
    }

    
}
