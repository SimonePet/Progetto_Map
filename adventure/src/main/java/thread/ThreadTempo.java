/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import di.uniba.map.b.adventure.Engine;
import swing.JFrameApp;

/**
 * @author Giannantonio
 */
public class ThreadTempo implements Runnable {
    private int numMinuti;
    private int numSecondi;
    private final JFrameApp frame;

    /**
     * Costruisce un nuovo oggetto ThreadTempo con i valori iniziali dei minuti e dei secondi.
     *
     * @param frameCorr il frame corrente
     * @param numMinutiInizialiCorr il numero di minuti iniziali
     * @param numSecondiInizialiCorr il numero di secondi iniziali
     */
    public ThreadTempo(final JFrameApp frameCorr, final int numMinutiInizialiCorr, final int numSecondiInizialiCorr) {
        this.numMinuti = numMinutiInizialiCorr;
        this.numSecondi = numSecondiInizialiCorr;
        this.frame = frameCorr;
    }


    /**
     * Esegue il thread per il conteggio del tempo.
     * Aggiorna i valori dei minuti e dei secondi e li comunica all'Engine.
     * Stampa il tempo corrente.
     * Si sospende per un secondo tra un aggiornamento e l'altro.
     */
    @Override
    public void run() {
        Engine e = frame.getEngine();
        int ore = 0;
        for (int i = this.numSecondi; i != -1; i++) {
            if (i % 3600 == 0 && i != 0) {
                ore++;
                e.getGame().setNumSecondi(numSecondi);
                e.getGame().setNumMinuti(numMinuti);
            } else {
                if (i % 60 == 0 && i != 0) {
                    this.numMinuti++;
                    this.numSecondi = 0;
                    e.getGame().setNumSecondi(numSecondi);
                    e.getGame().setNumMinuti(numMinuti);
                } else {
                    this.numSecondi++;
                    e.getGame().setNumSecondi(numSecondi);
                }
            }
            printTime(ore + ":" + this.numMinuti + ":" + this.numSecondi);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    /**
     * Stampa il tempo sulla label del frame.
     *
     * @param time il tempo da stampare
     */
    public void printTime(final String time) {
        frame.writeOnLabelTime(time);
    }

}
