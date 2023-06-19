/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.type;

import di.uniba.map.b.adventure.Engine;

/**
 *
 * @author Giannantonio
 */
public abstract class StoreData {
    public abstract boolean add(Engine e);
    public abstract Engine fetch (String nameGame);
}