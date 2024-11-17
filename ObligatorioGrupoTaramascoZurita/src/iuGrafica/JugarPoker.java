/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iuGrafica;

import java.util.ArrayList;

import logica.Apuesta;
import logica.Carta;
import logica.Figura;
import logica.Jugador;
import logica.Mano;
import logica.Mano.EstadoMano;
import logica.Mesa;
import controlador.ControladorPoker;
import controlador.VistaPoker;
import javax.swing.JFrame;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

/**
 *
 * @author Carry
 */
public class JugarPoker extends javax.swing.JFrame implements VistaPoker {
    private ControladorPoker controladorPoker;
    private JFrame ventanaPadre;
    
    public JugarPoker(Jugador j, JFrame ventanaMenu) throws PanelCartasPokerException {
        initComponents();
        ventanaPadre = ventanaMenu;
        this.setLocationRelativeTo(ventanaPadre);
        panelCartas.setVisible(false);
        lblEstadoMano.setVisible(false);
        lblCartasPedidas.setVisible(false);
        lblGanador.setVisible(false);
        lblGanaste.setVisible(false);
        lblPagar.setText("Ningún jugador ha realizado una apuesta.");
        controladorPoker = new ControladorPoker(this, j);
    }

    @Override
    public void mostrarMensajeInicial(int jugadoresActuales, int minJugadores) {
        tpFiguras.setText("Esperando inicio del juego, hay " + jugadoresActuales + " jugadores de " + minJugadores + " en la mesa.");
    }

    @Override
    public void mostrarFigurasDefinidas(ArrayList<Figura> figuras) {
        String texto = "";
        for(Figura f : figuras){
            texto = texto + f.toString() + "\n";
        }   
        tpFiguras.setText(texto);
    }

    @Override
    public void mostrarCartas(Jugador jugador, Mesa mesa) {
        try {
            ArrayList<CartaPoker> cartasPoker = new ArrayList<CartaPoker>();
            // Castear cada Carta a CartaPoker
            for (Carta carta : jugador.getCartas()) {
                cartasPoker.add(carta);
            }
            // Cargar las cartas en el panel
            panelCartas.cargarCartas(cartasPoker);
        } catch (PanelCartasPokerException e) {
            System.err.println("Error al cargar las cartas: " + e.getMessage());
        }
        panelCartas.setVisible(true);
        lblEstadoMano.setVisible(true);
        tpJugadores.setText(mesa.listadoJugadores());
    }

    @Override
    public void mostrarFiguraMasAlta(Figura figura) {
        lblFiguraActual.setText("Figura más alta: " + figura.getNombre());
    }
    
    @Override
    public void actualizarDatosPantalla(String nombreJugador, int saldoJugador, int idMesa, int pozoMesa, int manosMesa, Mano.EstadoMano estadoMano){
        lblJugador.setText("Jugador: " + nombreJugador);
        lblSaldo.setText("Saldo: $" + saldoJugador);
        lblMesa.setText("Mesa: " + idMesa);
        lblPozo.setText("Pozo: $" + pozoMesa);
        lblMano.setText("Mano: " + manosMesa);
        lblEstadoMano.setText("Estado mano: " + estadoMano);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        tfMontoApuesta = new javax.swing.JTextField();
        btnNoApostar = new javax.swing.JButton();
        lblFiguraActual = new javax.swing.JLabel();
        lblMontoApostado = new javax.swing.JLabel();
        lblMontoApuesta = new javax.swing.JLabel();
        lblPagar = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
        btnNoPagar = new javax.swing.JButton();
        btnPedirCartas = new javax.swing.JButton();
        lblCartasPedidas = new javax.swing.JLabel();
        btnVolverAJugar = new javax.swing.JButton();
        lblGanador = new javax.swing.JLabel();
        lblGanaste = new javax.swing.JLabel();

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

        tfMontoApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMontoApuestaActionPerformed(evt);
            }
        });

        btnNoApostar.setText("No Apostar");
        btnNoApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoApostarActionPerformed(evt);
            }
        });

        lblFiguraActual.setText("Tu figura actual: ");

        lblMontoApostado.setText("Monto apostado: ");

        lblMontoApuesta.setText("Monto apuesta");

        lblPagar.setText("El jugador ___ ha apostado $___. ¿Pagas la apuesta?");

        btnPagar.setText("SI");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnNoPagar.setText("NO");
        btnNoPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoPagarActionPerformed(evt);
            }
        });

        btnPedirCartas.setText("Pedir Cartas");
        btnPedirCartas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirCartasActionPerformed(evt);
            }
        });

        lblCartasPedidas.setText("Pediste __ cartas nuevas.");

        btnVolverAJugar.setText("Volver a jugar");
        btnVolverAJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAJugarActionPerformed(evt);
            }
        });

        lblGanador.setText("Ganador: ");

        lblGanaste.setText("Ganaste $ ___ !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(panelCartas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblPagar)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(lblFiguraActual))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnSalir)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnNoApostar)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPagar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnNoPagar)
                                    .addGap(74, 74, 74)
                                    .addComponent(btnPedirCartas)
                                    .addGap(67, 67, 67)
                                    .addComponent(lblMontoApuesta)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMontoApostado)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tfMontoApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnApostar))))
                                .addComponent(btnVolverAJugar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCartasPedidas)
                                .addGap(366, 366, 366)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGanador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblGanaste))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPozo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 697, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstadoMano)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMesa, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblMano, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addGap(253, 253, 253))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGanador)
                    .addComponent(lblGanaste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(panelCartas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnApostar)
                                .addComponent(tfMontoApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMontoApuesta))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFiguraActual)
                                    .addComponent(lblPagar))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSalir)
                                    .addComponent(btnNoApostar)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPagar)
                                .addComponent(btnPedirCartas)
                                .addComponent(btnNoPagar))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMontoApostado)))
                .addGap(18, 18, 18)
                .addComponent(lblCartasPedidas)
                .addGap(31, 31, 31)
                .addComponent(btnVolverAJugar)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //#endregion
    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        controladorPoker.apostar(Integer.parseInt(tfMontoApuesta.getText()));
    }//GEN-LAST:event_btnApostarActionPerformed

    private void cerrarYMostrarMenu(){
        ventanaPadre.setVisible(true);
        this.dispose();
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        cerrarYMostrarMenu();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tfMontoApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMontoApuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMontoApuestaActionPerformed

    private void btnNoPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoPagarActionPerformed
        controladorPoker.noPagar();
    }//GEN-LAST:event_btnNoPagarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        controladorPoker.pagar();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnPedirCartasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirCartasActionPerformed
        int cartasPedidas = controladorPoker.pedirCartas();
        lblCartasPedidas.setVisible(true);
        lblCartasPedidas.setText("Pediste " + cartasPedidas + " cartas nuevas.");
    }//GEN-LAST:event_btnPedirCartasActionPerformed

    private void btnVolverAJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAJugarActionPerformed
        controladorPoker.comenzarMano();
    }//GEN-LAST:event_btnVolverAJugarActionPerformed

    private void btnNoApostarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        controladorPoker.noApostar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnNoApostar;
    private javax.swing.JButton btnNoPagar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPedirCartas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVolverAJugar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCartasPedidas;
    private javax.swing.JLabel lblEstadoMano;
    private javax.swing.JLabel lblFiguraActual;
    private javax.swing.JLabel lblGanador;
    private javax.swing.JLabel lblGanaste;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblMano;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblMontoApostado;
    private javax.swing.JLabel lblMontoApuesta;
    private javax.swing.JLabel lblPagar;
    private javax.swing.JLabel lblPozo;
    private javax.swing.JLabel lblSaldo;
    private panelCartasPoker.PanelCartasPoker panelCartas;
    private javax.swing.JTextField tfMontoApuesta;
    private javax.swing.JTextPane tpFiguras;
    private javax.swing.JTextPane tpJugadores;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarApuestaRealizada(String nombre, int monto) {
        lblMontoApostado.setText("Monto apostado: " + monto);
        //TODO: Actualizar en la vista de todos los jugadores la ultima apuesta.
    }

    @Override
    public void mostrarEstadoMano(EstadoMano estadoMano) {
        lblEstadoMano.setText("Estado mano: " + estadoMano);
    }

    @Override
    public void mostrarError(String mensaje) {
        System.out.println(mensaje);
        //TODO: Mostrar error como ventana en vez de sout.
    }

    @Override
    public void mostrarMensajeApuesta(Apuesta apuesta) {
        lblPagar.setText("El jugador " + apuesta.getJugador().getNombreCompleto() + " ha apostado $" + apuesta.getMonto() + ". ¿Pagas la apuesta?");
    }

    @Override
    public void mostrarGanador(Jugador jugador, Figura figura) {
        
        lblGanador.setText("Ganador: " + jugador.getNombreCompleto() + " con " + figura.getNombre());
        lblGanador.setVisible(true);
    }

    @Override
    public void mostrarGanaste(int montoGanado) {
        lblGanaste.setText("Ganaste $" + montoGanado + " !");
        lblGanaste.setVisible(true);
    }

    
}
