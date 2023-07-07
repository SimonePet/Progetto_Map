/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import di.uniba.map.b.adventure.GameDescription;

/**
 *
 * @author Giannantonio
 */
@FunctionalInterface
public interface SalvaPartita {
    public boolean esegui(final GameDescription partita);
}
