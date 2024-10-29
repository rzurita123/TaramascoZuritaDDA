/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

public class Poker extends Figura {
    public Poker() {
        super("Poker", PrioridadFigura.POKER);
    }

    @Override
    protected boolean cumpleCondicion(int[] conteo) {
        for (int c : conteo) {
            if (c == 4) {
                return true;  // Hay un poker
            }
        }
        return false;
    }

    @Override
    public int obtenerConteoEsperado() {
        return 4;
    }
}
