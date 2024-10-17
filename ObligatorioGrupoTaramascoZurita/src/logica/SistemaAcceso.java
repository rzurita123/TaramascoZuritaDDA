/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author sabrina
 */
public class SistemaAcceso {
        private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Administrador> administradores = new ArrayList();
    
    public void agregarJugador(String cedula,String password, String nombreCompleto, double saldo){
        jugadores.add(new Jugador(cedula, password, nombreCompleto, saldo));
    }
     public void agregarAdministrador(String cedula, String password,String nombreCompleto){
        administradores.add(new Administrador(cedula, password, nombreCompleto));
    }
    
    public Jugador loginAgenda(String cedula,String password){
       return (Jugador) login(cedula, password, jugadores);
       
    }
     public Administrador loginAdministrador(String cedula,String password){
       return (Administrador) login(cedula, password, administradores);
    }
     
     
    private Usuario login(String cedula, String password, ArrayList lista){
        Usuario usuario;
        for(Object o:lista){
            usuario = (Usuario)o;
            if(usuario.getCedula().equals(cedula) && usuario.getContraseña().equals(password)){
                return usuario;
            }
        }
        return null;
    }
}
