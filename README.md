## Indice

- [Caso di studio](#caso-di-studio)
- [Diagramma delle classi](#diagramma-delle-classi)
- [Specifica algebrica](#specifica-algebrica)
- [Argomenti inseriti nel caso di studio](#argomenti-inseriti-nel-caso-di-studio)
  - [Paradigma OO](#paradigma-OO)
    - [Incapsulamento](#incapsulamento)
    - [Ereditarietà](#ereditarieta)
    - [Polimorfismo](#polimorfismo)
  - [Collection](#collection)
  - [Eccezioni](#eccezioni)
  - [File](#file)
  - [JDBC](#jdbc)
  - [Thread](#thread)
  - [Socket](#socket)
  - [Lambda expressions & pipeline e stream](#lambda-expressions)
  - [Swing](#swing)

---

## Caso di studio<a name="caso-di-studio"></a>

---

## Diagramma delle classi
```mermaid
classDiagram
class FrameStart{
    - lblNomeUtente:JLabel
    - txtNomeUtente:JTextField
    - btnNuovaPartita:JButton
    - btnCaricaPartita:JButton
    - lblNomeInesistente:JLabel
    - btnRanking:JButton
    - jPanel:JPanel
    + FrameStart()
    - formWindowOpened():void
    - btnNuovaPartitaKeyPressed(KeyEvent):void
    - nuovaPartitaActionPerformed(ActionEvent):void
    - btnCaricaPartitaActionPerformed(ActionEvent):void
    - btnRankingActionPerformed(ActionEvent):void
    - formMouseEntered():void
    - jPanel1MouseEntered():void
    - formWindowClosing():void
    + avvia():void
}
class JFrameApp{
    - btnInvia:JButton
    - btnStatistiche:JButton
    - jPanel:JPanel
    - labelNumMosse:JLabel
    - lblComando:JLabel
    - lblNumMosse:JLabel
    - lblStanzaCorrente:JLabel
    - lblTempo:JLabel
    - panelStat:JPanel
    - scrollPanel:JScrollPanel
    - textArea:JTextArea
    - txtComando:JTextField
    - lblTimer:JLabel
    - engine:Engine
    - partitaCaricata:boolean
    - thread:ThreadTempo
    - username:String
    - background:JLabel
    - frameStart:FrameStart
    + JFrameApp(String,FrameStart)
    - formWindowOpened():void
    - formWindowClosing():void
    + scriviSuLabelStanza(String):void
    + getEngine():Engine
    - jPanel1PropertyChange(jPanel1PropertyChange):void
    + scriviSuLabelTempo(String):void
    + setEngine(GiocoNaufragioIsola):void
    - jButton1ActionPerformed(ActionEvent):void
    + scriviSuEditor(String):void
    - initComponents():void
    - textFieldActionPerformed(ActionEvent):void
    - textFieldKeyPressed(KeyEvent):void
    + finePartita():void
    + getTextArea():JTextArea
    - btnInviaActionPerformed(ActionEvent):void
    + main():void
}

class JDialogPorta{
    - btn1:JButton
    - btn2:JButton
    - btn3:JButton
    - btn4:JButton
    - btn5:JButton
    - btn6:JButton
    - btn7:JButton
    - btn8:JButton
    - btn9:JButton
    - btnCancella:JButton
    - btnConferma:JButton
    - txtCodice:JTextField
    - jpanel:JPanel
    - lblErrore:JLabel
    - GNI:GiocoNaufragioIsola
    - panelErrore:JPanel
    + JDialogPorta(Frame,boolean,GiocoNaufragioIsola)
    - btn1ActionPerformed(ActionEvent):void
    - btn2ActionPerformed(ActionEvent):void
    - btn3ActionPerformed(ActionEvent):void
    - btn4ActionPerformed(ActionEvent):void
    - btn5ActionPerformed(ActionEvent):void
    - btn6ActionPerformed(ActionEvent):void
    - btn7ActionPerformed(ActionEvent):void
    - btn8ActionPerformed(ActionEvent):void
    - btn9ActionPerformed(ActionEvent):void
    - txtCodiceKeyReleased(KeyEvent):void
    - txtCodiceKeyPressed(KeyEvent):void
    - initComponents():void
    - btnCancellaActionPerformed(ActionEvent):void
    - btnConfermaActionPerformed(ActionEvent):void
    - formWindowOpened(WindowEvent):void
    + avvia():void
}

class JDialogStats{
   - btnPartitaSpecifica: JButton
   - btnPartiteTerminate: JButton
   - lblPunteggioMedio: JLabel
   - jPanel: JPanel
   - btnPartite: JButton
   - btnPartiteUtente: JButton
   - lblErrore: JLabel
   - lblNomePartita: JLabel
   - lblPunteggio: JLabel
   - lblSaluto: JLabel
   - scrollPanel: JScrollPane
   - txtNomePartita: JTextField
   - txtPunteggio: JTextField
   - txtPunteggioMedio: JTextPane
   - username:String
   - df:DecimalFormat
   - RIGHE_TABELLA_PARTITE:Int
   - COLONNE_TABELLA_PARTITE:int
   + JDialogStats(Frame, boolean, String) 
   - initComponents(): void              
   - formWindowOpened(WindowEvent): void  
   - btnPartiteActionPerformed(ActionEvent): void 
   - btnPartiteUtenteActionPerformed(ActionEvent): void 
   - btnPartitaSpecificaActionPerformed(ActionEvent): void 
   - txtNomePartitaKeyPressed(KeyEvent): void 
   - btnPartiteTerminateActionPerformed(ActionEvent): void 
   + visualizzaPartiteTerminate(List<Partita>, Predicate<Partita>): void 
   + avvia(): void
}

class JDialogCaricaPartite{
- model: ComboBoxModel[]
- frameStart: FrameStart
- jPanel1: JPanel
- btnConferma: JButton
- jComboBoxPartite: JComboBox<String>
- lblMessaggioCarica: JLabel
- lblPartitaNonSelezionata: JLabel
+ JDialogCaricaPartite(JFrame, boolean, FrameStart)
- initComponents(): void
- btnConfermaActionPerformed(ActionEvent): void
- formWindowOpened(WindowEvent): void
- jComboBoxPartiteKeyPressed(KeyEvent): void
+ avvia(): void
}

class JDialogClassificaUtenti{
- lblMessaggioRanking: JLabel
- jScrollPane: JScrollPane
- jPanel: JPanel
- lblTitolo: JLabel
+ JDialogClassificaUtenti(Frame, boolean)
- initComponents(): void
- formWindowOpened(): void
- formWindowClosed(): void
+ avvio(): void
}

class JDialogPunteggio{
- jPanel: JPanel
- lblPunteggio: JLabel
- txtPunteggio: JTextField
- lblCongratulazioni: JLabel
- gni: GiocoNaufragioIsola
+ JDialogPunteggio(Frame, boolean, GiocoNaufragioIsola)
- initComponents(): void
- formWindowOpened(): void
+ avvio(): void
}

class JDialogAbbandona{
- jPanel: JPanel
- lblMessaggioSalva: JLabel
- btnSi: JButton
- btnNo: JButton
- txtNomePartita: JTextField
- lblNomePartita: JLabel
- lblErroreNome: JLabel
- engine: Engine
+ JDialogAbbandona(Frame, boolean, Engine)
- initComponents(): void
- btnSiActionPerformed(ActionEvent): void
- txtNomePartitaActionPerformed(ActionEvent): void
- btnNoActionPerformed(ActionEvent): void
- formWindowOpened(WindowEvent): void
- txtNomePartitaKeyPressed(KeyEvent): void
+ main(String[]):void
}

class JDialogRadio{
- jPanel: JPanel
- jScrollPane: JScrollPane
- jTextArea: JTextArea
- jPanelOpzioni: JPanel
- jRadioButton1: JRadioButton
- jRadioButton2: JRadioButton
- btnConferma: JButton
- lblTitolo: JLabel
- btnSpegniRadio: JButton
- numDomanda: int
- nomeUtente: String
- threadS: Thread
- threadC: Thread
+ JDialogRadio(Frame, boolean, String)
- initComponents(): void
- formWindowOpened(): void
- btnConfermaActionPerformed(ActionEvent): void
- jRadioButton1KeyReleased(): void
- jRadioButton2KeyReleased(): void
- jRadioButton1ActionPerformed(ActionEvent): void
- jButton2ActionPerformed(ActionEvent): void
- jRadioButton1KeyPressed(KeyEvent): void
- jRadioButton2KeyPressed(KeyEvent): void
- formWindowClosed(): void
+ avviaServer(): void throws IOException
+ avviaClient(): void
+ getTextArea(): JTextArea
+ setNuoveDomande(): void
+ avvia(): void
}
class Oggetto{
    - idOggetto:int 
    - nomeOggetto:String 
    - descrizioneOggetto:String 
    - descrizioneRaccogli:String 
    - aliasOggetto:Set <String> 
    - comandiConsentiti:Set <Comando> 
    - apribile:boolean 
    - raccogglibile:boolean 
    - premibile:boolean 
    - aperto:boolean 
    - premuto:boolean 
    - visibile:boolean 
    - lasciato:boolean 
    + Oggetto(int)
    + Oggetto(int,String)
    + Oggetto(int,String,String)
    + Oggetto(int,String,String,Set<String>)
    + getNomeOggetto():String 
    + setNome(String):void 
    + getDescrizioneOggetto():String 
    + setDescrizioneOggetto(String):void 
    + isApribile():boolean 
    + setApribile(boolean):void 
    + isRaccogglibile():boolean 
    + setRaccogglibile(boolean):void 
    + isPremibile():boolean 
    + setPremibile(boolean):void 
    + isAperto():boolean 
    + setAperto(boolean):void 
    + isPremuto():boolean 
    + setPremuto(boolean):void 
    + getAliasOggetto():Set<String> 
    + setAlias(Set<String>):void 
    + setAlias(String[]):void 
    + getIdOggetto():int 
    + isVisibile():boolean 
    + setVisibile(boolean):void 
    + isLasciato():boolean 
    + setLasciato(boolean):void 
    + setDescrizioneRaccogli(String):void 
    + getDescrizioneRaccogli():String 
    + getComandiConsentiti():Set<Comando> 
    + setComandiConsentiti(Set<Comando>):void 
}

class GameDescription{
    - nomePartita:String 
    - username:String 
    - finita:boolean 
    - numOre:int 
    - numMinuti:int 
    - numSecondi:int 
    - numMosse:int 
    - punteggio:int 
    - abbandonata:boolean 
    - stanze:List<Stanza> 
    - comandi:List<Comando> 
    - inventario:List<Oggetto>
    - oggettiGioco:List<Oggetto> 
    - stanzaCorrente:Stanza 
    + GameDescription ()
    + calcoloPunteggio(int, int, boolean):int 
    + setAbbandonata(boolean b):void 
    + getPunteggio():int 
    + getNomePartita():String 
    + setNomePartita(String):void 
    + getNumMosse():int 
    + setNumMosse(int):void 
    + getNumMinuti():int 
    + setNumMinuti(minCorr):void 
    + getNumSecondi():int 
    + setNumSecondi(int):void 
    + getNumOre():int 
    + setNumOre(oreCorr): void 
    + setUsername(String):void 
    + getUsername():String 
    + getStanze():List<Stanza>
    + getComandi():List<Comando> 
    + getStanzaCorrente():Stanza 
    + setStanzaCorrente(Stanza):void 
    + getInventario():List<Oggetto> 
    + getOggettiGioco():List<Oggetto> 
    + getOggettoGioco(String):Oggetto 
    + getStanza(String):Stanza 
    + getComando(String):Comando 
    + setFinita(boolean):void 
    + getFinita():boolean 

}

class Stanza{
    - idStanza:int 
    - nomeStanza:String 
    - descrizioneLungaStanza:String 
    - descrizioneCortaStanza:String 
    - osserva:String 
    - raggiungibile:boolean 
    - visibile:boolean 
    - visitata:boolean 
    - sud:Stanza 
    - nord:Stanza 
    - est:Stanza 
    - ovest:Stanza 
    - messaggioNord:String 
    - messaggioSud:String 
    - messaggioEst:String 
    - messaggioOvest:String 
    - objects:List<Oggetto> 
    - Stanza (int)
    - Stanza (int,String)
    + getNomeStanza(): String
    + setNome(String):void 
    + getDescrizioneLungaStanza():String 
    + getDescrizioneCortaStanza(): String 
    + setDescription(String):void 
    + getRaggiungibile():boolean 
    + setRaggiungibile(boolean):void 
    + getSud():Stanza 
    + setSud(Stanza):void 
    + getNord():Stanza 
    + setNord(Stanza):void 
    + getEst():Stanza 
    + setEst(Stanza):void 
    + getOvest():Stanza 
    + setOvest(Stanza):void 
    + setDescrizioneCortaStanza(String):void 
    + setDescrizioneCompletaStanza(String):void 
    + getMessaggioNord():String 
    + getMessaggioSud():String 
    + getMessaggioEst():String 
    + getMessaggioOvest():String 
    + setMessaggioNord(String):void 
    + setMessaggioSud(String):void 
    + setMessaggioEst(String):void 
    + setMessaggioOvest(String):void 
    + getVisitata():boolean 
    + setVisitata(boolean):void 
    + getObjects():List<Oggetto> 
}

class Database{
    + Database()
    + connect(): Connection 
    + creaTabellaPartita():boolean 
    + salvaPartita(GameDescription):boolean 
    + getPunteggio(int):int 
    + getPunteggio(String):int 
    + stampaPartite():void 
}

class DatabaseController{
    - Connection
    + DatabaseController()
    + chiudiConnessione():void 
    + creaTabellaPartita():boolean 
    + salvaPartita(GameDescription):boolean 
    + getPunteggio(int):int 
    + getPunteggio(String):int 
    + stampaPartite():void 
    + getPartite():ResultSet 
    + getPartiteUtente(String):ResultSet 
    + getPunteggioMedio():double 
    + getPunteggioMedioUtente(String):double 
    + getPunteggioTerminate():double 
    + boolean partitaEsistente(String):
    + ottieniListaPartite():List<Partita> 
}

class ControlGioco{
    - comandi:Set<Comando> 
    - comandiArray:Comando[] 
    - ControlGioco()
    - comandoNord(GiocoNaufragioIsola,JFrameApp,JPanel,JLabel):void 
    - comandoSud(GiocoNaufragioIsola,JFrameApp,JPanel,JLabel):void
    - comandoEst(GiocoNaufragioIsola,JFrameApp,JPanel,JLabel):void 
    - comandoOvest(GiocoNaufragioIsola,JFrameApp,JPanel,JLabel):void 
    - comandoInventario(GiocoNaufragioIsola,JFrameApp):void 
    - comandoRaccogli(GiocoNaufragioIsola,JFrameApp,Oggetto,Oggetto):void 
    - comandoOsserva(GiocoNaufragioIsola,JFrameApp,Oggetto,Oggetto):void 
    - comandoLascia(GiocoNaufragioIsola,JFrameApp,Oggetto):void 
    - comandoAccendi(GiocoNaufragioIsola,JFrameApp,Oggetto):void 
    - comandoLeggi(JFrameApp,Oggetto,Oggetto):void 
    - comandoTaglia(GiocoNaufragioIsola,JFrameApp,Oggetto):void 
    - comandoCostruisci(GiocoNaufragioIsola,JFrameApp,Oggetto):void 
    - comandoAiuto(GiocoNaufragioIsola,JFrameApp):void 
    - setComandi(GiocoNaufragioIsola):void 
    - comandoApri(GiocoNaufragioIsola,JFrameApp,Oggetto):void 
    - comandoSposta(GiocoNaufragioIsola,JFrameApp,Oggetto):void 
    - comandoLocalizzazione(GiocoNaufragioIsola,JFrameApp):void 
    - comandoRipara(GiocoNaufragioIsola,JFrameApp,Oggetto):void 
    - comandoFine(GiocoNaufragioIsola,JFrameApp):void 
    - comandoNonRiconosciuto(JFrameApp):void 
    - inizializzaOrdineComandi(GiocoNaufragioIsola):void 
}

class OggettoContenitore{
    - list:List<Oggetto> 
    + OggettoContenitore(int)
    + OggettoContenitore(int,String)
    + OggettoContenitore(int,String,String)
    + OggettoContenitore(int,String,String,Set<String>)
    + getList():List<Oggetto> 
    + setList(List<Oggetto>):void 
    + add(Oggetto):void 
    + remove(Oggetto):void 
}

class GiocoNaufragioIsola{
    + GiocoNaufragioIsola()
    + init():void 
    + nextMove(ParserOutput,PrintStream,JPanel,JLabel):void 
}

class FileInterface{
    + create():boolean 
}

class FileController{
    - nomeFile:String 
    - percorso:String 
    - file:File 
    + FileController(String,String)
    + create():boolean 
    + setFile():void 
    + getFile():File 
    + getPercorso():String 
    + getNomeFile():String 
    + setNomeFile(String):void 

    
}

class FileMatchController{
    + FileMatchController(String,String)
    + getMatch(String):GiocoNaufragioIsola 
    + addMatch(GiocoNaufragioIsola):boolean 
    + getMatch():List<GiocoNaufragioIsola> 
}

class Comando{
    - tipoComando:TipoComando 
    - nomeComando:String 
    - aliasComando:Set<String> 
    - descrizione:String 
    - Comando(TipoComando,String)
    - Comando(TipoComando,String,Set<String>)
    + getNomeComando():String 
    + getAliasComando():Set<String> 

}
class ParserOutput{
    + object:Oggetto
    + genericObject:Oggetto
    + invObject:Oggetto
    + command:Comando
    + ParserOutput(Comando,Oggetto)
    + ParserOutput(Comando,Oggetto,Oggetto)
    + ParserOutput(Comando,Oggetto,Oggetto)
    + getCommand():Comando
    + getObject():Oggetto
    + getInvObject():Oggetto
    + getGenericObject():Oggetto
}

class Client{
    - indirizzoServer:String
    - porta:int
    - socket:socket
    - writer:PrintWriter
    - reader:BufferReader
    - textArea:JTextarea
    + Client(String,int)
    + run():void
    + inviaMessaggio(String):void
    + leggiRispostaServer():void
    + scriviRispostaTextArea(String):void
    - correggiStringa(String):String
    - troncaStringa(String,String):String
    - ottieniStringaDopo(String, String):String
    + setTextArea(JTextarea):void
}

class Server{
    - PORTA_SERVER:int
    - serveSocket:ServeSocket
    - writer:PrintWriter
    - clientSocket:Socket
    - attivo:boolean
    + run():void
    + elaboraMessaggio():void
    + leggiMessaggioClient():String
    + inviaRispostaClient(String):void
    + stop():void
}

class Inventario{
    - listaOggetti:List<Oggetto>
    + getList():List<Oggetto>
    + setList(List<Oggetto>):void
    + aggiungi(Oggetto):void
    + rimuovi(Oggetto):void
}
class Parser{
    + Parser(Set<String>)
    + parse(String,List<Comando>,List<Oggetto,List<Oggetto,List<Oggetto):ParserOutput
    - cercaComando(String,List<Comando>):int
    - cercaOggetto(String,List<Oggetto>):int
}

class ThreadTempo{
    + ThreadTempo(JFrameApp,int,int,int)
    + stampaTempo(String):void
    + run():void
}

class Classifica{
    + Classifica(List<Partita>)
    + ottieniClassificaUtenti():List<Entry<String,Integer>>
}

class Engine{
    - game:GameDescription
    - parser:Parser
    + Engine(GameDescription,boolean)
    + getCurrentRoomName():String
    + getGame():GameDescription
    + getParser():Parser
    + main(String[]):void
}

FileController <|-- FileMatchController
Database <|-- DatabaseController
GameDescription <|-- GiocoNaufragioIsola
Oggetto <|-- OggettoContenitore
FileInterface <|.. FileController


GameDescription *-- Oggetto
Stanza *-- Oggetto
OggettoContenitore *-- Oggetto
Inventario *-- Oggetto
ParserOutput *-- Oggetto
Oggetto *-- Comando


GameDescription *-- Comando
GameDescription *-- Stanza
Engine *-- GameDescription


DatabaseController <.. JDialogStats : create
DatabaseController <.. JDialogClassificaUtenti : create
DatabaseController <.. Engine : create
DatabaseController <.. JDialogAbbandona : create

JDialogRadio <.. ControlGioco : create
Comando <.. ControlGioco : create
ControlGioco *-- Comando

GiocoNaufragioIsola <.. JFrameApp : create
JDialogPorta *-- GiocoNaufragioIsola
JDialogPunteggio *-- GiocoNaufragioIsola


FileController <.. Engine : create

FileMatchController <.. JDialogCaricaPartite : create
FileMatchController <.. JDialogAbbandona : create

ParserOutput *-- Comando

Parser <.. ParserOutput : create

Client <.. JDialogRadio : create
Server <.. JDialogRadio : create

Parser <.. Engine : create
Engine *-- Parser

ThreadTempo <.. JFrameApp : create
JFrameApp *-- ThreadTempo

Classifica <.. JDialogClassificaUtenti : create

Engine <.. JFrameApp : create
JFrameApp *-- Engine
JDialogAbbandona *-- Engine

FrameStart .. JDialogClassificaUtenti : create
FrameStart .. JDialogCaricaPartite : create
JDialogCaricaPartite *--  FrameStart: frameStart
JFrameApp *-- FrameStart : frameStart
FrameStart .. JFrameApp : create
JDialogStats <.. JFrameApp : create
JDialogAbbandona <.. JFrameApp : create
JFrameApp <.. JDialogCaricaPartite : create
```
## Specifica algebrica

---

## Argomenti inseriti nel caso di studio<a name="argomenti-inseriti-nel-caso-di-studio"></a>

### Paradigma OO<a name="paradigma-OO"></a>
Nel seguente caso di studio è stato fatto uso del paradigma OO(Object Oriented).
In questo paradigma si orgnanizza il codice intorno agli oggetti, i quali rappresentano entità del mondo reale o concetti astratti.
Ci sono tre principi fondamentali della programmazione orientata agli oggetti: Incapsulamento, Ereditarietà e Polimorfismo.
#### Incapsulamento<a name="incapsulamento"></a>
Information hiding e incapsulamento sono concetti cardine del paradigma orientato a oggetti.
Gli oggetti all'interno del programma incapsulano uno stato e un comportamento. Lo stato è identificato dal contenuto di una certa area di memoria. Il comportamento è definito come una collezione di procedure e funzioni (metodi) che possono operare sulla rappresentazione dell’area di memoria associata all’oggetto.
L'utilizzo dell'occultamento dell'informazione e l'incapsulamento rendono possibile l'uso di oggetti ricorrendo solo a metodi pubblici. Gli attributi delle classi sono quasi sempre privati, perciò non accessibili direttamente da altre classi o oggetti, essi forniscono un controllo più stretto sull'accesso e la modifica dei dati di una classe.

#### Ereditarietà<a name="ereditarieta"></a>
E' stato fatto utilizzo dell'ereditarietà, nonchè una relazione fondamentale tra le classi. Una classe è considerata come un repertorio di conoscenze a partire dal quale è possibile definire altre classi più specifiche, che completano le conoscenze della loro classe madre.
Un esempio di ereditarietà presente all'interno del caso di studio è la relazione tra la classe astratta `Database` e la classe `DatabaseController`, dove `DatabaseController` è una sottoclasse di `Database`, perciò eredita tutti i metodi e attributi public/protected. 
La sottoclasse `DatabaseController` introduce delle caratteristiche non presenti nella superclasse, quindi in questo caso è stata utilizzata l'ereditarietà per estensione.
Allo stesso tempo però la sottoclasse DatabaseController effettua l'overriding dei metodi ereditati dalla superclasse `Database`, fornendo un implementazione dei metodi astratti. Perciò in questo caso è stata utilizzata l'ereditarietà per variazione funzionale poichè si ridefiniscono alcune caratteristiche della superclasse.
Ovviamente questo non è l'unico utilizzo di ereditarietà all'interno del caso di studio.

#### Polimorfismo<a name="polimorfismo"></a>
E' stato fatto utilizzo del polimorfismo. Con questo termine si intende la possibilità di associare a una operazione diverse realizzazioni. 
Per esempio si è fatto uso del polimorfismo ad hoc, ottenuto quando un metodo lavora su tipi differenti e potrebbe comportarsi in maniera totalmente differente per ciascuno di essi. Un esempio di utilizzo lampante di polimorfismo per overloading (che rientra nel polimorfismo ad hoc) nel caso di studio è osservabile nell'implementazione del metodo `getPunteggio()` della classe `DatabaseController` dove il metodo restituisce il punteggio di una partita sia passando il nome della partita (parametro di tipo String), sia passando l'id della partita (parametro di tipo int). La classe `DatabaseController` ha due diverse implementazioni del metodo `getPunteggio()` in base al tipo del parametro ricevuto.
Inoltre, si è fatto utilizzo del polimorfismo universale, la cui idea è quella di operare su un numero infinito di tipi. Infatti nel caso di studio è stata creata una classe generica `StampaListe` che opera su un tipo generico `<T>`, permette di stampare attraverso il metodo `stampa()` la lista ricevuta in input dal costruttore indipendentemente dal tipo degli elementi della lista.

---
### Collection<a name="collection"></a>
All'interno del caso di studio sono state utilizzate le seguenti collection:
#### List
Le liste vengono utilizzate all'interno del caso di studio nelle seguenti situazioni:
* La classe `Classifica` ha come attributo una lista di elmenti di tipo `Partita`, la lista di partite viene utilizzata dal metodo 'ottieniClassificaUtenti()' per filtrare le partite degli utenti e costruire il ranking degli utenti che hanno vinto almeno una partita con il punteggio massimo.
* Il metodo `ottieniClassificaUtenti()` restitutuisce una lista di elementi di tipo `Map.Entry<String,Integer>`, nonchè una lista di coppie <chiave,valore> dove la chiave è il nome dell'utente e il valore il punteggio massimo associato a quell'utente.
* La classe `DatabaseController` ha un metodo `ottieniListaPartite()` che salva tutte le partite salvate su DB all'interno di una lista, per poi successivamente restituirla.
* La classe GameDescription ha come attributi:
  - una lista di elementi di tipo `Stanza`;
  - una lista di elementi di tipo `Comando`;
  - una lista di elementi di tipo `Oggetto` per l'inventario;
  - una lista di elementi di tipo `Oggetto` per gli oggetti del gioco.
* La classe `Inventario` ha come attributo una lista di elementi di tipo `Oggetto` utilizzata dai metodi della classe per aggiungere e rimuovere elementi nell'inventario
* La classe `Stanza` ha come attributo una lista di elementi di tipo `Oggetto`
* La classe `OggettoContenitore` ha come attributo una lista di elementi di tipo `Oggetto` contenente gli oggetti contenuti dal contenitore;
* Il  `parseString()` della classe `Utils` utilizza una lista di token, nonchè una lista di elementi di tipo `String`;
* la classe generica `StampaListe` utilizza come attributo una lista di elementi di tipo generico;
* Il metodo `getMacth()` della classe `FileMatchController` restituisce una lista di elementi di tipo `GiocoNaufragioIsola`, nonchè una lista di partite salvate su file.
#### Set
* `Set stopwords` utilizzato per contenere tutte le stopwords recuperate dal file senza contenere duplicati;
* La classe `ControlGioco` utilizza un `set comandi`, nonchè un set di elementi di tipo `Comando`;
* La classe `Oggetto` utilizza un set `aliasOggetto` per contenere tutti i possibili alias del nome di un oggetto e un `set comandiConsentiti` per contenere tutti i comandi consentiti su un determinato oggetto;
* La classe `Comando` utilizza un set `aliasComando` per contenere tutti gli alias del nome di un comando.
#### Map
* Il metodo `ottieniClassificaUtenti()` della classe `Classifica` salva in una `Map` con chiave di tipo `String` e valore di tipo `Integer` tutti gli utenti che hanno vinto almeno una partita con il loro corrispettivo punteggio massimo, la chiave è il nome dell'utente, il valore il punteggio massimo;
* Lista di elementi di tipo `Map.Entry<String,Integer>` per contenere le coppie chiave-valore (nome utente-punteggio massimo) per la stampa del ranking.

---
### Eccezioni<a name="eccezioni"></a>
Sono state utilizzate molto frequentemente le eccezioni. Molti metodi nel programma possono generare eccezioni, ognuna di esse è catturata e gestita utilizzando l'appropriata tipologia di eccezione. 
A seguire sono riporati diversi esempi.

![Eccezione1](/imgDocumentazione/eccezione1.png)

Il metodo mostrato in figura è quello per caricare un immagine su un `JFrame` e visualizzarla come background. Soffermandoci sul blocco `try-catch` viene catturata un eccezione di tipo `IOException`. Questa eccezione viene sollevata quando si verificano errori di input/output durante la lettura o la scrittura di dati. Nel contesto del codice fornito, l'eccezione viene catturata se si verificano errori durante la lettura dell'immagine dal file specificato.

![Eccezione2](/imgDocumentazione/eccezione2.png)

Il blocco 'try-catch' mostrato qui invece è stato estrapolato dal metodo `riproduciTraccia()` della classe `Suono`. In questo caso vengono catturate tre tipologie di eccezioni:
* `IOException`: Questa eccezione viene sollevata quando si verificano errori di input/output durante la lettura o la scrittura di dati. Nel contesto del codice fornito, l'eccezione viene catturata quando si verificano errori di lettura del file audio o chiusura dell' `AudioInputStream`;
* `LineUnavailableException`: Questa eccezione viene sollevata quando una linea audio richiesta non è disponibile o non può essere aperta. Nel contesto del codice fornito, l'eccezione viene catturata se non è possibile aprire la linea di riproduzione audio
* `UnsupportedAudioFileException`: Questa eccezione viene sollevata quando viene tentato di leggere un tipo di file audio non supportato. Nel contesto del codice fornito, l'eccezione viene catturata se il formato audio del file non è supportato.

![Eccezione3](/imgDocumentazione/eccezione3.png)

Il metodo mostrato in figura è quello per ottenere il punteggio della partita con uno specifico identificatore. Nel blocco `try-catch` viene catturata una eccezzione di tipo `SQLException`. Questa eccezione viene sollevata quando si verificano errori durante l'interazione con un database tramite `JDBC` (`Java Database Connectivity`). 

---
### File<a name="file"></a>
Il programma implementa la possibilità di salvare una partita ogni qual volta viene catturato l'evento della chiusura della finestra di gioco. Il salvataggio delle partite avviene su un file denominato: 'salvataggioPartita'.
Per la gestione dei file sono state usate le classi `FileController`, `FileMatchController` e l'interfaccia `FileInterface`.

- La classe `FileController` implementa l'interfaccia `FileInterface`, la quale contiene il solo metodo `create()`. 
La classe `FileController` si occupa di creare un nuovo file (se non è già esistente) e ha i seguenti attributi protected: nomeFile, directory, file e percorso. 
directory rappresenta la cartella in cui verrà memorizzato il file all'interno del progetto, nomeFile come intuibile dal nome è il nome del file che verrà creato.
Il percorso del file viene costruito dinamicamente da un metodo della classe `Utils` che riceve in input gli attributi nomeFile e directory.

- La classe `FileMatchController` estende la classe `FileController` ereditanto gli attributi/metodi public/protected e aggiungendo nuove funzionalità (metodi), nonchè l'aggiunta di una nuova partita all'interno del file, il recupero di una specifica partita salvata su file utilizzando il nome della partita (utile per il caricamento di una partita salvata), il recupero di tutte le partite salvate su file (utile per la costruzione dinamica della `JComboBox` dalla quale l'utente può scegliere quale partita continuare/caricare).

---
### JDBC<a name="jdbc"></a>
Il salvataggio di una partita non avviene solamente su file, bensì avviene anche su database. E' stato utilizzato il database `Engine H2` poichè può essere utilizzato in modo embedded senza necessità di installare un server.

Per la gestione dei DB utilizziamo una classe astratta `Database` che memorizza le query utili alle funzionalità del programma nei relativi attributi protected (attributi che vengono ereditati dalle sottoclassi di Database). L'unico metodo implementato dalla classe astratta `Database` è quello relativo alla connessione al DB, tutti i restanti metodi sono astratti. 

La classe `DatabaseController` estende la classe astratta `Database` e utilizzando gli attributi ereditati contenenti le stringhe delle query implementa i metodi astratti della superclasse e aggiunge nuovi metodi.
Si occupa delle seguenti funzionalità:
* chiudere la connessione al DB;
* creare la tabella della partita (solamente se non è già esistente);
* salvare una nuova partita nel DB;
* recuperare dal DB il punteggio di una specifica partita utilizzando l'id della partita;
* recuperare dal DB il punteggio di una specifica partita utilizzando il nome della partita;
* stampare tutte le partite salvate su DB;
* recuperare tutte le partite salvate su DB;
* recuperare tutte le partite salvate su DB di uno specifico utente;
* recuperare il punteggio medio di tutte le partite su DB;
* recuperare il punteggio medio di tutte le partite di uno specifico utente su DB;
* recuperare il punteggio medio delle partite terminate;
* verificare l'esistenza di una partita nel DB utilizzando il nome della partita;
* restituire tutte le partite salvate su DB come lista di elementi di tipo Partita.

Le seguenti funzionalità sono state utilizzate per permettere all'utente di visualizzare statistiche in forma tabellare. E' possibile visualizzare sia statistiche generali che statistiche specifiche all'utente in gioco.

---
### Thread<a name="thread"></a>
L'utilizzo dei thread all'interno del progetto è fondamentale per la visualizzazione del timer in tempo reale, il quale viene visualizzato nel frame principale dell'app durante la partita.

Per la creazione di un thread in grado di gestire e visualizzare il timer della partita abbiamo creato una classe `ThreadTempo` (che tiene traccia delle ore, minuti e secondi passati durante la partita), la quale implementa l'interfaccia `Runnable`. Ogni volta che viene avviata una nuova partita viene avviato il thread per il tempo, il quale incrementa il numero di secondi, minuti e ore in tempo reale, aggiorna costantemente gli attributi relativi al tempo della classe `GameDescription` per tenere traccia del tempo passato all'interno della partita. 

Quando la partita termina oppure quando l'utente vince la partita il thread per il tempo viene interrotto attraverso la chiamata del metodo `interrupt()`, perciò il tempo della partita si ferma e non verrà più aggiornato.

L'app permette anche il caricamento di una partita salvata, la classe `ThreadTempo` gestisce anche questo caso, riprendendo il timer dal tempo di partita del suo salvataggio e continuando normalmente l'esecuzione del timer. Ogni secondo il thread aggiorna il frame dinamicamente stampando nell'interfaccia utente il numero di ore, minuti e secondi trascorsi durante la partita.

Altrettanto fondamentale è l'utilizzo dei thread per la musica e i suoni presenti all'interno del gioco. La classe `Suono` tra gli attributi ha un oggetto della classe `Thread` che viene avviato ogni qual volta viene chiamato il metodo `riproduciTraccia()`. Ogni stanza della mappa del gioco ha una musica di sottofondo differente e ad ogni spostamento nella mappa viene chiamato il metodo `riproduciTraccia()` che avvia il thread che si occupa di eseguire il corretto suono di sottofondo per la stanza corrente. Sono previste musiche differenti anche in altre situazioni come per esempio i suoni di digitazione del codice per l'accesso all'edificio abbandonato. Oppure la musica in caso di vittoria.  Oppure ancora nel dialogo via radio tra l'utente e i militari.

I suoni delle diverse stanze non si vanno mai a sovrapporre poichè ogni volta che ci si sposta nella mappa viene ucciso il thread per la musica della stanza precedente e viene avviato un nuovo thread per la musica della stanza corrente. Quando l'utente abbandona la partita viene interrotto il thread della classe `Suono`.

Inoltre, i thread vengono utilizzati per la comunicazione `Client-Server` con i socket. Approfondiamo il loro utilizzo nel prossimo paragrafo relativo ai Socket.

---
### Socket<a name="socket"></a>
Quando l'utente accende la radio, l'applicazione apre una finestra per il dialogo via radio tra il giocatore disorientato nell'isola e i militari.
Per la comunicazione tra l'utente e i militari abbiamo utilizzato una comunicazione `Client-Server` utilizzando i Socket.

Al momento della generazione della finestra per il dialogo vengono avviati sia il client che il server

![avvioClientServer](/imgDocumentazione/client_server_avvio.png)

Come possiamo notare sia la classe `Client` che la classe `Server` implementano l'interfaccia `Runnable` poichè i due oggetti vengono passati al costruttore `Thread` per avviare due thread che si occupano di eseguire rispettivamente le funzionalità del server e del client.
All'avvio dei due thread, il server rimane in attesa di una connessione su una porta, nel frattempo il client si connette al server pronto per lo scambio dei messaggi.

#### Client:
![Client](/imgDocumentazione/Client.png)

Il client rappresenta l'utente nella conversazione via radio.
Il metodo `leggiRispostaServer()` legge il messaggio inviato dal server e lo scrive nella `TextArea` dell'interfaccia per rendere visibile al client (l'utente) la risposta del server. 


#### Server:
![Server](/imgDocumentazione/Server.png)

Il server rappresenta i militari nella conversazione via radio. 
Il metodo `elaboraMessaggio()` legge il messaggio inviato dal client e in base al messaggio ricevuto restituisce la risposta idonea al proseguio della conversazione.

Il dialogo via radio offre all'utente un importante indizio per la risoluzione del gioco.



#### Comunicazione client-server:
<img src="/imgDocumentazione/radio.png" alt="radio" width="800" height="520">


Ogni volta che il client conferma un opzione invia un messaggio al server. Il server legge la risposta del client, elabora il messaggio e restituisce una risposta al client. La risposta del server viene visualizzata in tempo reale nell'interfaccia utente dando vita a un vero e proprio dialogo dinamico tra i due attori dove la risposta del server dipende dal messaggio inviato del client.
La risposta del server non è solo testuale, infatti restituisce anche una risposta audio dei militari con interferenze radio per rendere il gioco il più realistico possibile.


Il messaggio inviato dal client è l'opzione selezionata.
Nel momento in cui l'utente seleziona la risposta viene invocato il metodo statico `inviaMessaggio()` della classe `Client`, e vengono settate le nuove opzioni nell'interfaccia per permettere all'utente (client) di inviare nuovi messaggi ai militari (server).

Quando l'utente spegne la radio oppure chiude la finestra vengono chiusi il `server socket` e il `client socket` per liberare le risorse, ma soprattutto vengono interrotti i due thread che eseguivano il `Client` e il `Server`.

---
### Lambda expressions & pipeline e stream<a name="lambda-expressions"></a>
Abbiamo creato due interfacce funzionali: `SalvaPartita` e `EsistenzaPartita`.
Queste ultime sono delle interfacce funzionali che hanno un solo metodo astratto.

#### Interfaccia funzionale SalvaPartita
![SalvaPartita](/imgDocumentazione/salvaPartita.png)

Il metodo esegui dell'interfaccia funzionale `SalvaPartita()` prende in input un oggetto `GameDescription` e restituisce un `boolean`. Il metodo non ha un implementazione perciò è necessario fornirgliela per poter chiamare il metodo. 


![Lambda1](/imgDocumentazione/espressioneLambda1.png)

Creiamo un'istanza dell'interfaccia funzionale `SalvaPartita` utilizzando un'espressione lambda. L'espressione lambda definisce l'implementazione del metodo astratto dell'interfaccia funzionale `SalvaPartita`.
Adesso che il metodo astratto ha un'implementazione utilizziamo l'istanza dell'interfaccia funzionale per chiamare il metodo `esegui()`, che come definito dall'espressione lambda `p -> db.salvaPartita(p)` prende in input una partita e la passa al metoto `salvaPartita()` della classe `DatabaseController` che salva la partita su DB.

#### Interfaccia funzionale EsistenzaPartita
![EsistenzaPartita](/imgDocumentazione/esistenzaPartita.png)

L'interfaccia funzionale `EsistenzaPartita` ha un metodo astratto 'test' che prende in input una stringa (il nome della partita) e restituisce un `boolean`. Essendo un metodo astratto di una interfaccia funzionale esso non ha una implementazione.


![Lambda2](/imgDocumentazione/espressioneLambda2.png)

Creiamo un'istanza dell'interfaccia funzionale `EsistenzaPartita` utilizzando un'espressione lambda. L'espressione lambda definisce l'implementazione del metodo astratto dell'interfaccia funzionale `EsistenzaPartita`.
Adesso che il metodo astratto ha un'implementazione utilizziamo l'istanza dell'interfaccia funzionale per chiamare il metodo `test()`, che come definito dall'espressione lambda 

`(nome) -> db.partitaEsistente(nome)`, passa il nome della partita al metodo partitaEsistente della classe DatabaseController che verifica l'esistenza della partita nel DB, se la trova restituisce true, altrimenti false.


#### Visualizzazione partite terminate con espressione lambda:
![partiteTerm2](/imgDocumentazione/partiteTerminate2.png)
Quando l'utente clicca il bottone per visualizzare tutte le partite terminate parte il metodo `btnPartiteTerminateActionPerformed()` che salva in 'partite' la lista di tutte le partite, e chiama il metodo `visualizzaPartiteTerminate()`.

Il metodo `visualizzaPartiteTerminate` si aspetta come parametri una lista di elementi di tipo `Partita` e un'istanza dell'interfaccia funzionale 
```Predicate<Partita>;```. L'interfaccia funzionale ```Predicate<T>``` ha un solo metodo astratto: `boolean test(T t)`.
Per fornire un'implementazione del metodo test dell'interfaccia funzionale passiamo come argomento alla funzione `visualizzaPartiteTerminate()` l'espressione lambda `p -> p.terminata()`, la quale rappresenta l'implementazione del metodo `test()`.


![partiteTerm1](/imgDocumentazione/partiteTerminate1.png)


Utilizzando la lista degli oggetti di classe `Partita`, cicliamo su tutte le partite e per ognuna di esse chiamiamo il metodo `test()` dell'interfaccia funzionale  ```Predicate<Partita>``` che utilizzando l'implementazione data dall'espressione lambda chiama il metodo `terminata()` della classe `Partita` che restituisce true se la partita è terminata, false altrimenti. Se la partita è terminata aggiunge una nuova riga nella tabella con la rispettiva partita terminata.  

#### Pipeline e stream:

![classifica](/imgDocumentazione/classifica.png)


Una delle funzionalità disponibili nel programma è quella di visualizzare in forma tabellare il ranking degli utenti, nonchè una classifica che include tutti gli utenti che hanno terminato almeno una partita. A ogni utente è associato il suo massimo punteggio raggiunto. La classifica è ordinata in ordine decrescente per punteggio.
Il costruttore della classe `Classifica` prende in input una lista di oggetti `Partita` e salva la lista utilizzando l'attributo private 'partite'.


![pipeline](/imgDocumentazione/pipeline.png)


A occuparsi della costruzione della classifica è il metodo `ottieniClassificaUtenti()` della classe `Classifica` che dopo aver effettuato le operazioni necessarie restituisce una lista di coppie <chiave,valore> con chiave di tipo `String` che rappresenta il nome dell'utente e valore di tipo `Integer` che rappresenta il massimo punteggio associato all'utente.

Entrando nei dettagli dell'implementazione del metodo `ottieniClassificaUtenti()`:

Utilizziamo la lista di partite salvate su DB passata al costruttore al momento dell'istanziazione dell'oggetto della classe `Classifica` per costruire il ranking.
Per la costruzione del ranking creiamo uno stream di oggetti della classe `Partita`. Uno stream è una sequenza di elementi che preleva valori da una sorgente attraverso una pipeline. Solitamente la sorgente è una `Collection`, in questo caso una lista. Invece, una pipeline è una sequenza di operazioni aggregate`(es: filter, map, foreach)` applicate ad uno stream, dove spesso i parametri di queste operazioni sono espressioni lambda.
L'operazione filter filtra gli oggetti selezionando solo le partite terminate, con il metodo `groupingBy()` raggruppiamo gli elementi per nome utente e punteggio massimo. Il `Collector mapping` che utilizziamo come downstream collector seleziona il punteggio massimo. Il primo metodo `collect()` restituisce una `Map`. Successivamente prendiamo tutte le coppie <chiave, valore> con il metodo `entrySet()` applicato alla `Map` restituita da collect, creiamo un nuovo stream di elementi con il metodo stream() e applichiamo allo stream ottenuto ancora una volta il metodo `collect()` che prende come parametro supplier il metodo `toMap()`della classe `Collectors`. Infine la pipeline ci restituisce una `Map<String, Integer>` con nome dell'utente e punteggio massimo associato.

Applichiamo alla Map restituita dalla pipeline il metodo `entrySet()` che ci restituisce una lista di elementi di tipo `Map.Entry<String,Integer>`, nonchè una lista di coppie chiave-valore. Ci salviamo questa lista per andare successivamente a ordinarla in base al punteggio in ordine decrescente. 

La lista finale ordinata restituita dal metodo `ottieniClassificaUtenti()`viene utilizzata dalla classe swing `JDialogClassificaUtenti` per stampare nell'interfaccia utente la tabella del ranking.



---
### Swing<a name="swing"></a>

Per la realizzazione delle interfacce grafiche abbiamo utilizzato swing, nonchè una libreria grafica per la creazione di UI (User interface) in java.
Poichè l'applicazione è realizzata interamente con interfacce grafiche tutti i file relativi alle interfacce swing sono inseriti all'interno del package `swing`.
* `FrameStart` è il frame iniziale dove l'utente inserisce il proprio username per poter iniziare una nuova partita. In alternativa l'utente può decidere di caricare una partita salvata cliccando il bottone `carica partita` oppure visualizzare il ranking degli utenti cliccando il bottone `ranking utenti`.
* `JDialogCaricaPartite` è una finestra di dialogo con una `JComboBox` che viene creata dinamicamente prendendo tutte le partite salvate su file e inserendo i nomi delle partite negli elementi della `JComboBox`.
Una volta selezionata la partita, si apre `JFrameApp` che permette di continuare la partita selezionata.
*  `JFrameApp` è il frame principale dove l'utente gioca la propria partita inserendo i comandi nella `JTextField`, all'interno della `JTextArea` vengono visualizzate tutte le risposte ai comandi inseriti dall'utente in gioco. L'utente conferma l'invio dei comandi attraverso l'invio da tastiera o, in alternativa, cliccando sul `JButton` "INVIA". All'interno del frame vengono mostrati e aggiornati dinamicamente numero di mosse e tempo trascorso all'interno di due JLabel. Inoltre abbiamo un `JButton` per visualizzare le statistiche.
*  `JDialogAbbandona` è la finestra di dialogo che si apre nel momento in cui si chiude il frame `JFrameApp`, nonchè il momento nel quale si abbandona la partita. Qui la finestra chiede attraverso la visualizzazione di una `JLabel` se si vuole salvare la partita o meno. La conferma della scelta da parte dell'utente avviene selezionando l'opportuno `JButton` "SI" o "NO". Per poter salvare la partita è necessario inserire il nome della partita, il quale viene inserito all'interno di una `JTextField`.
*  `JDialogStas` è la finestra di dialogo che si apre nel momento in cui l'utente chiede di visualizzare le statistiche. Questa finestra permette di visualizzare dinamicamente in forma tabellare:
  * Tutte le partite
  * Tutte le partite dell'utente in gioco
  * Tutte le partite terminate
  * Il punteggio di una specifica partita (l'utente inserisce il nome della partita cercata all'interno di una `JTextField`)

I dati delle partite vengono inseriti all'interno di una `JTable`, la quale è a sua volta inserita all'interno di un `JScrollPane` per la gestione della visualizzazione scorrevole delle righe della tabella.

* `JDialogClassificaUtenti` è la finestra di dialogo per la visualizzazione della classifica degli utenti che hanno terminato almeno una partita. Anche qui la `JTable` è visualizzata all'interno di un `JScrollPane` per la visualizzazione scorrevole. La tabella mostra nome utente e il punteggio massimo raggiunto associato all'utente.
* `JDialogPorta` è la finestra di dialogo che si apre nel momento in cui l'utente prova ad entrare all'interno dell'edificio abbandonato. La finestra di dialogo chiede l'inserimento del codice della porta che l'utente deve inserire cliccando sui `JButton` opportuni, ogni numero ha un `JButton`, man mano che l'utente inserisce un numero per il codice il `JTextField` si aggiorna visualizzando dinamicamente il codice inserito dall'utente fino a quel momento. E' possibile confermare o cancellare il codice inserito attraverso due `JButton` differenti.
* `JDialogRadio` è la finestra di dialogo che viene mostrata all'utente nel momento in cui egli accende la radio. La finestra di dialogo permette all'utente di selezionare un `JRadioButton` per scegliere il messaggio da comunicare ai militari via radio. La conferma della scelta avviene attraverso il `JButton` opportuno, oppure attraverso il comado invio da tastiera. Dopo ogni risposta la finestra di dialogo si aggiorna dinamicamente  inserendo i nuovi `JRadioButton` per il prosieguo della conversazione. Le risposte dei militari sono mostarte all'interno di una `JTextArea` che come nelle altre finestre è inserita all'interno di un `JScrollPane`. Lo spegnimento della radio avviene cliccando sul `JButton` opportuno.
* `JDialogPunteggio` è la finestra di dialogo per la visualizzazione del punteggio finale una volta vinta la partita.


Ogni `JFrame`,`JDialog` ha uno sfondo opaco che permette di non andare in contrasto con il testo, o con i componenti  visualizzati all'interno della finestra.
Tutte le finestre hanno una musica di sottofondo.

---

