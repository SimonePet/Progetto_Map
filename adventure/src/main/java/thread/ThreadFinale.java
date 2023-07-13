/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;
import java.awt.Frame;

import multimediali.Immagini;
import multimediali.Suono;
import swing.JDialogPunteggio;
import swing.JFrameApp;
import swing.JFrameFinale;

/**
 *
 * @author Giannantonio
 */
public class ThreadFinale implements Runnable{
    private JDialogPunteggio dialog;
    private JFrameApp frame;
    private GiocoNaufragioIsola gni;        
    
    public ThreadFinale(JDialogPunteggio dialog, JFrameApp frame){
       this.frame = frame;
       this.dialog = dialog; 
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            JOptionPane optionPane = new JOptionPane("Attenzione sembra sia successo quacosa! "
                    + "clicca OK per scoprire cosa è successo e ASPETTA!!", JOptionPane.WARNING_MESSAGE);
            JDialog d = optionPane.createDialog("AVVISO");
            d.setAlwaysOnTop(true);
            d.setVisible(true);
            d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Imposta la chiusura del dialogo

            Object valore = optionPane.getValue();
            // Verifica se il valore è "OK" (valore predefinito per il pulsante "OK")
            if (valore != null && valore.equals(JOptionPane.OK_OPTION)) {
                // Quando l'utente ha premuto il pulsante "OK"
                Suono.riproduciTraccia(Utils.PERCORSO_SUONO_FINALE + "finale sequel",true);
                dialog.dispose();
                frame.dispose();
                JFrameFinale frame = new JFrameFinale();
                frame.setDefaultCloseOperation(JFrameFinale.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setAlwaysOnTop(true); // Imposta il frame in primo piano
                frame.setVisible(true);
                Thread.interrupted();
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadFinale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
