/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

/**
 * L'interfaccia funzionale EsistenzaPartita definisce un metodo per verificare l'esistenza di una partita dato il nome della partita.
 */
@FunctionalInterface
public interface EsistenzaPartita {
    /**
     * Verifica l'esistenza di una partita dato il nome della partita.
     *
     * @param nomePartita Nome della partita da verificare.
     * @return true se la partita esiste, altrimenti false.
     */
    boolean test(String nomePartita);
}
