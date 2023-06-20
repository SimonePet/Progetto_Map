/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.parser;

import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.Comando;

/**
 *
 * @author pierpaolo
 */
public class ParserOutput {

    private Comando command;

    private Oggetto object;

    private Oggetto invObject;

    public ParserOutput(Comando command, Oggetto object) {
        this.command = command;
        this.object = object;
    }

    public ParserOutput(Comando command, Oggetto object, Oggetto invObejct) {
        this.command = command;
        this.object = object;
        this.invObject = invObejct;
    }

    public Comando getCommand() {
        return command;
    }

    public void setCommand(Comando command) {
        this.command = command;
    }

    public Oggetto getObject() {
        return object;
    }

    public void setObject(Oggetto object) {
        this.object = object;
    }

    public Oggetto getInvObject() {
        return invObject;
    }

    public void setInvObject(Oggetto invObject) {
        this.invObject = invObject;
    }

}
