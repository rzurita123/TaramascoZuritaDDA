/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package iuGrafica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import logica.Fachada;
import logica.Jugador;
import logica.Mesa;
import panelCartasPoker.PanelCartasPokerException;

/**
 *
 * @author PC
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private Jugador jugador;
    private Mesa mesaSeleccionada;
    private ArrayList<Mesa> mesasAbiertas = new ArrayList();
    public Menu(Jugador jugador) {
        initComponents();
        setLocationRelativeTo(null);
        this.jugador = jugador;
        setTitle("MENU  - " + jugador.getNombreCompleto());
        cargarUsuario();
        cargarMesasAbiertas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombre = new javax.swing.JLabel();
        lbSaldo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbDetalleMesa = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        lbMinJugadores = new javax.swing.JLabel();
        lbApuestaBase = new javax.swing.JLabel();
        lbJugadoresActuales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMesaAbierta = new javax.swing.JList();
        lbPorcentajeComision = new javax.swing.JLabel();
        btnIngresarMesa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbNombre.setText("Nombre:");

        lbSaldo.setText("Saldo:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Mesas abiertas");

        lbDetalleMesa.setText("Detalles de la mesa");

        lbId.setText("ID:");

        lbMinJugadores.setText("Min. jugadores:");

        lbApuestaBase.setText("Valor apuesta base:");

        lbJugadoresActuales.setText("Jugadores actuales:");

        listaMesaAbierta.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaMesaAbiertaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaMesaAbierta);

        lbPorcentajeComision.setText("Porcentaje comisión:");

        btnIngresarMesa.setText("Ingresar a la mesa");
        btnIngresarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbNombre)
                .addGap(411, 411, 411)
                .addComponent(lbSaldo)
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(lbPorcentajeComision, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbDetalleMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIngresarMesa)
                        .addGap(39, 39, 39))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbMinJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbApuestaBase, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbJugadoresActuales, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(223, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombre)
                    .addComponent(lbSaldo))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbDetalleMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(lbPorcentajeComision)
                .addGap(9, 9, 9)
                .addComponent(btnIngresarMesa)
                .addGap(30, 30, 30))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(376, 376, 376)
                    .addComponent(lbId)
                    .addGap(12, 12, 12)
                    .addComponent(lbMinJugadores)
                    .addGap(12, 12, 12)
                    .addComponent(lbApuestaBase)
                    .addGap(12, 12, 12)
                    .addComponent(lbJugadoresActuales)
                    .addContainerGap(96, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaMesaAbiertaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaMesaAbiertaValueChanged
        detalles();
    }//GEN-LAST:event_listaMesaAbiertaValueChanged

    private void btnIngresarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarMesaActionPerformed
        if (!jugador.validarSaldo(this.mesaSeleccionada.getApuestaBase())) {
            //TODO: No usar optionPane
            JOptionPane.showMessageDialog(this, "Saldo insuficiente.", getTitle(), JOptionPane.ERROR_MESSAGE);
        } else if (!mesaSeleccionada.agregarJugador(jugador)) {
            JOptionPane.showMessageDialog(this, "La mesa está llena.", getTitle(), JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                ;
                new JugarPoker(mesaSeleccionada, jugador).setVisible(true);
            } catch (PanelCartasPokerException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }//GEN-LAST:event_btnIngresarMesaActionPerformed

    private void cargarMesasAbiertas() {
    DefaultListModel<Mesa> model = new DefaultListModel<>();
    ArrayList<Mesa> lista = Fachada.getInstancia().getMesasAbiertas();
    for (Mesa mesa : lista) {
        model.addElement(mesa);
    }
    this.mesasAbiertas = lista;
    listaMesaAbierta.setModel(model);
}
    
    private void detalles() {
        int pos = listaMesaAbierta.getSelectedIndex();
        if(pos!=-1){ //hay seleccion
            this.mesaSeleccionada = mesasAbiertas.get(pos);
            mostrarDetalles();
        }else {//se borro lo seleccionado
            mostrarDetalles();
        }
    }

    private void mostrarDetalles() {
       if(this.mesaSeleccionada!=null){
            lbId.setText("Id: " + this.mesaSeleccionada.getId());
            lbMinJugadores.setText("Min. jugadores: " + this.mesaSeleccionada.getMinJugadores());
            lbApuestaBase.setText("Valor apuesta base: " + this.mesaSeleccionada.getApuestaBase());
            lbJugadoresActuales.setText("Jugadores actuales: " + this.mesaSeleccionada.getJugadoresActuales());
            lbPorcentajeComision.setText("Porcentaje comisión: " + this.mesaSeleccionada.getPorcentajeComision() + '%');
    
       }else{
            lbId.setText("Id: ");
            lbMinJugadores.setText("Min. jugadores: ");
            lbApuestaBase.setText("Valor apuesta base: ");
            lbJugadoresActuales.setText("Jugadores actuales: ");
            lbPorcentajeComision.setText("Porcentaje comisión: ");
       }
    }
    
    private void cargarUsuario(){
        lbNombre.setText("Nombre: " + jugador.getNombreCompleto());
        lbSaldo.setText("Saldo: $" + jugador.getSaldo());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarMesa;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApuestaBase;
    private javax.swing.JLabel lbDetalleMesa;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbJugadoresActuales;
    private javax.swing.JLabel lbMinJugadores;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPorcentajeComision;
    private javax.swing.JLabel lbSaldo;
    private javax.swing.JList listaMesaAbierta;
    // End of variables declaration//GEN-END:variables
}
