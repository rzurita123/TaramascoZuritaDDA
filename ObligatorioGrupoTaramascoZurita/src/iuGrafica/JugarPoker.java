/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iuGrafica;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Carta;
import logica.Jugador;
import logica.Mesa;
import observador.Observable;
import observador.Observador;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

/**
 *
 * @author Carry
 */
public class JugarPoker extends javax.swing.JFrame implements Observador {

    public ArrayList<CartaPoker> cartas = new ArrayList();
    private Mesa mesa;
    private Jugador jugador;
    /**
     * Creates new form JugarPoker
     */
    public JugarPoker(Mesa m, Jugador j) throws PanelCartasPokerException {
        initComponents();        
        //Entré a la partida, el estado de la mesa es ABIERTA.
        mesa = m;
        jugador = j;
        mesa.agregarObservador(this);
        panelCartas.setVisible(false);
        lblEstadoMano.setVisible(false);
        this.actualizarDatosPantalla();
        tpJugadores.setText("Esperando inicio del juego, hay " + mesa.getJugadoresActuales() + " jugadores de " + mesa.getMinJugadores() + " en la mesa.");
        //TODO: QUE LAS CARTAS SEAN RANDOM.
        //Validar que la mesa esté llena
        //Si lo esta, barajar el mazo y repartir 5 cartas a cada jugador.
        cartas.add(new Carta(CartaPoker.AS, CartaPoker.CORAZON));
        cartas.add(new Carta(CartaPoker.DIEZ, CartaPoker.PIQUE));
        cartas.add(new Carta(CartaPoker.K, CartaPoker.TREBOL));
        cartas.add(new Carta(CartaPoker.Q, CartaPoker.DIAMANTE));
        cartas.add(new Carta(CartaPoker.SIETE, CartaPoker.TREBOL));
        panelCartas.cargarCartas(cartas);
    }
    
    public void actualizarDatosPantalla(){
        lblJugador.setText("Jugador: " + jugador.getNombreCompleto());
        lblSaldo.setText("Saldo: $" + jugador.getSaldo());
        lblMesa.setText("Mesa: " + mesa.getId());
        lblPozo.setText("Pozo: $" + mesa.getPozo());
        lblMano.setText("Mano: " + mesa.getManos().size());
        lblEstadoMano.setText("Estado mano: " + mesa.getManoActual().getEstadoMano());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartas = new panelCartasPoker.PanelCartasPoker();
        lblMesa = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        btnApostar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpJugadores = new javax.swing.JTextPane();
        btnSalir = new javax.swing.JButton();
        lblSaldo = new javax.swing.JLabel();
        lblMano = new javax.swing.JLabel();
        lblPozo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpFiguras = new javax.swing.JTextPane();
        lblEstadoMano = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMesa.setText("Mesa:");

        lblJugador.setText("Jugador:");

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tpJugadores);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblSaldo.setText("Saldo: ");

        lblMano.setText("Mano actual:");

        lblPozo.setText("Pozo:");

        tpFiguras.setText("Esperando jugadores...");
        tpFiguras.setPreferredSize(new java.awt.Dimension(500, 20));
        jScrollPane2.setViewportView(tpFiguras);

        lblEstadoMano.setText("Estado mano:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPozo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstadoMano)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMesa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMano, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(253, 253, 253))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnApostar))
                    .addComponent(panelCartas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMesa)
                    .addComponent(lblJugador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(lblMano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPozo)
                    .addComponent(lblEstadoMano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(panelCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalir)
                            .addComponent(btnApostar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnApostarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        mesa.quitarObservador(this);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEstadoMano;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblMano;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblPozo;
    private javax.swing.JLabel lblSaldo;
    private panelCartasPoker.PanelCartasPoker panelCartas;
    private javax.swing.JTextPane tpFiguras;
    private javax.swing.JTextPane tpJugadores;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Mesa.eventos.cambioIniciada)){
            panelCartas.setVisible(true);
            lblEstadoMano.setVisible(true);
            tpJugadores.setText(mesa.listadoJugadores());
        }
        else if(evento.equals(Mesa.eventos.cambioCerrada)){
            //TODO: Mostrar interfaz de mesa cerrada
        }
    }
}
