/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.lang.reflect.Array;
import java.util.ArrayList;

import logica.Mano;
import logica.Mesa;

/**
 *
 * @author Carry
 */
public interface VistaAdministrarMesas {
    public void mostrarMontoRecaudado(int recaudacion);
    public void cargarMesas(ArrayList<Mesa> listaMesas);
    public void mostrarError(String mensaje);
    public void mostrarManos(ArrayList<Mano> manos);
    public void borrarManos();
}
