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
 *
 * @author Giannantonio
 */
public class Classifica {
    private List<Partita> partite = new ArrayList<>();
    
    public Classifica(final List<Partita> partite){
        this.partite = partite;
    }
    
    public List<Map.Entry<String, Integer>> ottieniClassificaUtenti() {
    Map<String, Integer> punteggioMassimoperUtente = 
        partite.stream()
        .filter(Partita::terminata) // filtra solo le partite con attributo "finita" a true
        .collect(Collectors.groupingBy(Partita::getNomeUtente,
            Collectors.mapping(Partita::getPunteggio, Collectors.maxBy(Integer::compare))))
        .entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().orElse(0)));

        //lista di coppie chiave-valore
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(punteggioMassimoperUtente.entrySet());
        // Ordina la lista di Map.Entry in base al valore
        Collections.sort(entryList, Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return entryList;
    }
}
