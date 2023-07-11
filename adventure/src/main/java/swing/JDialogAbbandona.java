/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import data.database.DatabaseController;
import data.EsistenzaPartita;
import data.FileMatchController;
import data.SalvaPartita;
import di.uniba.map.b.adventure.Engine;
import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Giannantonio
 */
public class JDialogAbbandona extends javax.swing.JDialog {

    /**
     * Creates new form JDialogAbbandona
     */
    public JDialogAbbandona(java.awt.Frame parent, boolean modal, Engine engine) {
        super(parent, modal);
        JDialogAbbandona.engine = engine;
        initComponents();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        YesButton = new javax.swing.JButton();
        NoButton = new javax.swing.JButton();
        jNomePartita = new javax.swing.JTextField();
        labelNomePartita = new javax.swing.JLabel();
        jLabelErrore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened();
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Vuoi salvare la partita?");

        YesButton.setText("SI");
        YesButton.addActionListener(this::YesButtonActionPerformed);

        NoButton.setText("NO");
        NoButton.addActionListener(this::NoButtonActionPerformed);

        jNomePartita.addActionListener(this::jNomePartitaActionPerformed);
        jNomePartita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jNomePartitaKeyPressed(evt);
            }
        });

        labelNomePartita.setText("Nome partita:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(labelNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(YesButton)
                                .addGap(43, 43, 43)
                                .addComponent(NoButton))
                            .addComponent(jLabelErrore, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YesButton)
                    .addComponent(NoButton))
                .addGap(36, 36, 36)
                .addComponent(labelNomePartita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelErrore, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesButtonActionPerformed
        DatabaseController db;
        boolean partitaEsistente;
        //recupera nome partita
        String nomePartita = jNomePartita.getText();   
        db = new DatabaseController();
        /* controlla esistenza partita con espressione lambda che fornisce 
        l'implementazione dell metodo test dell'interfaccia funzionale EsistenzaPartita */       
        EsistenzaPartita esistenzaPartita = (nome) -> db.partitaEsistente(nome);
        partitaEsistente = esistenzaPartita.test(nomePartita);   
        
        if(nomePartita.equalsIgnoreCase("")){
            jLabelErrore.setText("inserire nome partita!!");
        }else if(partitaEsistente){
            jLabelErrore.setText("nome partita già esistente");
        }else{
            engine.getGame().setNomePartita(nomePartita);
            //crea la tabella match solo se non esiste
            db.creaTabellaPartita();
            //salva partita su DB
            GameDescription partita = engine.getGame();
            // salva partita utilizzando interfaccia funzionale SalvaPartita
            // l'espressione lambda fornisce l'implementazione del metodo dell'interfaccia funzionale
            SalvaPartita salvaPartita = (p) -> db.salvaPartita(p);
            salvaPartita.esegui(partita);
            db.stampaPartite();
            //salva partita su file
            FileMatchController f = new FileMatchController("salvataggioPartita.txt","resources");
            try {
                f.addMatch((GiocoNaufragioIsola) engine.getGame());
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
            db.chiudiConnessione();
            this.dispose();
        }
    }//GEN-LAST:event_YesButtonActionPerformed

    private void jNomePartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomePartitaActionPerformed
    }//GEN-LAST:event_jNomePartitaActionPerformed

    private void NoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_NoButtonActionPerformed

    private void formWindowOpened() {//GEN-FIRST:event_formWindowOpened
        this.setResizable(false);
        ImageIcon icon = new ImageIcon(Utils.PERCORSO_IMMAGINI_ICONE +"iconaGioco.png");
        this.setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowOpened

    private void jNomePartitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNomePartitaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ActionEvent e = new ActionEvent(this,1,"");
            YesButtonActionPerformed(e);
        }       
    }//GEN-LAST:event_jNomePartitaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JDialogAbbandona dialog = new JDialogAbbandona(new javax.swing.JFrame(), true, engine);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NoButton;
    private javax.swing.JButton YesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelErrore;
    private javax.swing.JTextField jNomePartita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNomePartita;
    // End of variables declaration//GEN-END:variables
    private static Engine engine;
}
