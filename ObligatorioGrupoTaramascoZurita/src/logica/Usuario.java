/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import observador.Observable;

/**
 *
 * @author sabrina
 */
public abstract class Usuario extends Observable {
    public String cedula;
    public String contraseña;
    public String nombreCompleto;

    public Usuario(String cedula, String contraseña, String nombreCompleto) {
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    @Override
    public String toString() {
        return nombreCompleto;
    }

    //para que funcione equals
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Usuario){
            Usuario u = (Usuario)obj;
            return u.getCedula().equals(cedula);
        }
        return false;
    }
}
