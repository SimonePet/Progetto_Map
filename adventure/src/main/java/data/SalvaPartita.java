/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.GameDescription;



/**
 * Interfaccia funzionale per il salvataggio di una partita.
 * Fornisce un metodo per eseguire il salvataggio di una partita, specificando un oggetto di tipo `GameDescription`.
 */
@FunctionalInterface
public interface SalvaPartita {
    /**
     * Esegue il salvataggio di una partita.
     *
     * @param partita Oggetto di tipo `GameDescription` che rappresenta la partita da salvare.
     * @return `true` se il salvataggio è stato eseguito con successo, `false` altrimenti.
     */
    boolean esegui(GameDescription partita);
}

