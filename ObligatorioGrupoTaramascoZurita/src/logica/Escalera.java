/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author sabrina
 */
public class Escalera extends Figura {
    public Escalera() {
        super("Escalera", PrioridadFigura.ESCALERA);
    }

    @Override
    protected boolean cumpleCondicion(int[] conteo) {
        //Si hay 5 cartas consecutivas, entonces hay escalera.
        for (int i = 0; i < conteo.length - 4; i++) {
            if (conteo[i] == 1 && conteo[i + 1] == 1 && conteo[i + 2] == 1 && conteo[i + 3] == 1 && conteo[i + 4] == 1) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int obtenerConteoEsperado() {
        return 5;
    }
}