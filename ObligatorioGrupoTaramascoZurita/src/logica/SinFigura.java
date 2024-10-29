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
public class SinFigura extends Figura {

    public SinFigura() {
        super("Sin figura", PrioridadFigura.SIN_FIGURA);
    }

    @Override
    public boolean cumpleCondicion(int[] conteo) {
        return true; //Siempre tengo 'sin figura'
    }

    //TODO: Cambiar esto
    @Override
    public int obtenerValorClave(ArrayList<Carta> mano) {
        return 0;
    }
    
    @Override
    public int obtenerConteoEsperado() {
        return 0;
    }

}
