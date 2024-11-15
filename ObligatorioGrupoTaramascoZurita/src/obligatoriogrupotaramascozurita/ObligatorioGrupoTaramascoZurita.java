/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obligatoriogrupotaramascozurita;

import inicio.DatosPrueba;
import vistaEscritorio.LoginAbstracto;
import vistaEscritorio.LoginJugador;
import iuGrafica.Menu;
import iuGrafica.MenuLogin;

/**
 *
 * @author sabrina
 */
public class ObligatorioGrupoTaramascoZurita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosPrueba.cargar();
        new MenuLogin().setVisible(true);
    }
    
}
