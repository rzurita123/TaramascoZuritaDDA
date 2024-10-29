/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author sabrina
 */
public class Pierna extends Figura {
    public Pierna() {
        super("Pierna", PrioridadFigura.PIERNA);
    }

    @Override
    protected boolean cumpleCondicion(int[] conteo) {
        for (int c : conteo) {
            if (c == 3) {
                return true;  // Hay una pierna
            }
        }
        return false;
    }
    
    @Override
    public int obtenerConteoEsperado() {
        return 3;
    }
}
