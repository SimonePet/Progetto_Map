/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import di.uniba.map.b.adventure.games.GiocoNaufragioIsola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import swing.JDialogPorta;
import swing.JDialogPunteggio;
import swing.JFrameApp;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Classe di utilità che fornisce metodi statici per operazioni comuni.
 * La classe è stata dichiarata finale e con un costruttore privato per impedire l'istanziazione di oggetti.
 */
public final class Utils {
    /**
     * Classe di utilità che fornisce metodi statici per operazioni comuni.
     * La classe è stata dichiarata con un costruttore privato per impedire l'istanziazione di oggetti.
     */
    private Utils() {
    }

    public static final String PERCORSO_ASSOLUTO = calcolaPercorsoAssoluto();
    public static final String PERCORSO_IMMAGINI_MENU = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "immagini" + File.separator + "menu" + File.separator;
    public static final String PERCORSO_IMMAGINI_ICONE = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "immagini" + File.separator + "icone" + File.separator;
    public static final String PERCORSO_SUONI_STANZE = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "suoni" + File.separator + "stanze" + File.separator;
    public static final String PERCORSO_IMMAGINI_STANZE = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "immagini" + File.separator + "stanze" + File.separator;
    public static final String PERCORSO_IMMAGINI_CONVERSAZIONE = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "immagini" + File.separator + "conversazione" + File.separator;
    public static final String PERCORSO_SUONI_CONVERSAZIONE = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "suoni" + File.separator + "conversazione" + File.separator;
    public static final String PERCORSO_DATABASE = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "db";
    public static String PERCORSO_FILES;
    public static final String PERCORSO_STOPWORDS = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "stopwords";
    public static final String PERCORSO_SUONO_FINALE = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + "resources" + File.separator + "suoni" + File.separator + "finale" + File.separator;


    /**
     * Carica il contenuto di un file in un insieme di stringhe.
     *
     * @param file Il file da caricare.
     * @return Un insieme di stringhe contenente il contenuto del file.
     * @throws IOException Se si verifica un errore durante la lettura del file.
     */
    public static Set<String> loadFileListInSet(final File file) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            set.add(reader.readLine().trim().toLowerCase());
        }
        reader.close();
        return set;
    }

    /**
     * Analizza una stringa in token utilizzando un insieme di stopwords per filtrare i token.
     *
     * @param string    La stringa da analizzare.
     * @param stopwords L'insieme di stopwords.
     * @return Una lista di token filtrati.
     */
    public static List<String> parseString(final String string, final Set<String> stopwords) {
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for (String t : split) {
            if (!stopwords.contains(t)) {
                tokens.add(t);
            }
        }
        return tokens;
    }

    /**
     * Calcola il percorso assoluto della directory di lavoro.
     *
     * @return Il percorso assoluto della directory di lavoro.
     */
    private static String calcolaPercorsoAssoluto() {
        String percorsoAss = System.getProperty("user.dir");
        String sostituzione = "Progetto_Map";
        int indiceInizio = percorsoAss.indexOf("Progetto_Map");
        if (indiceInizio != -1) {
            percorsoAss = percorsoAss.substring(0, indiceInizio) + sostituzione;
        } else {
            percorsoAss = percorsoAss + File.separator + sostituzione;
        }
        return percorsoAss;
    }

    /**
     * Genera una finestra di dialogo per la porta.
     *
     * @param frame L'istanza del frame principale.
     * @param gni   L'istanza di GiocoNaufragioIsola.
     */
    public static void generaFinestraPorta(final JFrameApp frame, final GiocoNaufragioIsola gni) {
        JDialogPorta d = new JDialogPorta(frame, true, gni);
        d.setVisible(true);
    }

    /**
     * Genera una finestra di dialogo per il punteggio.
     *
     * @param frame L'istanza del frame principale.
     * @param gni   L'istanza di GiocoNaufragioIsola.
     */
    public static void generaFinestraPunteggio(final JFrameApp frame, final GiocoNaufragioIsola gni) {
        JDialogPunteggio d = new JDialogPunteggio(frame, true, gni);
        d.setVisible(true);
    }

    /**
     * Sostituisce il primo carattere di una stringa con la sua versione maiuscola.
     *
     * @param input La stringa da elaborare.
     * @return La stringa con il primo carattere maiuscolo.
     */
    public static String sostituisciPrimoCarattereMaiuscolo(final String input) {
        if (input == null || input.isEmpty()) {
            return input; // Restituisci l'input originale se la stringa è nulla o vuota
        }
        char primoCarattere = Character.toUpperCase(input.charAt(0));
        return primoCarattere + input.substring(1);
    }

    /**
     * Calcola il percorso del file specificato nella cartella specificata.
     *
     * @param nome     Il nome del file.
     * @param cartella La cartella in cui si trova il file.
     */
    public static void calcolaPercorsoFile(final String nome, final String cartella) {
        PERCORSO_FILES = PERCORSO_ASSOLUTO + File.separator + "adventure" + File.separator + cartella + File.separator + nome;
    }
    
    public static void stampaTabella(final String[][] dati, final String[] colonne, final JScrollPane panel){
        JTable tabella = new JTable(dati, colonne);
        tabella.setFillsViewportHeight(true);
        //aggiunge tabella allo ScrollPane
        panel.setViewportView(tabella);
        panel.getViewport().add(tabella);
        panel.revalidate();
        panel.repaint();
    }
    
}
