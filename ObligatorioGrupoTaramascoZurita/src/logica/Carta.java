/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import panelCartasPoker.CartaPoker;

/**
 *
 * @author sabrina
 */
public class Carta implements CartaPoker {
    public int valor;
    public String palo;
    public boolean visible;
    
    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public void cambiarSiEstaDadaVuelta(){
        this.visible = !this.visible;
    }

    @Override
    public int getValorCarta() {
        return this.valor;
    }

    @Override
    public String getPaloCarta() {
        return this.palo;
    }

    @Override
    public boolean estaVisible() {
        return this.visible;
    }

    @Override
    public void setVisible(boolean b) {
        this.visible = b;
    }
}
