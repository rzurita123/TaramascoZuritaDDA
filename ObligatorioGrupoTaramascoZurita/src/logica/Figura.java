/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.ArrayList;

/**
 *
 * @author Carry
 */
public class Figura {
    private String nombre;
    private int valor;
    private FiguraStrategy estrategia;

    // Constructor
    public Figura(String nombre, int valor, FiguraStrategy estrategia) {
        this.nombre = nombre;
        this.valor = valor;
        this.estrategia = estrategia;
    }

    // Método para evaluar una mano de cartas según la estrategia asignada
    public boolean evaluarMano(ArrayList<Carta> mano) {
        return estrategia.esFigura(mano);
    }

    public int getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    // Método estático que devuelve la figura que corresponde a la mano
    public static Figura obtenerFigura(ArrayList<Carta> mano, ArrayList<Figura> figurasDisponibles) {
        for (Figura figura : figurasDisponibles) {
            if (figura.evaluarMano(mano)) {
                return figura;
            }
        }
        return new Figura("Sin Figura", 0, new SinFigura());
    }
}