/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package swing;

import di.uniba.map.b.adventure.Utils;
import multimediali.Immagini;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe principale che rappresenta la finestra di avvio del gioco.
 * Permette all'utente di inserire un nome utente e avviare una nuova partita o caricare una partita esistente.
 * Mostra inoltre la classifica degli utenti registrati.
 */
public class FrameStart extends javax.swing.JFrame {
    /**
     * Crea una nuova istanza della classe FrameStart.
     * Inizializza i componenti grafici del frame.
     */
    public FrameStart() {
        initComponents();
    }

    /**
     * Inizializza tutti i componenti del Frame.
     */
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jPanel = new javax.swing.JPanel();
        lblNomeUtente = new javax.swing.JLabel();
        txtNomeUtente = new javax.swing.JTextField();
        btnNuovaPartita = new javax.swing.JButton();
        btnCaricaPartita = new javax.swing.JButton();
        lblNomeInesistente = new javax.swing.JLabel();
        btnRanking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            /**
             * Gestisce l'evento scatenato quando il mouse entra nella zona del componente corrente.
             * Richiama il metodo formMouseEntered() per gestire l'azione associata all'evento.
             *
             * @param evt Evento del mouse scatenato quando il mouse entra nella zona del componente corrente.
             */
            public void mouseEntered(final java.awt.event.MouseEvent evt) {
                formMouseEntered();
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            /**
             * Gestisce l'evento scatenato quando la finestra sta per essere chiusa.
             * Richiama il metodo formWindowClosing() per gestire l'azione associata all'evento.
             *
             * @param evt Evento della finestra scatenato quando la finestra sta per essere chiusa.
             */
            public void windowClosing(final java.awt.event.WindowEvent evt) {
                formWindowClosing();
            }

            /**
             * Gestisce l'evento scatenato quando la finestra sta per essere aperta.
             * Richiama il metodo formWindowClosing() per gestire l'azione associata all'evento.
             *
             * @param evt Evento della finestra scatenato quando la finestra sta per essere chiusa.
             */
            public void windowOpened(final java.awt.event.WindowEvent evt) {
                formWindowOpened();
            }
        });

        jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            /**
             * Invocato quando il cursore del mouse entra nell'area del pannello.
             *
             * @param evt Oggetto MouseEvent che rappresenta l'evento del mouse
             */
            public void mouseEntered(final java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered();
            }
        });

        lblNomeUtente.setText("USERNAME");

        txtNomeUtente.addKeyListener(new java.awt.event.KeyAdapter() {
            /**
             * Invocato quando viene premuto un tasto sulla tastiera mentre il campo di username ha il focus.
             *
             * @param evt Oggetto KeyEvent che rappresenta l'evento del tasto premuto
             */
            public void keyPressed(final java.awt.event.KeyEvent evt) {
                btnNuovaPartitaKeyPressed(evt);
            }
        });

        btnNuovaPartita.setText("NUOVA PARTITA");
        btnNuovaPartita.addActionListener(this::nuovaPartitaActionPerformed);
        btnCaricaPartita.setText("CARICA PARTITA");
        btnCaricaPartita.addActionListener(this::btnCaricaPartitaActionPerformed);

        btnRanking.setText("RANKING UTENTI");
        btnRanking.addActionListener(this::btnRankingActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNomeUtente, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNuovaPartita)
                                        .addComponent(txtNomeUtente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNomeInesistente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnRanking, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnCaricaPartita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblNomeUtente)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeUtente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lblNomeInesistente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNuovaPartita)
                                .addGap(18, 18, 18)
                                .addComponent(btnCaricaPartita)
                                .addGap(18, 18, 18)
                                .addComponent(btnRanking)
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * Gestisce l'evento scatenato dall'azione del pulsante "NUOVA PARTITA".
     * Crea un nuovo JFrameApp e lo visualizza se è stato inserito un username valido.
     * Se l'username è vuoto, visualizza un messaggio di avviso.
     *
     * @param evt Evento di azione scatenato dal pulsante "NUOVA PARTITA".
     */
    private void nuovaPartitaActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuovaPartitaActionPerformed
        String username = txtNomeUtente.getText();
        if (!username.equalsIgnoreCase("")) {
            JFrameApp frame = new JFrameApp(username, this);
            frame.avvio();
            lblNomeInesistente.setText("");
        } else {
            lblNomeInesistente.setText("Username mancante!");
        }
    }//GEN-LAST:event_nuovaPartitaActionPerformed


    /**
     * Gestisce l'azione eseguita quando viene cliccato il pulsante "carica partita".
     * Mostra una finestra di dialogo per caricare le partite di gioco.
     *
     * @param evt Evento di azione generato dal clic del pulsante
     */
    private void btnCaricaPartitaActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMatchActionPerformed
        JDialogCaricaPartite d = new JDialogCaricaPartite(this, true, this);
        d.setVisible(true);
    }//GEN-LAST:event_loadMatchActionPerformed


    /**
     * Gestisce l'azione eseguita quando viene cliccato il pulsante "btnRanking".
     * Mostra una finestra di dialogo per visualizzare la classifica degli utenti.
     *
     * @param evt Evento di azione generato dal clic del pulsante
     */
    private void btnRankingActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDialogClassificaUtenti d = new JDialogClassificaUtenti(this, true);
        d.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Gestisce l'evento generato quando la finestra viene aperta.
     * Imposta la finestra come non ridimensionabile, imposta l'icona della finestra
     * e carica un'immagine di sfondo nel pannello principale.
     */
    private void formWindowOpened() {//GEN-FIRST:event_formWindowOpened
        this.setResizable(false);
        Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_MENU, "sfondo frame start", jPanel);
    }//GEN-LAST:event_formWindowOpened

    /**
     * Gestisce l'evento generato quando viene premuto un tasto nel pulsante "btnNuovaPartita".
     * Se il tasto premuto è il tasto "Invio" (Enter), viene generato un evento di azione simulato
     * per eseguire l'azione di inizio di una nuova partita.
     *
     * @param evt Evento generato dal tasto premuto
     */
    private void btnNuovaPartitaKeyPressed(final java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent e = new ActionEvent(this, 1, "");
            nuovaPartitaActionPerformed(e);
        }
    }//GEN-LAST:event_usernameFieldKeyPressed

    private void formMouseEntered() {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void jPanel1MouseEntered() {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

    private void formWindowClosing() {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Avvia l'applicazione Swing.
     * Imposta il look and feel Nimbus come aspetto grafico predefinito.
     * Crea e visualizza un'istanza di FrameStart.
     */
    public static void avvia() {
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
            java.util.logging.Logger.getLogger(FrameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrameStart().setVisible(true));
    }

    private javax.swing.JLabel lblNomeInesistente;
    private javax.swing.JButton btnRanking;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblNomeUtente;
    private javax.swing.JButton btnCaricaPartita;
    private javax.swing.JButton btnNuovaPartita;
    private javax.swing.JTextField txtNomeUtente;
}
