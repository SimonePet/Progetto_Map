/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import data.database.DatabaseController;
import di.uniba.map.b.adventure.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Giannantonio
 */
public class JDialogStats extends javax.swing.JDialog {

    /**
     * Creates new form JDialogStats
     */
    public JDialogStats(java.awt.Frame parent, boolean modal,String username) {
        super(parent, modal);
        this.username = username;
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
        jbtnPartite = new javax.swing.JButton();
        lblSaluto = new javax.swing.JLabel();
        jbtnPartiteUtente = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPunteggioMedio = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbtnPartite.setText("VISUALIZZA TUTTE LE PARTITE");
        jbtnPartite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPartiteActionPerformed(evt);
            }
        });

        lblSaluto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jbtnPartiteUtente.setText("VISUALIZZA TUTTE LE TUE PARTITE");
        jbtnPartiteUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPartiteUtenteActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(txtPunteggioMedio);

        jLabel1.setText("Punteggio medio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSaluto, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jbtnPartiteUtente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jbtnPartite)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblSaluto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnPartite)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnPartiteUtente)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setResizable(false);
        ImageIcon icon = new ImageIcon(Utils.PERCORSO_IMMAGINI_ICONE + "iconaGioco.png");
        this.setIconImage(icon.getImage());
        lblSaluto.setText("CIAO "+username.toUpperCase());
    }//GEN-LAST:event_formWindowOpened

    private void jbtnPartiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPartiteActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            DatabaseController db = new DatabaseController();
            ResultSet rs = db.getPartite();
            int i=0;
            String[] nomiColonne = { "Id", "Nome partita", "Nome utente","Punteggio","Durata","Terminata","Numero mosse" };
            String [][] dati = new String[200][200];
            while(rs.next()){
                dati[i][0] = Integer.toString(rs.getInt(1));
                dati[i][1] = rs.getString(2);
                dati[i][2] = rs.getString(3);
                dati[i][3] = Integer.toString(rs.getInt(4));
                dati[i][4] = ""+rs.getInt(5)+" min e "+rs.getInt(6)+" sec";
                dati[i][5] = ""+rs.getBoolean(7);
                dati[i][6] = Integer.toString(rs.getInt(8));    
                i++;
            }
            JTable tabella = new JTable(dati, nomiColonne);
            tabella.setFillsViewportHeight(true);

            // aggiunge tabella allo ScrollPane
            scrollPanel.setViewportView(tabella);
            scrollPanel.getViewport().add(tabella);
            scrollPanel.revalidate();
            scrollPanel.repaint();        
            double punteggioMedio = db.getPunteggioMedio();
            String punteggio = df.format(punteggioMedio);
            txtPunteggioMedio.setText(""+punteggio);
            db.chiudiConnessione();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnPartiteActionPerformed

    private void jbtnPartiteUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPartiteUtenteActionPerformed
        try {
            // TODO add your handling code here:
            DatabaseController db = new DatabaseController();
            ResultSet rs = db.getPartiteUtente(username);
            int i=0;
            String[] nomiColonne = { "Id", "Nome partita", "Nome utente","Punteggio","Durata","Terminata","Numero mosse" };
            String [][] dati = new String[200][200];
            while(rs.next()){
                dati[i][0] = Integer.toString(rs.getInt(1));
                dati[i][1] = rs.getString(2);
                dati[i][2] = rs.getString(3);
                dati[i][3] = Integer.toString(rs.getInt(4));
                dati[i][4] = ""+rs.getInt(5)+" min e "+rs.getInt(6)+" sec";
                dati[i][5] = ""+rs.getBoolean(7);
                dati[i][6] = Integer.toString(rs.getInt(8));    
                i++;
            }
            JTable tabella = new JTable(dati, nomiColonne);
            tabella.setFillsViewportHeight(true);

            scrollPanel.setViewportView(tabella);
            scrollPanel.getViewport().add(tabella);
            scrollPanel.revalidate();
            scrollPanel.repaint();
            double punteggioMedio = db.getPunteggioMedioUtente(username);
            String punteggio = df.format(punteggioMedio);
            txtPunteggioMedio.setText(""+punteggio);
            db.chiudiConnessione();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }      
    }//GEN-LAST:event_jbtnPartiteUtenteActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogStats dialog = new JDialogStats(new javax.swing.JFrame(), true, username);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnPartite;
    private javax.swing.JButton jbtnPartiteUtente;
    private javax.swing.JLabel lblSaluto;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTextPane txtPunteggioMedio;
    // End of variables declaration//GEN-END:variables
    static String username;
    static DecimalFormat df = new DecimalFormat("0.00");

}
