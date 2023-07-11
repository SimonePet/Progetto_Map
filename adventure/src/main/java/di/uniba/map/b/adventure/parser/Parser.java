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
 * @author pierpaolo
 */
public class Parser {

    private final Set<String> stopwords;

    /**
     * Costruisce un nuovo oggetto Parser con l'insieme di stopwords specificato.
     *
     * @param stopwordsCorr Insieme di stopwords da utilizzare durante l'analisi del comando.
     */
    public Parser(final Set<String> stopwordsCorr) {
        this.stopwords = stopwordsCorr;
    }

    /**
     * Cerca un comando all'interno della lista dei comandi.
     *
     * @param token    Token del comando da cercare.
     * @param commands Lista dei comandi in cui effettuare la ricerca.
     * @return Indice del comando corrispondente se trovato, altrimenti -1.
     */
    private int cercaComando(final String token, final List<Comando> commands) {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getNomeComando().equals(token) || commands.get(i).getAliasComando().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Cerca un oggetto all'interno della lista degli oggetti.
     *
     * @param token   Token dell'oggetto da cercare.
     * @param objects Lista degli oggetti in cui effettuare la ricerca.
     * @return Indice dell'oggetto corrispondente se trovato, altrimenti -1.
     */
    private int cercaOggetto(final String token, final List<Oggetto> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getNomeOggetto().equals(token) || objects.get(i).getAliasOggetto().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Analizza un comando specifico e restituisce un oggetto ParserOutput che contiene
     * le informazioni estratte dal comando.
     *
     * @param comando               Comando da analizzare.
     * @param comandiAccettati      Lista dei comandi accettati.
     * @param oggettiStanzaCorrente Lista degli oggetti presenti nella stanza corrente.
     * @param inventario            Lista degli oggetti presenti nell'inventario.
     * @param oggettiGenerici       Lista degli oggetti generici.
     * @return Oggetto ParserOutput contenente le informazioni estratte dal comando.
     */
    public ParserOutput analizza(final String comando, final List<Comando> comandiAccettati,
                                 final List<Oggetto> oggettiStanzaCorrente, final List<Oggetto> inventario,
                                 final List<Oggetto> oggettiGenerici) {
        List<String> tokens = Utils.parseString(comando, stopwords);

        // Verifica che il token non sia vuoto
        if (!tokens.isEmpty()) {
            // Restituisce l'indice del comando, -1 se non trovato
            int indiceComando = cercaComando(tokens.get(0), comandiAccettati);

            if (indiceComando > -1) {
                // Se la dimensione dei token è maggiore di 1, significa che segue un'altra parola (oggetto o stanza)
                if (tokens.size() > 1) {
                    // Restituisce l'indice dell'oggetto nella stanza corrente, -1 se non trovato
                    int indiceOggetto = cercaOggetto(tokens.get(1), oggettiStanzaCorrente);
                    int indiceOggettoInv = -1;

                    // Se l'oggetto non esiste nella stanza corrente, ma ci sono più di due parole, verifica
                    if (indiceOggetto < 0 && tokens.size() > 2) {
                        indiceOggetto = cercaOggetto(tokens.get(2), oggettiStanzaCorrente);
                    }

                    // Se l'oggetto non è nella stanza corrente, verifica se è nell'inventario
                    if (indiceOggetto < 0) {
                        indiceOggettoInv = cercaOggetto(tokens.get(1), inventario);

                        if (indiceOggettoInv < 0 && tokens.size() > 2) {
                            indiceOggettoInv = cercaOggetto(tokens.get(2), inventario);
                        }
                    }

                    int indiceOggettoGen = -1;
                    if (indiceOggetto < 0 && indiceOggettoInv < 0) {
                        indiceOggettoGen = cercaOggetto(tokens.get(1), oggettiGenerici);

                        if (indiceOggettoGen < 0 && tokens.size() > 2) {
                            indiceOggettoGen = cercaOggetto(tokens.get(2), oggettiGenerici);
                        }
                    }

                    // Restituisce l'oggetto corrispondente se trovato
                    if (indiceOggetto > -1) {
                        return new ParserOutput(comandiAccettati.get(indiceComando),
                                oggettiStanzaCorrente.get(indiceOggetto), null, null);
                    } else if (indiceOggettoInv > -1) {
                        return new ParserOutput(comandiAccettati.get(indiceComando),
                                null, inventario.get(indiceOggettoInv), null);
                    } else if (indiceOggettoGen > -1) {
                        return new ParserOutput(comandiAccettati.get(indiceComando),
                                null, null, oggettiGenerici.get(indiceOggettoGen));
                    } else {
                        return new ParserOutput(comandiAccettati.get(indiceComando),
                                null, null, null);
                    }
                } else {
                    // Restituisce solo il comando senza oggetti associati
                    return new ParserOutput(comandiAccettati.get(indiceComando), null);
                }
            } else {
                // Comando non riconosciuto
                return new ParserOutput(null, null);
            }
        } else {
            // Comando vuoto
            return null;
        }
    }

}
