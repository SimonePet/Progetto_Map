/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * Enumerazione dei tipi di comando disponibili nel gioco.
 * Ogni tipo di comando corrisponde a un'azione che il giocatore può compiere.
 * I tipi di comando includono le direzioni di movimento (nord, sud, est, ovest), comandi di interazione (apri, raccogli, lascia, osserva, aiuto),
 * comandi speciali (accendi, sposta, inventario, fine, narra, leggi, taglia, localizzazione, costruisci, ripara) e un tipo generico per i comandi non riconosciuti.
 */
public enum TipoComando {
    NORD, SUD, EST, OVEST, APRI, RACCOGLI, LASCIA, OSSERVA, AIUTO, ACCENDI, SPOSTA, INVENTARIO, FINE, NARRA, LEGGI, TAGLIA, LOCALIZZAZIONE, COSTRUISCI, RIPARA, COMANDO_NON_RICONOSCIUTO
}

