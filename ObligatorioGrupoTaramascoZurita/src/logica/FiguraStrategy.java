/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Carry
 */
public interface FiguraStrategy {
    boolean esFigura(ArrayList<Carta> mano);
    Figura getFigura();
}
