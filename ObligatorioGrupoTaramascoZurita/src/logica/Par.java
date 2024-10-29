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
public class Par extends Figura {
    public Par() {
        super("Par", PrioridadFigura.PAR);
    }

    @Override
    public boolean cumpleCondicion(int[] conteo) {
        for (int c : conteo) {
            if (c == 2) {
                return true;  // Hay un par
            }
        }
        return false;
    }
    
    @Override
    public int obtenerConteoEsperado() {
        return 2;
    }
   
}
