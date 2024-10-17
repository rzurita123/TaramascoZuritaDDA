/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author sabrina
 */
public class Jugador extends Usuario{
    public double saldo;

    public Jugador(String cedula, String contraseña, String nombreCompleto, double saldo) {
        super(cedula, contraseña, nombreCompleto);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }


    
    
}
