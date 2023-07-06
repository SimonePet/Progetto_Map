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

import swing.JDialogPorta;
import swing.JFrameApp;

/**
 * @author pierpaolo
 */
public final class Utils {
    private Utils() {
    }
    public static final String PERCORSO_ASSOLUTO = calcolaPercorsoAssoluto();
    public static final String ESTENSIONE_WAV = ".wav";
    public static final String PERCORSO_IMMAGINI_ICONE = "adventure" + File.separator + "resources" + File.separator + "immagini" + File.separator + "icone" + File.separator;
    public static final String PERCORSO_SUONI_STANZE = "adventure" + File.separator + "resources" + File.separator + "suoni" + File.separator + "stanze" + File.separator;
    public static final String PERCORSO_SUONI_OGGETTI = "adventure" + File.separator + "resources" + File.separator + "suoni" + File.separator + "oggetti" + File.separator;
    public static final String PERCORSO_IMMAGINI_STANZE = "adventure" + File.separator + "resources" + File.separator + "immagini" + File.separator + "stanze" + File.separator;
    public static final String PERCORSO_IMMAGINI_CONVERSAZIONE = "adventure" + File.separator + "resources" + File.separator + "immagini" + File.separator + "conversazione" + File.separator+"conversazione";
    public static final String PERCORSO_SUONI_CONVERSAZIONE = "adventure" + File.separator + "resources" + File.separator + "suoni" + File.separator + "conversazione" + File.separator;
    public static Set<String> loadFileListInSet(final File file) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            set.add(reader.readLine().trim().toLowerCase());
        }
        reader.close();
        return set;
    }

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

    private static String calcolaPercorsoAssoluto() {
        String percorsoAss = System.getProperty("user.dir");
        String sostituzione = "Progetto_Map";
        int indiceInizio = percorsoAss.indexOf("Progetto_Map");
        if (indiceInizio != -1) {
            percorsoAss = percorsoAss.substring(0, indiceInizio) + sostituzione;
            System.out.println("Nuovo testo: " + percorsoAss);
        } else {
            System.out.println("Sottostringa non trovata");
        }
        return percorsoAss;
    }

    public static void generaFinestraPorta(final JFrameApp frame, final GiocoNaufragioIsola gni) {
        JDialogPorta d = new JDialogPorta(frame, true, gni);
        d.setVisible(true);
    }

    public static String sostituisciPrimoCarattereMaiuscolo(final String input) {
        if (input == null || input.isEmpty()) {
            return input; // Restituisci l'input originale se la stringa è nulla o vuota
        }
        char primoCarattere = Character.toUpperCase(input.charAt(0));
        return primoCarattere + input.substring(1);
    }
}
