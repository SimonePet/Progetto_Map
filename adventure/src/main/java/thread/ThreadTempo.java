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
    private int numOre;
    private int numMinuti;
    private int numSecondi;
    private final JFrameApp frame;

    /**
     * Costruisce un nuovo oggetto ThreadTempo con i valori iniziali dei minuti e dei secondi.
     *
     * @param frameCorr              Frame corrente
     * @param numMinutiInizialiCorr  Numero di minuti iniziali
     * @param numSecondiInizialiCorr Numero di secondi iniziali
     */
    public ThreadTempo(final JFrameApp frameCorr, final int numMinutiInizialiCorr, final int numSecondiInizialiCorr, final int numOreCorr) {
        this.numOre = numOreCorr;
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
        for (int i = this.numSecondi + 60 * this.numMinuti + 3600 * this.numOre; i != -1; i++) {
            if (i % 3600 == 0 && i != 0) {
                this.numOre++;
                this.numMinuti = 0;
                this.numSecondi = 0;
                e.getGame().setNumOre(numOre);
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

            String ore;
            String minuti;
            String secondi;

            if (this.numOre < 10) {
                ore = "0" + this.numOre;
            } else {
                ore = "" + this.numOre;
            }
            if (this.numMinuti < 10) {
                minuti = "0" + this.numMinuti;
            } else {
                minuti = "" + this.numMinuti;
            }
            if (this.numSecondi < 10) {
                secondi = "0" + this.numSecondi;
            } else {
                secondi = "" + this.numSecondi;
            }
            stampaTempo(ore + ":" + minuti + ":" + secondi);

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
     * @param tempo T tempo da stampare
     */
    public void stampaTempo(final String tempo) {
        frame.scrivisuLabelTempo(tempo);
    }

}
