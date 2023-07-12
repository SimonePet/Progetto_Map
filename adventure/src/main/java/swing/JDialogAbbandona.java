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
import multimediali.Immagini;

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
        lblNomePartita = new javax.swing.JLabel();
        txtNomePartita = new javax.swing.JTextField();
        lblErroreNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblMessaggioSalva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        lblNomePartita.setBackground(new java.awt.Color(255, 255, 255));
        lblNomePartita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomePartita.setText("Nome partita:");

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

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblErroreNome, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(txtNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(btnSi)
                                .addGap(18, 18, 18)
                                .addComponent(btnNo))
                            .addComponent(lblMessaggioSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(lblNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(lblMessaggioSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSi)
                    .addComponent(btnNo))
                .addGap(30, 30, 30)
                .addComponent(lblNomePartita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErroreNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        lblNomePartita.setOpaque(true);
        Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_MENU, "sfondo frame start", jPanel);
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
