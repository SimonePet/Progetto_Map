/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe che rappresenta una classifica basata sul punteggio massimo delle partite terminate.
 */
public class Classifica {
    private List<Partita> partite;

    /**
     * Crea un'istanza della classe Classifica con la lista di partite specificata.
     *
     * @param partiteCorr Lista di partite da utilizzare per la classifica.
     */
    public Classifica(final List<Partita> partiteCorr) {
        this.partite = partiteCorr;
    }


    /**
     * Ottiene la classifica degli utenti in base al punteggio massimo delle partite terminate.
     *
     * @return Una lista di oggetti Map.Entry<String, Integer> rappresentanti le coppie nome utente - punteggio massimo,
     *         ordinata in modo decrescente in base al punteggio.
     */
    public List<Map.Entry<String, Integer>> ottieniClassificaUtenti() {
        // Calcola il punteggio massimo per ogni utente delle partite terminate
        Map<String, Integer> punteggioMassimoperUtente =
                partite.stream()
                        .filter(p -> p.terminata()) // filtra solo le partite con attributo "terminata" a true
                        .collect(Collectors.groupingBy(Partita::getNomeUtente, // raggruppa per nome utente
                                Collectors.mapping(Partita::getPunteggio, Collectors.maxBy(Integer::compare)))) // calcola il punteggio massimo per ogni utente
                        .entrySet()
                        .stream()
                        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().orElse(0))); 
        // Lista di coppie chiave-valore
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(punteggioMassimoperUtente.entrySet());
        // Ordina la lista di Map.Entry in base al valore (punteggio) in ordine decrescente
        Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return entryList;
    }

}
