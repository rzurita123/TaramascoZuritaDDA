/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
/**
 *
 * @author sabrina
 */
public abstract class ControladorLoginAbstracto {
    private VistaLogin vista;

    public ControladorLoginAbstracto(VistaLogin vista) {
        this.vista = vista;
    }

    //Evento del usuario
    public void login(String usuario, String password){
        Object retorno = llamarLogin(usuario, password);
         if(retorno==null){
             vista.mostrarError("Acceso denegado");
        }else{
            vista.cerrar();
            vista.proximoCasoUso(retorno);
        }
    }

    public abstract Object llamarLogin(String usuario, String password);
}