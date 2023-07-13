/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.parser;

import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.Comando;

/**
 * @author Michele Matteucci
 * @author Giannantonio Sanrocco
 * @author Simone Petruzzella
 * La classe ParserOutput rappresenta l'output generato dal parser durante l'analisi di un comando.
 * Contiene informazioni sul comando e gli oggetti associati all'input.
 */
public class ParserOutput {

    private Comando comando;

    private Oggetto oggetto;

    private Oggetto invOggetto;

    private Oggetto genericoOggetto;

    /**
     * Crea un nuovo oggetto ParserOutput con il comando e l'oggetto specificati.
     *
     * @param comandoCorr Comando associato all'output.
     * @param oggettoCorr  Oggetto associato all'output.
     */
    public ParserOutput(final Comando comandoCorr, final Oggetto oggettoCorr) {
        this.comando = comandoCorr;
        this.oggetto = oggettoCorr;
    }

    /**
     * Crea un nuovo oggetto ParserOutput con il comando, l'oggetto e l'oggetto inventario specificati.
     *
     * @param comandoCorr     Comando associato all'output.
     * @param oggettoCorr      Oggetto associato all'output.
     * @param invoggettoCorr   Oggetto inventario associato all'output.
     */
    public ParserOutput(final Comando comandoCorr, final Oggetto oggettoCorr, final Oggetto invoggettoCorr) {
        this.comando = comandoCorr;
        this.oggetto = oggettoCorr;
        this.invOggetto = invoggettoCorr;
    }

    /**
     * Crea un nuovo oggetto ParserOutput con il comando, l'oggetto, l'oggetto inventario e l'oggetto generico specificati.
     *
     * @param comandoCorr       Comando associato all'output.
     * @param oggettoCorr        Oggetto associato all'output.
     * @param invoggettoCorr     Oggetto inventario associato all'output.
     * @param genericoggettoCorr Oggetto generico associato all'output.
     */
    public ParserOutput(final Comando comandoCorr, final Oggetto oggettoCorr, final  Oggetto invoggettoCorr, final Oggetto genericoggettoCorr) {
        this.comando = comandoCorr;
        this.oggetto = oggettoCorr;
        this.invOggetto = invoggettoCorr;
        this.genericoOggetto = genericoggettoCorr;
    }

    /**
     * Restituisce il comando associato a questo oggetto ParserOutput.
     *
     * @return Comando associato.
     */
    public Comando getComando() {
        return comando;
    }

    /**
     * Imposta il comando associato a questo oggetto ParserOutput.
     *
     * @param comandoCorr Comando da impostare.
     */
    public void setComando(final Comando comandoCorr) {
        this.comando = comandoCorr;
    }

    /**
     * Restituisce l'oggetto associato a questo oggetto ParserOutput.
     *
     * @return Oggetto associato.
     */
    public Oggetto getOggetto() {
        return oggetto;
    }

    /**
     * Imposta l'oggetto associato a questo oggetto ParserOutput.
     *
     * @param oggettoCorr Oggetto da impostare.
     */
    public void setOggetto(final Oggetto oggettoCorr) {
        this.oggetto = oggettoCorr;
    }

    /**
     * Restituisce l'oggetto inventario associato a questo oggetto ParserOutput.
     *
         * @return Oggetto inventario associato.
     */
    public Oggetto getInvOggetto() {
        return invOggetto;
    }

    /**
     * Imposta l'oggetto inventario associato a questo oggetto ParserOutput.
     *
     * @param invoggettoCorr Oggetto inventario da impostare.
     */
    public void setInvOggetto(final Oggetto invoggettoCorr) {
        this.invOggetto = invoggettoCorr;
    }

    /**
     * Restituisce l'oggetto generico associato a questo oggetto ParserOutput.
     *
     * @return Oggetto generico associato.
     */
    public Oggetto getGenericoOggetto() {
        return genericoOggetto;
    }

}
