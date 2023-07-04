/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure;

import di.uniba.map.b.adventure.type.Comando;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class Utils {
    public static String percorsoAssoluto = calcolaPercorsoAssoluto();
    public static String estensioneWav= ".wav";
    public static String percorsoSuoniStanze = "adventure"+File.separator +"resources"+File.separator+"suoni"+File.separator+"stanze" + File.separator;
    public static String percorsoSuoniOggetti = "adventure"+File.separator +"resources"+File.separator+"suoni"+File.separator+"oggetti" + File.separator;
    public static Set<String> loadFileListInSet(File file) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            set.add(reader.readLine().trim().toLowerCase());
        }
        reader.close();
        return set;
    }

    public static List<String> parseString(String string, Set<String> stopwords) {
        List<String> tokens = new ArrayList<>();
        String[] split = string.toLowerCase().split("\\s+");
        for (String t : split) {
            if (!stopwords.contains(t)) {
                tokens.add(t);
            }
        }
        return tokens;
    }

    private static String calcolaPercorsoAssoluto(){
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

}
