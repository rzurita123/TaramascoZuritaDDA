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
class SistemaJuego {
    private ArrayList<Mesa> mesas = new ArrayList();
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Figura> figuras = new ArrayList();
    
    public ArrayList<Mesa> getMesasAbiertas(){
        ArrayList<Mesa> mesasAbiertas = new ArrayList();
        for (Mesa mesa : mesas) {
            if (mesa.esAbierta()) {
                mesasAbiertas.add(mesa);
            }
        }
        return mesasAbiertas;
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public void agregarFiguras(){
        figuras.add(new Par());
        figuras.add(new Escalera());
        figuras.add(new Poker());
        figuras.add(new Pierna());
        figuras.add(new SinFigura());
    }
    
    public void agregarMesa(int minJugadores, int apuestaBase, int porcentajeComision) {
        Mesa nuevaMesa = new Mesa(minJugadores, apuestaBase, porcentajeComision);
        mesas.add(nuevaMesa);
    }
}
