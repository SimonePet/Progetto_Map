/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.Utils;

import java.io.File;

/**
 *
 * @author Giannantonio
 */

public class PercorsoFileSystem {
    /**
     * Funzione che restituisce il percorso totale di un qualsiasi file del progetto.
     * @param percorso percorso all'interno della cartella principale del progetto
     * @return percorso del file
     */
    public static String trovaPercorso(final String percorso) {
        return Utils.percorsoAssoluto + File.separator + percorso;
    }
}
