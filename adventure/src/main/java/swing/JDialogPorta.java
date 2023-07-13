/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import multimediali.Suono;
import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;
import di.uniba.map.b.adventure.messaggi.MessaggioEdificioFuori;
import di.uniba.map.b.adventure.type.Stanza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;
import multimediali.Immagini;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 */
public class JDialogPorta extends javax.swing.JDialog {
    private final GiocoNaufragioIsola GNI;


    public JDialogPorta(final java.awt.Frame parent, final boolean modal, final GiocoNaufragioIsola gni) {
        super(parent, modal);
        initComponents();
        this.GNI = gni;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        txtCodice = new javax.swing.JTextField();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btnConferma = new javax.swing.JButton();
        btnCancella = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        panelErrore = new javax.swing.JPanel();
        lblErrore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtCodice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodiceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodiceKeyReleased(evt);
            }
        });

        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btnConferma.setBackground(new java.awt.Color(153, 255, 153));
        btnConferma.setText("CONFERMA");
        btnConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfermaActionPerformed(evt);
            }
        });

        btnCancella.setBackground(new java.awt.Color(255, 102, 102));
        btnCancella.setText("CANCELLA");
        btnCancella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancellaActionPerformed(evt);
            }
        });

        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        panelErrore.setBackground(new java.awt.Color(255, 102, 102));
        panelErrore.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblErrore.setBackground(new java.awt.Color(255, 255, 255));
        lblErrore.setToolTipText("");

        javax.swing.GroupLayout panelErroreLayout = new javax.swing.GroupLayout(panelErrore);
        panelErrore.setLayout(panelErroreLayout);
        panelErroreLayout.setHorizontalGroup(
            panelErroreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelErroreLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblErrore, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelErroreLayout.setVerticalGroup(
            panelErroreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelErroreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblErrore, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodice, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnConferma)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancella))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(panelErrore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(txtCodice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(btn2)
                    .addComponent(btn3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4)
                    .addComponent(btn5)
                    .addComponent(btn6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7)
                    .addComponent(btn8)
                    .addComponent(btn9))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConferma)
                    .addComponent(btnCancella))
                .addGap(56, 56, 56)
                .addComponent(panelErrore, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn7ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        txtCodice.setText(txtCodice.getText() + "7");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);

    }//GEN-LAST:event_btn7ActionPerformed

    private void btn9ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        txtCodice.setText(txtCodice.getText() + "9");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnConfermaActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfermaActionPerformed
        String codice = txtCodice.getText();
        if (codice.equalsIgnoreCase("2538")) {
            lblErrore.setText("CODICE CORRETTO");
            GNI.setStanzaCorrente(GNI.getStanzaCorrente().getNord());
            Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + GNI.getStanzaCorrente().getNomeStanza(), true);
            Stanza edificioDentro = GNI.getStanzaCorrente();
            edificioDentro.setRaggiungibile(true);
            edificioDentro.setVisitata(true);
            edificioDentro.setVisibile(true);
            GNI.getStanza("edificio esterno").setMessaggioNord(MessaggioEdificioFuori.getNord());
            this.dispose();
        } else {
            panelErrore.setVisible(true);
            lblErrore.setText("CODICE ERRATO");
        }
    }//GEN-LAST:event_btnConfermaActionPerformed

    private void btnCancellaActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancellaActionPerformed
        txtCodice.setText("");
    }//GEN-LAST:event_btnCancellaActionPerformed

    private void btn1ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        txtCodice.setText(txtCodice.getText() + "1");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        txtCodice.setText(txtCodice.getText() + "2");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        txtCodice.setText(txtCodice.getText() + "3");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        txtCodice.setText(txtCodice.getText() + "4");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        txtCodice.setText(txtCodice.getText() + "5");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        txtCodice.setText(txtCodice.getText() + "6");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn8ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        txtCodice.setText(txtCodice.getText() + "8");
        Suono.riproduciTraccia(Utils.PERCORSO_SUONI_STANZE + "bip", false);
    }//GEN-LAST:event_btn8ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ImageIcon icon = new ImageIcon(Utils.PERCORSO_IMMAGINI_ICONE + "iconaGioco.png");
        this.setIconImage(icon.getImage());
        panelErrore.setVisible(false);
        Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_STANZE, "porta", jPanel);
        txtCodice.setEditable(false);
    }//GEN-LAST:event_formWindowOpened

    private void txtCodiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodiceKeyReleased

    }//GEN-LAST:event_txtCodiceKeyReleased

    private void txtCodiceKeyPressed(final java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodiceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent e = new ActionEvent(this, 1, "");
            btnConfermaActionPerformed(e);
        }
    }//GEN-LAST:event_txtCodiceKeyPressed


    public void avvia() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogPorta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDialogPorta dialog = new JDialogPorta(new JFrame(), true, GNI);
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
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnCancella;
    private javax.swing.JButton btnConferma;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblErrore;
    private javax.swing.JPanel panelErrore;
    private javax.swing.JTextField txtCodice;
    // End of variables declaration//GEN-END:variables
}
