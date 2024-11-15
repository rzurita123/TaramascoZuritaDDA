/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import logica.Fachada;
/**
 *
 * @author sabrina
 */
public class DatosPrueba {
    public static void cargar(){
        
    Fachada fachada = Fachada.getInstancia();
    
    fachada.agregarJugador("0", "0", "J0", 0);
    fachada.agregarJugador("1", "1", "J1", 1000);
    fachada.agregarJugador("2", "2", "J2", 2000);
    fachada.agregarJugador("3", "3", "J3", 3000);
    fachada.agregarJugador("4", "4", "J4", 4000);
    fachada.agregarJugador("5", "5", "J5", 5000);
    fachada.agregarJugador("6", "6", "J6", 6000);
    fachada.agregarJugador("7", "7", "J7", 7000);
    fachada.agregarJugador("8", "8", "J8", 8000);
    fachada.agregarJugador("9", "9", "J9", 9000);

    fachada.agregarAdministrador("100", "100", "A 100");
    fachada.agregarAdministrador("200", "101", "A 200");
    
    fachada.agregarMesa(5, 500, 3);
    fachada.agregarMesa(4, 50, 4);
    fachada.agregarMesa(2, 100, 5);
    
    fachada.agregarFiguras();

    }
}
