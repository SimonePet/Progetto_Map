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
     * @param parent
     * @param modal
     * @param engine
     */
    public JDialogAbbandona(java.awt.Frame parent, boolean modal, Engine engine) {
        super(parent, modal);
        JDialogAbbandona.engine = engine;
        initComponents();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        lblMessaggioSalva = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        txtNomePartita = new javax.swing.JTextField();
        lblNomePartita = new javax.swing.JLabel();
        lblErroreNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel.setLayout(new java.awt.BorderLayout());

        lblMessaggioSalva.setText("Vuoi salvare la partita?");

        btnSi.setText("SI");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });

        btnNo.setText("NO");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        txtNomePartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePartitaActionPerformed(evt);
            }
        });
        txtNomePartita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomePartitaKeyPressed(evt);
            }
        });

        lblNomePartita.setText("Nome partita:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSi)
                                .addGap(43, 43, 43)
                                .addComponent(btnNo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblMessaggioSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblErroreNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNomePartita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblMessaggioSalva)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSi)
                    .addComponent(btnNo))
                .addGap(36, 36, 36)
                .addComponent(lblNomePartita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErroreNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        DatabaseController db;
        boolean partitaEsistente;
        //recupera nome partita
        String nomePartita = txtNomePartita.getText();   
        db = new DatabaseController();
        /* controlla esistenza partita con espressione lambda che fornisce 
        l'implementazione dell metodo test dell'interfaccia funzionale EsistenzaPartita */       
        EsistenzaPartita esistenzaPartita = (nome) -> db.partitaEsistente(nome);
        partitaEsistente = esistenzaPartita.test(nomePartita);   
        
        if(nomePartita.equalsIgnoreCase("")){
            lblErroreNome.setText("inserire nome partita!!");
        }else if(partitaEsistente){
            lblErroreNome.setText("nome partita già esistente");
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
    }//GEN-LAST:event_btnSiActionPerformed

    private void txtNomePartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePartitaActionPerformed
    }//GEN-LAST:event_txtNomePartitaActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setResizable(false);
        ImageIcon icon = new ImageIcon(Utils.PERCORSO_IMMAGINI_ICONE +"iconaGioco.png");
        this.setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowOpened

    private void txtNomePartitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomePartitaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ActionEvent e = new ActionEvent(this,1,"");
            btnSiActionPerformed(e);
        }       
    }//GEN-LAST:event_txtNomePartitaKeyPressed

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
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblErroreNome;
    private javax.swing.JLabel lblMessaggioSalva;
    private javax.swing.JLabel lblNomePartita;
    private javax.swing.JTextField txtNomePartita;
    // End of variables declaration//GEN-END:variables
    private static Engine engine;
}
