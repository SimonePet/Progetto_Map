/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;
import multimediali.Immagini;

import java.awt.Font;


/**
 * @author Giannantonio
 */
public class JDialogPunteggio extends javax.swing.JDialog {


    public JDialogPunteggio(final java.awt.Frame parent, final boolean modal, final GiocoNaufragioIsola gniCorr) {
        super(parent, modal);
        this.gni = gniCorr;
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPunteggio = new javax.swing.JTextField();
        lblCongratulazioni = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(final java.awt.event.WindowEvent evt) {
                formWindowOpened();
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jLabel1.setText("Il tuo punteggio è:");
        jLabel1.setToolTipText("");

        lblCongratulazioni.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(114, 114, 114)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(lblCongratulazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCongratulazioni, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    } // </editor-fold>//GEN-END:initComponents


    private void formWindowOpened() {
        lblCongratulazioni.setText("Congratulazioni " + gni.getUsername() + "!\nNON CHIUDERE ATTENDI!");
        txtPunteggio.setText(Integer.toString(gni.getPunteggio()));
        txtPunteggio.setEditable(false);
        Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_MENU, "sfondo frame vittoria", jPanel1);
    }

    public void avvio() {
        java.awt.EventQueue.invokeLater(() -> {
            JDialogPunteggio dialog = new JDialogPunteggio(new javax.swing.JFrame(), true, gni);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(final java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCongratulazioni;
    private javax.swing.JTextField txtPunteggio;
    // End of variables declaration//GEN-END:variables
    private GiocoNaufragioIsola gni;

}

