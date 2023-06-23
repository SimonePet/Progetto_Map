/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import data.DatabaseController;
import di.uniba.map.b.adventure.Engine;
import di.uniba.map.b.adventure.GameDescription;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Vuoi salvare la partita?");

        YesButton.setText("SI");
        YesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesButtonActionPerformed(evt);
            }
        });

        NoButton.setText("NO");
        NoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoButtonActionPerformed(evt);
            }
        });

        jNomePartita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNomePartitaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(YesButton)
                                    .addGap(43, 43, 43)
                                    .addComponent(NoButton))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelErrore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jNomePartita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))))
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
                .addComponent(jLabelErrore, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesButtonActionPerformed
        //recupera nome partita
        String nomePartita = jNomePartita.getText();      
        if(nomePartita.equalsIgnoreCase("")){
            jLabelErrore.setText("inserire nome partita!!");
        }else{
            engine.getGame().setNomePartita(nomePartita);
            DatabaseController db;
            try {
                db = new DatabaseController("sa","");
                //crea la tabella match solo se non esiste
                db.creaTabellaPartita();
                //salva partita su DB
                String username = engine.getGame().getUsername();
                boolean b = engine.getGame().isFinished();
                int numSeconds = engine.getGame().getNumSeconds();
                int numMinutes = engine.getGame().getNumMinutes();
                int numMoves = engine.getGame().getNumMoves();
                GameDescription game = engine.getGame();
                db.salvaPartita(nomePartita, username, b, numSeconds, numMinutes, numMoves, game);
                db.stampaPartite();
                this.dispose();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_YesButtonActionPerformed

    private void jNomePartitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomePartitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNomePartitaActionPerformed

    private void NoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_NoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogAbbandona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogAbbandona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogAbbandona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogAbbandona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogAbbandona dialog = new JDialogAbbandona(new javax.swing.JFrame(), true, engine);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
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
