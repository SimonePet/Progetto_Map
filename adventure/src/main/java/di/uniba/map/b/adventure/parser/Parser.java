/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.parser;

import di.uniba.map.b.adventure.Utils;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.Comando;

import java.util.List;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class Parser {

    private final Set<String> stopwords;

    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    private int checkForCommand(String token, List<Comando> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getNomeComando().equals(token) || commands.get(i).getAliasComando().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int checkForObject(String token, List<Oggetto> obejcts) {
        for (int i = 0; i < obejcts.size(); i++) {
            System.out.println("Oggetto esaminato: "+ obejcts.get(i).getNomeOggetto());
            if (obejcts.get(i).getNomeOggetto().equals(token) || obejcts.get(i).getAliasOggetto().contains(token)) {
                    return i;
            }
        }
        return -1;
    }

    /* ATTENZIONE: il parser è implementato in modo abbastanza independete dalla lingua, ma riconosce solo
     * frasi semplici del tipo <azione> <oggetto> <oggetto>. Eventuali articoli o preposizioni vengono semplicemente
     * rimossi.
     */
    public ParserOutput parse(String comando, List<Comando> comandiAccettati, List<Oggetto> oggettiStanzaCorrente, List<Oggetto> inventario) {
         List<String>tokens = Utils.parseString(comando, stopwords);
        //verifico che il token non è vuoto
        if (!tokens.isEmpty()) {
            //Restituisco l'indice del comando, -1 se non lo ha trovato
            int indiceComando = checkForCommand(tokens.get(0), comandiAccettati);
            if (indiceComando > -1) {
                //Se la dimensione del token è maggiore di 1 vuol dire che ad un comando segue un'altra parola (ogg o stanza)
                if (tokens.size() > 1) {
                    //Restituisco l'indice dell'oggetto, -1 se non lo ha trovato
                    int indiceOggetto = checkForObject(tokens.get(1), oggettiStanzaCorrente);
                    int indiceOggettoInv = -1;
                    // Se l'ggetto non esiste, ma ho piu di sue parole, verifico
                    if (indiceOggetto < 0 && tokens.size() > 2) {
                        indiceOggetto = checkForObject(tokens.get(2), oggettiStanzaCorrente);
                    }
                    if (indiceOggetto < 0) {
                        indiceOggettoInv = checkForObject(tokens.get(1), inventario);
                        if (indiceOggettoInv < 0 && tokens.size() > 2) {
                            indiceOggettoInv = checkForObject(tokens.get(2), inventario);
                        }
                    }
                    if (indiceOggetto > -1 && indiceOggettoInv > -1) {
                        return new ParserOutput(comandiAccettati.get(indiceComando), oggettiStanzaCorrente.get(indiceOggetto), inventario.get(indiceOggettoInv));
                    } else if (indiceOggetto > -1) {
                        return new ParserOutput(comandiAccettati.get(indiceComando), oggettiStanzaCorrente.get(indiceOggetto), null);
                    } else if (indiceOggettoInv > -1) {
                        return new ParserOutput(comandiAccettati.get(indiceComando), null, inventario.get(indiceOggettoInv));
                    } else {
                        return new ParserOutput(comandiAccettati.get(indiceComando), null, null);
                    }
                } else {
                    return new ParserOutput(comandiAccettati.get(indiceComando), null);
                }
            } else {
                //Comando non riconosciuto
                return new ParserOutput(null, null);
            }
        } else {
            return null;
        }
    }

}
