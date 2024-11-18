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

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public int recaudacionMesa(){
        int recaudacion = 0;
        for (Mesa mesa : mesas) {
            recaudacion += mesa.getPozo();
        }
        return recaudacion;
    }

    public void agregarFiguras(){
        figuras.add(new SinFigura());
        figuras.add(new Par());
        figuras.add(new Pierna());
        figuras.add(new Escalera());
        figuras.add(new Poker());
    }
    
    public String agregarMesa(int minJugadores, int apuestaBase, int porcentajeComision) {
        try{
            Mesa nuevaMesa = Mesa.crearMesa(minJugadores, apuestaBase, porcentajeComision);
            mesas.add(nuevaMesa);
            Fachada.getInstancia().avisar(Fachada.Eventos.seCreoMesa);
            return null;
        } catch (PokerException e) {
            return e.getMessage();
        }
    }

    public Figura getFiguraMasAlta(ArrayList<Carta> cartas) {
        Figura figuraMasAlta = new SinFigura();
        for (Figura figura : figuras) {
            if (figura.evaluarCartas(cartas)) {
                figuraMasAlta = figura;
            }
        }
        return figuraMasAlta;
    }
}

