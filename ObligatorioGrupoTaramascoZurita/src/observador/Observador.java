/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observador;

import panelCartasPoker.PanelCartasPokerException;

/**
 *
 * @author Dario
 */
public interface Observador {
 
    public void actualizar(Object evento,Observable origen);
}
