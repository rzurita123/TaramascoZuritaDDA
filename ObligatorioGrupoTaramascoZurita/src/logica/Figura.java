/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Collections;
import java.util.ArrayList;

public abstract class Figura {
    private String nombre;
    private PrioridadFigura prioridad;

    public enum PrioridadFigura {
        SIN_FIGURA, PAR, PIERNA, ESCALERA, POKER;

        public boolean esMayorQue(PrioridadFigura otra) {
            return this.ordinal() > otra.ordinal();
        }
    }

    public Figura(String nombre, PrioridadFigura prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    
    //COMPARO FIGURAS. SI SON IGUALES, COMPARO CARTA ALTA DE LA FIGURA, SI SON IGUALES, COMPARO CARTA ALTA EN GENERAL.
    public int compararFigura(Figura otra, ArrayList<Carta> mano1, ArrayList<Carta> mano2) {
        if (this.prioridad.esMayorQue(otra.prioridad)) {
            return 1;  // Esta figura es mayor
        } else if (otra.prioridad.esMayorQue(this.prioridad)) {
            return -1; // La otra figura es mayor
        } else {
            //ACÁ COMPARO VALORES CLAVE DENTRO DE LA FIGURA
            int valorClave1 = this.obtenerValorClave(mano1);
            int valorClave2 = otra.obtenerValorClave(mano2);

            if (valorClave1 > valorClave2) return 1;
            if (valorClave1 < valorClave2) return -1;

            // SI EL VALOR CLAVE ES IGUAL, DESEMPATO CON LA CARTA MAS ALTA DE TODAS.
            return compararCartaAlta(mano1, mano2);
        }
    }
    
    private int compararCartaAlta(ArrayList<Carta> cartas1, ArrayList<Carta> cartas2) {
        int maximo1 = 0;
        int maximo2 = 0;
        // Comparar las cartas desde la más alta
        for (int i = cartas1.size() - 1; i >= 0; i--) {
            int valor1 = cartas1.get(i).getValorCarta();
            int valor2 = cartas2.get(i).getValorCarta();
            if (valor1 > maximo1) {
                maximo1 = valor1;
            }
            if (valor2 > maximo2) {
                maximo2 = valor2;
            }
        }
        if (maximo1 > maximo2) return 1;
        if (maximo1 < maximo2) return -1;
        return 0;  // Las manos son iguales
    }

    //
    public int obtenerValorClave(ArrayList<Carta> cartas) {
    int[] conteo = new int[13];  // Índices 0 a 12 para cartas de valor 1 (As) a 13 (K)

    // Contar las ocurrencias de cada valor en la mano
    for (Carta carta : cartas) {
        conteo[carta.getValorCarta() - 1]++;
    }

    // Primero buscar de la K (índice 12) a 2 (índice 1)
    for (int i = 12; i >= 1; i--) {  
        if (conteo[i] == obtenerConteoEsperado()) {
            return i + 1;  // Devolver el valor de la carta relevante
        }
    }
    // Finalmente, verificar si el As (índice 0) cumple la condición
    if (conteo[0] == obtenerConteoEsperado()) {
        return 1;  // El As tiene valor 1, pero es la carta más alta
    }

    return 0;  // Si no se encontró ninguna coincidencia relevante
}
    
    public abstract int obtenerConteoEsperado();

    public boolean evaluarCartas(ArrayList<Carta> cartas) {
        int[] conteo = new int[13];

        for (Carta carta : cartas) {
            conteo[carta.getValorCarta() - 1]++;
        }
        return cumpleCondicion(conteo);
    }

    // Método abstracto para verificar si una figura específica se cumple
    protected abstract boolean cumpleCondicion(int[] conteo);

    public String getNombre() {
        return nombre;
    }

    public PrioridadFigura getPrioridad() {
        return prioridad;
    }

    //tostring de figura
    @Override
    public String toString() {
        return nombre;
    }
}
