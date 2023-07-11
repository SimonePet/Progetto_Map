/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Classe che rappresenta un oggetto contenitore.
 * Un oggetto contenitore è un tipo di oggetto che può contenere altri oggetti.
 * Estende la classe Oggetto e aggiunge la funzionalità di gestione degli oggetti contenuti.
 */
public class OggettoContenitore extends Oggetto {

    private List<Oggetto> list = new ArrayList<>();

    /**
     * Costruttore per la creazione di un oggetto contenitore con l'ID specificato.
     *
     * @param id ID dell'oggetto contenitore.
     */
    public OggettoContenitore(final int id) {
        super(id);
    }

    /**
     * Costruttore per la creazione di un oggetto contenitore con l'ID e il nome specificati.
     *
     * @param id   ID dell'oggetto contenitore.
     * @param name Nome dell'oggetto contenitore.
     */
    public OggettoContenitore(final int id, final String name) {
        super(id, name);
    }

    /**
     * Costruttore per la creazione di un oggetto contenitore con l'ID, il nome e la descrizione specificati.
     *
     * @param id          ID dell'oggetto contenitore.
     * @param name        Nome dell'oggetto contenitore.
     * @param description Descrizione dell'oggetto contenitore.
     */
    public OggettoContenitore(final int id, final String name, final String description) {
        super(id, name, description);
    }

    /**
     * Costruttore per la creazione di un oggetto contenitore con l'ID, il nome, la descrizione e gli alias specificati.
     *
     * @param id          ID dell'oggetto contenitore.
     * @param name        Nome dell'oggetto contenitore.
     * @param description Descrizione dell'oggetto contenitore.
     * @param alias       Alias dell'oggetto contenitore.
     */
    public OggettoContenitore(final int id, final String name, final String description, final Set<String> alias) {
        super(id, name, description, alias);
    }

    /**
     * Restituisce la lista degli oggetti contenuti nell'oggetto contenitore.
     *
     * @return Lista degli oggetti contenuti.
     */
    public List<Oggetto> getList() {
        return list;
    }

    /**
     * Imposta la lista degli oggetti contenuti nell'oggetto contenitore.
     *
     * @param listCorr Lista degli oggetti contenuti da impostare.
     */
    public void setList(final List<Oggetto> listCorr) {
        this.list = listCorr;
    }

    /**
     * Aggiunge un oggetto alla lista degli oggetti contenuti nell'oggetto contenitore.
     *
     * @param o Oggetto da aggiungere.
     */
    public void add(final Oggetto o) {
        list.add(o);
    }

}
