/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class Comando {

    private final TipoComando tipoComando;

    private final String nomeComando;

    private Set<String> aliasComando;

    public Comando(TipoComando type, String name) {
        this.tipoComando = type;
        this.nomeComando = name;
    }

    public Comando(TipoComando type, String name, Set<String> alias) {
        this.tipoComando = type;
        this.nomeComando = name;
        this.aliasComando = alias;
    }

    public String getName() {
        return this.nomeComando;
    }

    public Set<String> getAlias() {
        return this.aliasComando;
    }

    public void setAlias(Set<String> alias) {
        this.aliasComando = alias;
    }

    public void setAlias(String[] alias) {
        this.aliasComando = new HashSet<>(Arrays.asList(alias));
    }

    public TipoComando getType() {
        return this.tipoComando;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.tipoComando);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comando other = (Comando) obj;
        if (this.tipoComando != other.tipoComando) {
            return false;
        }
        return true;
    }

}
