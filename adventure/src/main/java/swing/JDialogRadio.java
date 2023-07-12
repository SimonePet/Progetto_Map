/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import java.awt.Color;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;


import di.uniba.map.b.adventure.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import di.uniba.map.b.adventure.messaggi.MessaggiConversazione;
import multimediali.Immagini;
import thread.Client;
import thread.Server;

/**
 * @author Giannantonio
 */
public class JDialogRadio extends javax.swing.JDialog {
    public JDialogRadio(final java.awt.Frame parent, final boolean modal, final String nomeUtenteCorr) throws IOException, InterruptedException {
        super(parent, modal);
        JDialogRadio.nomeUtente = nomeUtenteCorr;
        initComponents();
    }

    private void initComponents() {
        jPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jPanelOpzioni = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        btnConferma = new javax.swing.JButton();
        lblTitolo = new javax.swing.JLabel();
        btnSpegniRadio = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(final java.awt.event.WindowEvent evt) {
                formWindowClosed();
            }

            @Override
            public void windowOpened(final java.awt.event.WindowEvent evt) {
                formWindowOpened();
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane.setViewportView(jTextArea);

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jRadioButton1.setText("Aiuto venitemi a salvare");
        jRadioButton1.addActionListener(this::jRadioButton1ActionPerformed);
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(final java.awt.event.KeyEvent evt) {
                jRadioButton1KeyPressed(evt);
            }

            public void keyReleased(final java.awt.event.KeyEvent evt) {
                jRadioButton1KeyReleased();
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        jRadioButton2.setText("Perfavore portatemi una birra");
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);
        jRadioButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(final java.awt.event.KeyEvent evt) {
                jRadioButton2KeyPressed(evt);
            }

            public void keyReleased(final java.awt.event.KeyEvent evt) {
                jRadioButton2KeyReleased();
            }
        });

        btnConferma.setText("CONFERMA");
        btnConferma.addActionListener(this::btnConfermaActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanelOpzioni);
        jPanelOpzioni.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                        .addComponent(btnConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(307, 307, 307))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblTitolo.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        lblTitolo.setText("CONVERSAZIONE RADIO CON MILITARI");

        btnSpegniRadio.setText("SPEGNI RADIO");
        btnSpegniRadio.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanelOpzioni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSpegniRadio)
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTitolo)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(btnSpegniRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelOpzioni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 516, Short.MAX_VALUE)
        );

        pack();
    } // </editor-fold>                        

    private void jRadioButton1ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton2.setSelected(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void formWindowOpened() {//GEN-FIRST:event_formWindowOpened
        this.setResizable(false);
        ImageIcon icon = new ImageIcon(Utils.PERCORSO_IMMAGINI_ICONE + "iconaGioco.png");
        this.setIconImage(icon.getImage());
        Color c = new Color(255, 255, 255, 150);
        jScrollPane.getViewport().setOpaque(false);
        jTextArea.setBackground(c);
        jTextArea.setOpaque(false);
        jScrollPane.setOpaque(false);
        jScrollPane.setBackground(c);
        jPanelOpzioni.setOpaque(false);
        jPanelOpzioni.setBackground(c);
        btnSpegniRadio.setOpaque(false);
        jPanelOpzioni.setBackground(c);
        try {
            Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_CONVERSAZIONE,"conversazione", jPanel);
            // avvia server socket
            avviaServer();
            // avvia connessione client socket al server socket
            avviaClient();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnConfermaActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfermaActionPerformed
        String messaggio;
        if (jRadioButton1.isSelected()) {
            messaggio = jRadioButton1.getText();
        } else {
            messaggio = jRadioButton2.getText();
        }
        //invia messaggio al server socket
        numDomanda++;
        Client.inviaMessaggio(messaggio);
        setNuoveDomande();
    }//GEN-LAST:event_btnConfermaActionPerformed

    private void jRadioButton1KeyReleased() {//GEN-FIRST:event_jRadioButton1KeyReleased

    }//GEN-LAST:event_jRadioButton1KeyReleased

    private void jRadioButton2KeyReleased() {//GEN-FIRST:event_jRadioButton2KeyReleased

    }//GEN-LAST:event_jRadioButton2KeyReleased

    private void jRadioButton2ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton2ActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        numDomanda = 1;
        Server.stop();
        threadS.interrupt();
        threadC.interrupt();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1KeyPressed(final java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent e = new ActionEvent(this, 1, "");
            btnConfermaActionPerformed(e);
        }
    }//GEN-LAST:event_jRadioButton1KeyPressed

    private void jRadioButton2KeyPressed(final java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent e = new ActionEvent(this, 1, "");
            btnConfermaActionPerformed(e);
        }
    }//GEN-LAST:event_jRadioButton2KeyPressed

    private void formWindowClosed() {//GEN-FIRST:event_formWindowClosed
        numDomanda = 1;
        Server.stop();
    }//GEN-LAST:event_formWindowClosed

    public static void avviaServer() throws IOException {
        Server threadServer = new Server();
        Thread t1 = new Thread(threadServer);
        t1.start();
        threadS = t1;
    }

    public static void avviaClient() {
        Client client = new Client("localhost", 1234);
        client.setTextArea(jTextArea);
        Thread t2 = new Thread(client);
        t2.start();
        threadC = t2;
    }

    public JTextArea getTextArea() {
        return jTextArea;
    }

    public void setNuoveDomande() {
        if (numDomanda == 2) {
            jRadioButton1.setText("Mi chiamo " + nomeUtente);
            jRadioButton2.setText(MessaggiConversazione.MSG_UTENTE_2_OPZ_1);
        } else if (numDomanda == 3) {
            jRadioButton1.setText(MessaggiConversazione.MSG_UTENTE_3_OPZ_1);
            jRadioButton2.setText(MessaggiConversazione.MSG_UTENTE_3_OPZ_2);
        } else if (numDomanda == 4) {
            jRadioButton1.setText(MessaggiConversazione.MSG_UTENTE_4_OPZ_1);
            jRadioButton2.setText(MessaggiConversazione.MSG_UTENTE_4_OPZ_2);
        } else if (numDomanda == 5) {
            jRadioButton1.setVisible(false);
            jRadioButton2.setVisible(false);
            btnConferma.setVisible(false);
        }
    }


    public static void avvia() {
        java.awt.EventQueue.invokeLater(() -> {
            JDialogRadio dialog = null;
            try {
                dialog = new JDialogRadio(new javax.swing.JFrame(), true, nomeUtente);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(JDialogRadio.class.getName()).log(Level.SEVERE, null, ex);
            }
            assert dialog != null;
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
    private javax.swing.JButton btnConferma;
    private javax.swing.JButton btnSpegniRadio;
    private javax.swing.JLabel lblTitolo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelOpzioni;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane;
    private static javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
    private static int numDomanda = 1;
    private static String nomeUtente;
    private static Thread threadS;
    private static Thread threadC;
}
