/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class Inventario {

    private List<Oggetto> list = new ArrayList<>();

    public List<Oggetto> getList() {
        return list;
    }

    public void setList(List<Oggetto> list) {
        this.list = list;
    }

    public void add(Oggetto o) {
        list.add(o);
    }

    public void remove(Oggetto o) {
        list.remove(o);
    }
}
