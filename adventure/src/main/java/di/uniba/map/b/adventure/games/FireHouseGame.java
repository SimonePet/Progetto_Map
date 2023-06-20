/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.adventure.games;

import di.uniba.map.b.adventure.GameDescription;
import di.uniba.map.b.adventure.parser.ParserOutput;
import di.uniba.map.b.adventure.type.Oggetto;
import di.uniba.map.b.adventure.type.AdvObjectContainer;
import di.uniba.map.b.adventure.type.Comando;
import di.uniba.map.b.adventure.type.TipoComando;
import di.uniba.map.b.adventure.type.Stanza;
import swing.JFrameApp;
import java.io.PrintStream;
import java.util.Iterator;

/**
 * ATTENZIONE: La descrizione del gioco è fatta in modo che qualsiasi gioco
 * debba estendere la classe GameDescription. L'Engine è fatto in modo che possa
 * eseguire qualsiasi gioco che estende GameDescription, in questo modo si
 * possono creare più gioci utilizzando lo stesso Engine.
 *
 * Diverse migliorie possono essere applicate: - la descrizione del gioco
 * potrebbe essere caricate da file o da DBMS in modo da non modificare il
 * codice sorgente - l'utilizzo di file e DBMS non è semplice poiché all'interno
 * del file o del DBMS dovrebbe anche essere codificata la logica del gioco
 * (nextMove) oltre alla descrizione di stanze, oggetti, ecc...
 *
 * @author pierpaolo
 */
public class FireHouseGame extends GameDescription {

    @Override
    public void init() throws Exception {
        //Commands
        Comando nord = new Comando(TipoComando.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD"});
        getCommands().add(nord);
        Comando iventory = new Comando(TipoComando.INVENTARIO, "inventario");
        iventory.setAlias(new String[]{"inv"});
        getCommands().add(iventory);
        Comando sud = new Comando(TipoComando.SUD, "sud");
        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
        getCommands().add(sud);
        Comando est = new Comando(TipoComando.EST, "est");
        est.setAlias(new String[]{"e", "E", "Est", "EST"});
        getCommands().add(est);
        Comando ovest = new Comando(TipoComando.OVEST, "ovest");
        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
        getCommands().add(ovest);
        Comando end = new Comando(TipoComando.FINE, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
        getCommands().add(end);
        Comando look = new Comando(TipoComando.OSSERVA, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        getCommands().add(look);
        Comando pickup = new Comando(TipoComando.RACCOGLI, "raccogli");
        pickup.setAlias(new String[]{"prendi"});
        getCommands().add(pickup);
        Comando open = new Comando(TipoComando.APRI, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);
        Comando push = new Comando(TipoComando.PREMI, "premi");
        push.setAlias(new String[]{"spingi", "attiva"});
        getCommands().add(push);
        //Rooms
        Stanza hall = new Stanza(0, "Corridoio", "Sei appena tornato a casa e non sai cosa fare.\nTi ricordi che non hai ancora aperto quel fantastico regalo di tua zia Lina.\n"
                + " Sarà il caso di cercarlo e di giocarci!");
        hall.setLook("Sei nel corridoio, a nord vedi il bagno, a sud il soggiorno e ad ovest la tua cameretta, forse il gioco sarà lì?");
        Stanza livingRoom = new Stanza(1, "Soggiorno", "Ti trovi nel soggiorno.\nCi sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.");
        livingRoom.setLook("Non c'è nulla di interessante qui.");
        Stanza kitchen = new Stanza(2, "Cucina", "Ti trovi nella solita cucina.\nMobili bianchi, maniglie azzurre, quello strano lampadario che adoravi tanto quando eri piccolo.\n"
                + "C'è un tavolo con un bel portafrutta e una finestra.");
        kitchen.setLook("La solita cucina, ma noti una chiave vicino al portafrutta.");
        Stanza bathroom = new Stanza(3, "Bagno", "Sei nel bagno.\nQuanto tempo passato qui dentro...meglio non pensarci...");
        bathroom.setLook("Vedo delle batterie sul mobile alla destra del lavandino.");
        Stanza yourRoom = new Stanza(4, "La tua cameratta", "Finalmente la tua cameretta!\nQuesto luogo ti è così famigliare...ma non ricordi dove hai messo il nuovo regalo di zia Lina.");
        yourRoom.setLook("C'è un armadio bianco, di solito ci conservi i tuoi giochi.");
        //map
        kitchen.setEast(livingRoom);
        livingRoom.setNorth(hall);
        livingRoom.setOvest(kitchen);
        hall.setSouth(livingRoom);
        hall.setOvest(yourRoom);
        hall.setNorth(bathroom);
        bathroom.setSouth(hall);
        yourRoom.setEast(hall);
        getRooms().add(kitchen);
        getRooms().add(livingRoom);
        getRooms().add(hall);
        getRooms().add(bathroom);
        getRooms().add(yourRoom);
        //obejcts
        Oggetto battery = new Oggetto(1, "batteria", "Un pacco di batterie, chissà se sono cariche.");
        battery.setAlias(new String[]{"batterie", "pile", "pila"});
        bathroom.getObjects().add(battery);
        AdvObjectContainer wardrobe = new AdvObjectContainer(2, "armadio", "Un semplice armadio.");
        wardrobe.setAlias(new String[]{"guardaroba", "vestiario"});
        wardrobe.setApribile(true);
        wardrobe.setRaccogglibile(false);
        wardrobe.setAperto(false);
        yourRoom.getObjects().add(wardrobe);
        Oggetto toy = new Oggetto(3, "giocattolo", "Il gioco che ti ha regalato zia Lina.");
        toy.setAlias(new String[]{"gioco", "robot"});
        toy.setPremibile(true);
        toy.setPremuto(false);
        wardrobe.add(toy);
        Oggetto kkey = new Oggetto(4, "chiave", "Usa semplice chiave come tante altre.");
        toy.setAlias(new String[]{"key"});
        toy.setPremibile(false);
        toy.setPremuto(false);
        kitchen.getObjects().add(kkey);
        //set starting room
        setCurrentRoom(hall);
    }

    @Override
    public void nextMove(ParserOutput p, PrintStream out) {
        if (p.getCommand() == null) {
            out.println("Non ho capito cosa devo fare! Prova con un altro comando.");
        } else {
            //move
            boolean noroom = false;
            boolean move = false;
            if (p.getCommand().getTipoComando() == TipoComando.NORD) {
                if (getCurrentRoom().getNord() != null) {
                    setCurrentRoom(getCurrentRoom().getNord());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.SUD) {
                if (getCurrentRoom().getSud() != null) {
                    setCurrentRoom(getCurrentRoom().getSud());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.EST) {
                if (getCurrentRoom().getEst() != null) {
                    setCurrentRoom(getCurrentRoom().getEst());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.OVEST) {
                if (getCurrentRoom().getOvest() != null) {
                    setCurrentRoom(getCurrentRoom().getOvest());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.INVENTARIO) {
                out.println("Nel tuo inventario ci sono:");
                for (Oggetto o : getInventory()) {
                    out.println(o.getNomeOggetto() + ": " + o.getDescrizioneOggetto());
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.OSSERVA) {
                if (getCurrentRoom().getLook() != null) {
                    out.println(getCurrentRoom().getLook());
                } else {
                    out.println("Non c'è niente di interessante qui.");
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.RACCOGLI) {
                if (p.getObject() != null) {
                    if (p.getObject().isRaccogglibile()) {
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        out.println("Hai raccolto: " + p.getObject().getDescrizioneOggetto());
                    } else {
                        out.println("Non puoi raccogliere questo oggetto.");
                    }
                } else {
                    out.println("Non c'è niente da raccogliere qui.");
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.APRI) {
                /*ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                 * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                 * Potrebbe non esssere la soluzione ottimale.
                 */
                if (p.getObject() == null && p.getInvObject() == null) {
                    out.println("Non c'è niente da aprire qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isApribile() && p.getObject().isAperto() == false) {
                            if (p.getObject() instanceof AdvObjectContainer) {
                                out.println("Hai aperto: " + p.getObject().getNomeOggetto());
                                AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getNomeOggetto() + " contiene:");
                                    Iterator<Oggetto> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Oggetto next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        out.print(" " + next.getNomeOggetto());
                                        it.remove();
                                    }
                                    out.println();
                                }
                                p.getObject().setAperto(true);
                            } else {
                                out.println("Hai aperto: " + p.getObject().getNomeOggetto());
                                p.getObject().setAperto(true);
                            }
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isApribile() && p.getInvObject().isAperto() == false) {
                            if (p.getInvObject() instanceof AdvObjectContainer) {
                                AdvObjectContainer c = (AdvObjectContainer) p.getInvObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getNomeOggetto() + " contiene:");
                                    Iterator<Oggetto> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Oggetto next = it.next();
                                        getInventory().add(next);
                                        out.print(" " + next.getNomeOggetto());
                                        it.remove();
                                    }
                                    out.println();
                                }
                                p.getInvObject().setAperto(true);
                            } else {
                                p.getInvObject().setAperto(true);
                            }
                            out.println("Hai aperto nel tuo inventario: " + p.getInvObject().getDescrizioneOggetto());
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.PREMI) {
                //ricerca oggetti pushabili
                if (p.getObject() != null && p.getObject().isPremibile()) {
                    out.println("Hai premuto: " + p.getObject().getNomeOggetto());
                    if (p.getObject().getIdOggetto() == 3) {
                        end(out);
                    }
                } else if (p.getInvObject() != null && p.getInvObject().isPremibile()) {
                    out.println("Hai premuto: " + p.getInvObject().getNomeOggetto());
                    if (p.getInvObject().getIdOggetto() == 3) {
                        end(out);
                    }
                } else {
                    out.println("Non ci sono oggetti che puoi premere qui.");
                }
            }
            if (noroom) {
                out.println("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...");
            } else if (move) {
                out.println(getCurrentRoom().getNomeStanza());
                out.println("================================================");
                out.println(getCurrentRoom().getDescrizioneStanza());
            }
        }
    }


    /* nextMove per scrivere su editor del frame */
    public void nextMove(ParserOutput p, PrintStream out, JFrameApp frame) {
        if (p.getCommand() == null) {
            out.println("Non ho capito cosa devo fare! Prova con un altro comando.");
            frame.writeTextOnEditor("Non ho capito cosa devo fare! Prova con un altro comando.\n");
        } else {
            //move
            boolean noroom = false;
            boolean move = false;
            if (p.getCommand().getTipoComando() == TipoComando.NORD) {
                if (getCurrentRoom().getNord() != null) {
                    setCurrentRoom(getCurrentRoom().getNord());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.SUD) {
                if (getCurrentRoom().getSud() != null) {
                    setCurrentRoom(getCurrentRoom().getSud());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.EST) {
                if (getCurrentRoom().getEst() != null) {
                    setCurrentRoom(getCurrentRoom().getEst());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.OVEST) {
                if (getCurrentRoom().getOvest() != null) {
                    setCurrentRoom(getCurrentRoom().getOvest());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.INVENTARIO) {
                frame.writeTextOnEditor("Nel tuo inventario ci sono:\n");
                out.println("Nel tuo inventario ci sono:");
                for (Oggetto o : getInventory()) {
                    out.println(o.getNomeOggetto() + ": " + o.getDescrizioneOggetto());
                    frame.writeTextOnEditor(o.getNomeOggetto() + ": " + o.getDescrizioneOggetto()+"\n");
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.OSSERVA) {
                if (getCurrentRoom().getLook() != null) {
                    frame.writeTextOnEditor(getCurrentRoom().getLook()+"\n");
                    out.println(getCurrentRoom().getLook());
                } else {
                    frame.writeTextOnEditor("Non c'è niente di interessante qui.\n");
                    out.println("Non c'è niente di interessante qui.");
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.RACCOGLI) {
                if (p.getObject() != null) {
                    if (p.getObject().isRaccogglibile()) {
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        out.println("Hai raccolto: " + p.getObject().getDescrizioneOggetto());
                        frame.writeTextOnEditor("Hai raccolto: " + p.getObject().getDescrizioneOggetto()+"\n");
                    } else {
                        out.println("Non puoi raccogliere questo oggetto.");
                        frame.writeTextOnEditor("Non puoi raccogliere questo oggetto.\n");
                    }
                } else {
                    out.println("Non c'è niente da raccogliere qui.");
                    frame.writeTextOnEditor("Non c'è niente da raccogliere qui.\n");
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.APRI) {
                /*ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                 * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                 * Potrebbe non esssere la soluzione ottimale.
                 */
                if (p.getObject() == null && p.getInvObject() == null) {
                    out.println("Non c'è niente da aprire qui.");
                    frame.writeTextOnEditor("Non c'è niente da aprire qui.\n");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isApribile() && p.getObject().isAperto() == false) {
                            if (p.getObject() instanceof AdvObjectContainer) {
                                out.println("Hai aperto: " + p.getObject().getNomeOggetto());
                                frame.writeTextOnEditor("Hai aperto: " + p.getObject().getNomeOggetto()+"\n");
                                AdvObjectContainer c = (AdvObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getNomeOggetto() + " contiene:");
                                    frame.writeTextOnEditor(c.getNomeOggetto() + " contiene:\n");
                                    Iterator<Oggetto> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Oggetto next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        out.print(" " + next.getNomeOggetto());
                                        frame.writeTextOnEditor(" " + next.getNomeOggetto()+"\n");
                                        it.remove();
                                    }
                                    out.println();
                                    frame.writeTextOnEditor("\n");
                                }
                                p.getObject().setAperto(true);
                            } else {
                                out.println("Hai aperto: " + p.getObject().getNomeOggetto());
                                frame.writeTextOnEditor("Hai aperto: " + p.getObject().getNomeOggetto()+"\n");
                                p.getObject().setAperto(true);
                            }
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                            frame.writeTextOnEditor("Non puoi aprire questo oggetto.\n");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isApribile() && p.getInvObject().isAperto() == false) {
                            if (p.getInvObject() instanceof AdvObjectContainer) {
                                AdvObjectContainer c = (AdvObjectContainer) p.getInvObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getNomeOggetto() + " contiene:");
                                    frame.writeTextOnEditor(c.getNomeOggetto() + " contiene:"+"\n");
                                    Iterator<Oggetto> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Oggetto next = it.next();
                                        getInventory().add(next);
                                        out.print(" " + next.getNomeOggetto());
                                        frame.writeTextOnEditor(" " + next.getNomeOggetto()+"\n");
                                        it.remove();
                                    }
                                    out.println();
                                    frame.writeTextOnEditor("\n");
                                }
                                p.getInvObject().setAperto(true);
                            } else {
                                p.getInvObject().setAperto(true);
                            }
                            out.println("Hai aperto nel tuo inventario: " + p.getInvObject().getNomeOggetto());
                            frame.writeTextOnEditor("Hai aperto nel tuo inventario: " + p.getInvObject().getNomeOggetto()+"\n");
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                            frame.writeTextOnEditor("Non puoi aprire questo oggetto.\n");
                        }
                    }
                }
            } else if (p.getCommand().getTipoComando() == TipoComando.PREMI) {
                //ricerca oggetti pushabili
                if (p.getObject() != null && p.getObject().isPremibile()) {
                    out.println("Hai premuto: " + p.getObject().getNomeOggetto());
                    frame.writeTextOnEditor("Hai premuto: " + p.getObject().getNomeOggetto()+"\n");
                    if (p.getObject().getIdOggetto() == 3) {
                        end(out);
                    }
                } else if (p.getInvObject() != null && p.getInvObject().isPremibile()) {
                    out.println("Hai premuto: " + p.getInvObject().getNomeOggetto());
                    frame.writeTextOnEditor("Hai premuto: " + p.getInvObject().getNomeOggetto()+"\n");
                    if (p.getInvObject().getIdOggetto() == 3) {
                        end(out);
                    }
                } else {
                    out.println("Non ci sono oggetti che puoi premere qui.");
                    frame.writeTextOnEditor("Non ci sono oggetti che puoi premere qui.\n");
                }
            }
            if (noroom) {
                out.println("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...");
                frame.writeTextOnEditor("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...\n");
            } else if (move) {
                out.println(getCurrentRoom().getNord());
                frame.writeTextOnEditor(getCurrentRoom().getNomeStanza()+"\n");
                out.println("================================================");
                frame.writeTextOnEditor("================================================\n");
                out.println(getCurrentRoom().getDescrizioneStanza());
                frame.writeTextOnEditor(getCurrentRoom().getDescrizioneStanza()+"\n");
            }
        }
    }



    private void end(PrintStream out) {
        out.println("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
        System.exit(0);
    }

}
