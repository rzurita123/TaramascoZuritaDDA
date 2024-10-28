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
        for (int c : conteo) {
            if (c == 3) {
                return true;  // Hay una escalera
            }
        }
        return false;
    }
}