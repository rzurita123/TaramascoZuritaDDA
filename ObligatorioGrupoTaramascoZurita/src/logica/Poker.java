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
public class Poker implements FiguraStrategy {
    @Override
    public boolean esFigura(ArrayList<Carta> mano) {
        //TODO: Lógica que determina si una mano es poker
        return false;
    }

    @Override
    public Figura getFigura() {
        return null;
        //return new Figura();
        //return Figura.POKER;
        //Todo: devolver la figura poker.
    }
}
