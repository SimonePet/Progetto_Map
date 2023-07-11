/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import data.Classifica;
import data.database.DatabaseController;
import data.Partita;
import data.StampaListe;
import di.uniba.map.b.adventure.Utils;

import java.awt.Font;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JFrame;


public class JDialogClassificaUtenti extends javax.swing.JDialog {
    public JDialogClassificaUtenti(final java.awt.Frame parent, final boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private void initComponents() {

        lblMessaggioRanking = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jPanel = new javax.swing.JPanel();
        lblTitolo = new javax.swing.JLabel();

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

        lblMessaggioRanking.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
        lblMessaggioRanking.setText("Gli utenti nel ranking sono esclusivamente quelli ad aver terminato almeno una partita");

        jScrollPane.setMinimumSize(new java.awt.Dimension(116, 116));

        jPanel.setLayout(new java.awt.BorderLayout());
        jScrollPane.setViewportView(jPanel);

        lblTitolo.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 16)); // NOI18N
        lblTitolo.setText("RANKING UTENTI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMessaggioRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMessaggioRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    } // </editor-fold>                        

    private void formWindowOpened() {//GEN-FIRST:event_formWindowOpened
        this.setResizable(false);
        ImageIcon icon = new ImageIcon(Utils.PERCORSO_IMMAGINI_ICONE + "iconaGioco.png");
        this.setIconImage(icon.getImage());
        DatabaseController db;
        String[] nomiColonne = {"Utente", "massimo punteggio"};
        String[][] dati = new String[200][200];
        int i = 0;
        db = new DatabaseController();
        List<Partita> partite = db.ottieniListaPartite();
        List<Map.Entry<String, Integer>> listaCoppie;
        Classifica c = new Classifica(partite);
        listaCoppie = c.ottieniClassificaUtenti();
        StampaListe<Map.Entry<String, Integer>> stampaLista = new StampaListe<>(listaCoppie);
        System.out.println("CLASSIFICA UTENTI:");
        stampaLista.stampa();

        for (Map.Entry<String, Integer> entry : listaCoppie) {
            String nomeUtente = entry.getKey();
            Integer punteggioMax = entry.getValue();
            dati[i][0] = nomeUtente;
            dati[i][1] = punteggioMax.toString();
            i++;
        }

        Utils.stampaTabella(dati, nomiColonne, jScrollPane);

        db.chiudiConnessione();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed() {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed


    public static void avvio() {
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
            java.util.logging.Logger.getLogger(JDialogClassificaUtenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDialogClassificaUtenti dialog = new JDialogClassificaUtenti(new JFrame(), true);
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
    private javax.swing.JLabel lblMessaggioRanking;
    private javax.swing.JLabel lblTitolo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
