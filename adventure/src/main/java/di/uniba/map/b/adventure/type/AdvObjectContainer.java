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
 *
 * @author pierpaolo
 */
public class AdvObjectContainer extends Oggetto {

    private List<Oggetto> list = new ArrayList<>();

    public AdvObjectContainer(int id) {
        super(id);
    }

    public AdvObjectContainer(int id, String name) {
        super(id, name);
    }

    public AdvObjectContainer(int id, String name, String description) {
        super(id, name, description);
    }

    public AdvObjectContainer(int id, String name, String description, Set<String> alias) {
        super(id, name, description, alias);
    }

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
