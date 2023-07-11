/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe per la gestione dell'inventario.
 */
public class Inventario {
    private List<Oggetto> listaOggetti = new ArrayList<>();

    /**
     * Metodo get che restituisce la lista degli oggetti nell'inventario.
     * @return lista di oggetti dell'inventario.
     */
    public List<Oggetto> getList() {
        return this.listaOggetti;
    }

    /**
     * Metodo set per impostare la lista di oggetti nell'inventario.
     * @param listaOggettiCorr lista oggetti.
     */
    public void setList(final List<Oggetto> listaOggettiCorr) {
        this.listaOggetti = listaOggettiCorr;
    }
}
