/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package swing;

import data.Partita;
import data.database.DatabaseController;
import di.uniba.map.b.adventure.Utils;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import multimediali.Immagini;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.ImageIcon;


/**
 * @author Giannantonio
 */
public class JDialogStats extends javax.swing.JDialog {

    public JDialogStats(final java.awt.Frame parent, final boolean modal, final String usernameCorr) {
        super(parent, modal);
        JDialogStats.username = usernameCorr;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtnPartite = new javax.swing.JButton();
        lblSaluto = new javax.swing.JLabel();
        jbtnPartiteUtente = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        btnPartitaSpecifica = new javax.swing.JButton();
        lblNomePartita = new javax.swing.JLabel();
        txtNomePartita = new javax.swing.JTextField();
        lblPunteggio = new javax.swing.JLabel();
        txtPunteggio = new javax.swing.JTextField();
        lblErrore = new javax.swing.JLabel();
        btnPartiteTerminate = new javax.swing.JButton();
        txtPunteggioMedio = new javax.swing.JTextPane();

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

        jLabel1.setText("Punteggio medio:");

        btnPartitaSpecifica.setText("CERCA PARTITA");
        btnPartitaSpecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartitaSpecificaActionPerformed(evt);
            }
        });

        lblNomePartita.setText("Nome partita:");

        txtNomePartita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomePartitaKeyPressed(evt);
            }
        });

        lblPunteggio.setText("Punteggio:");

        lblErrore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnPartiteTerminate.setText("VISUALIZZA PARTITE TERMINATE");
        btnPartiteTerminate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartiteTerminateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSaluto, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(221, 221, 221)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPunteggioMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtnPartiteUtente, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(lblErrore, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnPartite, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNomePartita)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(lblPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(btnPartitaSpecifica, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(btnPartiteTerminate, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(280, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSaluto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPunteggioMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPartiteTerminate)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnPartite)
                    .addComponent(jbtnPartiteUtente))
                .addGap(29, 29, 29)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnPartitaSpecifica)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomePartita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(lblErrore, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtPunteggioMedio.setEditable(false);
        lblNomePartita.setVisible(false);
        txtNomePartita.setVisible(false);
        lblPunteggio.setVisible(false);
        txtPunteggio.setVisible(false);
        lblErrore.setVisible(false);
        this.setResizable(false);
        ImageIcon icon = new ImageIcon(Utils.PERCORSO_IMMAGINI_ICONE + "iconaGioco.png");
        this.setIconImage(icon.getImage());
        lblSaluto.setText("CIAO " + username.toUpperCase());
        Immagini.caricaImmagine(Utils.PERCORSO_IMMAGINI_MENU, "sfondo frame stats", jPanel1);

    }//GEN-LAST:event_formWindowOpened

    private void jbtnPartiteActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPartiteActionPerformed
        lblNomePartita.setVisible(false);
        txtNomePartita.setVisible(false);
        lblPunteggio.setVisible(false);
        txtPunteggio.setVisible(false);
        txtPunteggio.setText("");
        lblErrore.setVisible(false);
        this.setResizable(false);
        try {
            DatabaseController db = new DatabaseController();
            ResultSet rs = db.getPartite();
            int i = 0;
            String[] nomiColonne = {"Id", "Nome partita", "Nome utente", "Punteggio", "Durata", "Terminata", "Numero mosse"};
            String[][] dati = new String[RIGHE_TABELLA_PARTITE][COLONNE_TABELLA_PARTITE];
            while (rs.next()) {
                dati[i][0] = Integer.toString(rs.getInt(1));
                dati[i][1] = rs.getString(2);
                dati[i][2] = rs.getString(3);
                dati[i][3] = Integer.toString(rs.getInt(4));
                dati[i][4] = rs.getInt(5) + " : " + rs.getInt(6) + " : " + rs.getInt(7);
                dati[i][5] = String.valueOf(rs.getBoolean(8));
                dati[i][6] = Integer.toString(rs.getInt(9));
                i++;
            }
            Utils.stampaTabella(dati, nomiColonne, scrollPanel);
            double punteggioMedio = db.getPunteggioMedio();
            String punteggio = df.format(punteggioMedio);
            txtPunteggioMedio.setText(punteggio);
            db.chiudiConnessione();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnPartiteActionPerformed

    private void jbtnPartiteUtenteActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPartiteUtenteActionPerformed
        lblNomePartita.setVisible(false);
        txtNomePartita.setVisible(false);
        lblPunteggio.setVisible(false);
        txtPunteggio.setVisible(false);
        txtPunteggio.setText("");
        lblErrore.setText("");
        txtNomePartita.setText("");
        lblErrore.setVisible(false);
        this.setResizable(false);
        try {
            DatabaseController db = new DatabaseController();
            ResultSet rs = db.getPartiteUtente(username);
            int i = 0;
            String[] nomiColonne = {"Id", "Nome partita", "Nome utente", "Punteggio", "Durata", "Terminata", "Numero mosse"};
            String[][] dati = new String[RIGHE_TABELLA_PARTITE][COLONNE_TABELLA_PARTITE];
            while (rs.next()) {
                dati[i][0] = Integer.toString(rs.getInt(1));
                dati[i][1] = rs.getString(2);
                dati[i][2] = rs.getString(3);
                dati[i][3] = Integer.toString(rs.getInt(4));
                dati[i][4] = rs.getInt(5) + " : " + rs.getInt(6) + " : " + rs.getInt(7);
                dati[i][5] = String.valueOf(rs.getBoolean(8));
                dati[i][6] = Integer.toString(rs.getInt(9));
                i++;
            }
            Utils.stampaTabella(dati, nomiColonne, scrollPanel);
            double punteggioMedio = db.getPunteggioMedioUtente(username);
            String punteggio = df.format(punteggioMedio);
            txtPunteggioMedio.setText(punteggio);
            db.chiudiConnessione();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnPartiteUtenteActionPerformed

    private void btnPartitaSpecificaActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartitaSpecificaActionPerformed
        lblNomePartita.setVisible(true);
        txtNomePartita.setVisible(true);
        lblPunteggio.setVisible(true);
        txtPunteggio.setVisible(true);
        lblErrore.setText("");
        txtNomePartita.setText("");
        lblErrore.setVisible(true);
    }//GEN-LAST:event_btnPartitaSpecificaActionPerformed

    private void txtNomePartitaKeyPressed(final java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomePartitaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new ActionEvent(this, 1, "");
            DatabaseController db = new DatabaseController();
            //verifica esistenza partita
            String nomePartita = txtNomePartita.getText();
            int punteggio;
            boolean partitaEsiste = db.partitaEsistente(nomePartita);
            if (partitaEsiste) {
                punteggio = db.getPunteggio(txtNomePartita.getText());
                txtPunteggio.setText(String.valueOf(punteggio));
                lblErrore.setText("");
            } else {
                txtPunteggio.setText("");
                lblErrore.setText("PARTITA NON ESISTENTE!");
            }
            db.chiudiConnessione();
        }
    }//GEN-LAST:event_txtNomePartitaKeyPressed

    private void btnPartiteTerminateActionPerformed(final java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartiteTerminateActionPerformed
        DatabaseController db = new DatabaseController();
        List<Partita> partite = db.ottieniListaPartite();
        // implementazione del metodo test dell'interfaccia funzionale Predicate<Partita> con espressione lambda
        visualizzaPartiteTerminate(partite,
                p -> p.terminata()
        );
    }//GEN-LAST:event_btnPartiteTerminateActionPerformed

    // Predicate<T> è un'interfaccia funzionale
    public void visualizzaPartiteTerminate(final List<Partita> partite, final Predicate<Partita> tester) {
        int i = 0;
        DatabaseController db = new DatabaseController();
        String[] nomiColonne = {"Id", "Nome partita", "Nome utente", "Punteggio", "Durata", "Terminata", "Numero mosse"};
        String[][] dati = new String[RIGHE_TABELLA_PARTITE][COLONNE_TABELLA_PARTITE];

        // inserisce partita nella tabella solo se la partita è terminata
        // il metodo test verifica se la partita è terminata
        for (Partita p : partite) {
            if (tester.test(p)) {
                dati[i][0] = Integer.toString(p.getId());
                dati[i][1] = p.getNome();
                dati[i][2] = p.getNomeUtente();
                dati[i][3] = Integer.toString(p.getPunteggio());
                dati[i][4] = p.getNumOre() + " : " + p.getNumMinuti() + " : " + p.getNumSecondi();
                dati[i][5] = String.valueOf(p.terminata());
                dati[i][6] = Integer.toString(p.getNumMosse());
                i++;
            }
        }

        Utils.stampaTabella(dati, nomiColonne, scrollPanel);
        double punteggioMedio = db.getPunteggioTerminate();
        String punteggio = df.format(punteggioMedio);
        txtPunteggioMedio.setText(punteggio);
        db.chiudiConnessione();
    }


    public static void avvia() {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDialogStats dialog = new JDialogStats(new javax.swing.JFrame(), true, username);
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
    private javax.swing.JButton btnPartitaSpecifica;
    private javax.swing.JButton btnPartiteTerminate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnPartite;
    private javax.swing.JButton jbtnPartiteUtente;
    private javax.swing.JLabel lblErrore;
    private javax.swing.JLabel lblNomePartita;
    private javax.swing.JLabel lblPunteggio;
    private javax.swing.JLabel lblSaluto;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTextField txtNomePartita;
    private javax.swing.JTextField txtPunteggio;
    private javax.swing.JTextPane txtPunteggioMedio;
    // End of variables declaration//GEN-END:variables
    private static String username;
    private static DecimalFormat df = new DecimalFormat("0.00");
    static final int RIGHE_TABELLA_PARTITE = 100;
    static final int COLONNE_TABELLA_PARTITE = 100;

}
