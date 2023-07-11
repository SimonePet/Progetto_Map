/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.List;

/**
 * Classe per la stampa di liste di oggetti generici.
 *
 * @param <T> Il tipo generico degli oggetti nella lista.
 */
public class StampaListe<T> {
    private List<T> lista;

    /**
     * Costruttore della classe StampaListe.
     *
     * @param listaCorr La lista di oggetti generici.
     */
    public StampaListe(final List<T> listaCorr) {
        this.lista = listaCorr;
    }


    /**
     * Stampa gli elementi della lista.
     * Se un elemento è un'istanza della classe Partita, viene invocato il metodo stampaPartita().
     * Altrimenti, viene stampato direttamente l'elemento.
     */
    public void stampa() {
        for (T elemento : lista) {
            if (elemento.getClass() == Partita.class) {
                Partita p = (Partita) elemento;
                p.stampaPartita();
                System.out.println("-----------------------------------------------------------------------------");
            } else {
                System.out.println(elemento);
            }
        }
    }
}

