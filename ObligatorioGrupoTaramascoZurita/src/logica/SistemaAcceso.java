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
        private ArrayList<Sesion> sesiones = new ArrayList();
    
    public void agregarJugador(String cedula,String password, String nombreCompleto, int saldo){
        jugadores.add(new Jugador(cedula, password, nombreCompleto, saldo));
    }
     public void agregarAdministrador(String cedula, String password,String nombreCompleto){
        administradores.add(new Administrador(cedula, password, nombreCompleto));
    }
    
    public Jugador loginJugador(String cedula,String password){
       return (Jugador) login(cedula, password, jugadores);
       
    }
     public Administrador loginAdministrador(String cedula,String password){
       return (Administrador) login(cedula, password, administradores);
    }
    public void logout(Sesion s){
        sesiones.remove(s);
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

    public boolean yaLogueado(Usuario u){
        System.out.println("yaLogueado");
        for(Sesion s:sesiones){
            System.out.println("sesion: "+s.getUsuario().getNombreCompleto());
            if(s.getUsuario().equals(u)){
                System.out.println("retorné true");
                return true;
            }
        }
        sesiones.add(new Sesion(u));
        return false;
    }

    protected Usuario validarLoginJugador(String nom,String pwd){
        return validarLogin(nom, pwd, jugadores);
    }

    //valido para administrador
    protected Administrador validarLoginAdministrador(String nom,String pwd){
        return (Administrador)validarLogin(nom, pwd, administradores);
    }

    private Usuario validarLogin(String nom,String pwd,ArrayList usuarios){
        for(Object o:usuarios){
            Usuario u = (Usuario)o;
            if(u.getNombreCompleto().equals(nom) && u.getContraseña().equals(pwd)){
                return u;
            }
        }
        return null;
    }
}
