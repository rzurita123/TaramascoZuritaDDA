/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import panelCartasPoker.CartaPoker;

public class Mazo {
    // ArrayList de 52 cartasMazo
    private ArrayList<Carta> cartasMazo;
    // Constructor
    public Mazo() {
        cartasMazo = new ArrayList<>();
        generarMazo();
    }

    // Método para generar un mazo de cartasMazo
    private void generarMazo() {
        String[] palos = {CartaPoker.CORAZON, CartaPoker.DIAMANTE, CartaPoker.TREBOL, CartaPoker.PIQUE};
        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                cartasMazo.add(new Carta(valor, palo));
            }
        }
        barajar();
    }

    // Método para barajar
    public void barajar() {
        Collections.shuffle(cartasMazo);
    }

    //Reparte 5 cartas al jugador si quedan 5 en el mazo.
    public void repartir(Jugador jugador) {
        if(jugador.getCartas().size() < 5 && cartasMazo.size() > 4){
            for (int i = 0; i < 5; i++) {
                jugador.getCartas().add(cartasMazo.get(0));
                cartasMazo.remove(0);
            }
        }
    }

    public void cambiarCartas(Jugador jugador, ArrayList<Carta> cartasACambiar){
        if (cartasMazo.size() > cartasACambiar.size()){
            for (Carta carta : cartasACambiar) {
                int index = jugador.getCartas().indexOf(carta);
                if (index != -1) {
                    jugador.getCartas().remove(index);
                    jugador.getCartas().add(index, cartasMazo.get(0));
                    cartasMazo.remove(0);
                }
            }
        }
        
    }

    // Método para obtener el mazo de cartasMazo
    public ArrayList<Carta> getcartasMazo() {
        return cartasMazo;
    }
}