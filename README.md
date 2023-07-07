# Progetto_Map

## Indice

- [Caso di studio](#caso-di-studio)
- [Diagramma delle classi](#diagramma-delle-classi)
- [Specifica algebrica](#specifica-algebrica)
- [Argomenti inseriti nel caso di studio](#argomenti-inseriti-nel-caso-di-studio)
  - [Paradigma OO](#paradigma-OO)
  - [Collection](#collection)
  - [Eccezioni](#eccezioni)
  - [File](#file)
  - [JDBC](#jdbc)
  - [Thread](#thread)
  - [Socket](#socket)
  - [Lambda expressions](#lambda-expressions)
  - [Swing](#swing)

---

## Caso di studio<a name="caso-di-studio"></a>

---

## Diagramma delle classi
---

## Specifica algebrica

---

## Argomenti inseriti nel caso di studio<a name="argomenti-inseriti-nel-caso-di-studio"></a>

### Paradigma OO<a name="paradigma-OO"></a>
Nel seguente caso di studio è stato fatto uso del paradigma OO(Object Oriented).
In questo paradigma si orgnanizza il codice intorno agli oggetti, i quali rappresentano entità del mondo reale o concetti astratti.
Ci sono tre principi fondamentali della programmazione orientata agli oggetti: Incapsulamento, Ereditarietà e Polimorfismo.
#### Incapsulamento
Information hiding e incapsulamento sono concetti cardine del paradigma orientato a oggetti.
Gli oggetti all'interno del programma incapsulano uno stato e un comportamento. Lo stato è identificato dal contenuto di una certa area di memoria. Il comportamento è definito come una collezione di procedure e funzioni (metodi) che possono operare sulla rappresentazione dell’area di memoria associata all’oggetto.
L'utilizzo dell'occultamento dell'informazione e l'incapsulamento rendono possibile l'uso di oggetti ricorrendo solo a metodi pubblici. Gli attributi delle classi sono quasi sempre privati, perciò non accessibili direttamente da altre classi o oggetti, essi forniscono un controllo più stretto sull'accesso e la modifica dei dati di una classe.

#### Erditarietà
E' stato fatto utilizzo dell'ereditarietà, nonchè una relazione fondamentale tra le classi. Una classe è considerata come un repertorio di conoscenze a partire dal quale è possibile definire altre classi più specifiche, che completano le conoscenze della loro classe madre.
Un esempio di ereditarietà presente all'interno del caso di studio è la relazione tra la classe astratta Database e la classe DatabaseController, dove DatabaseController è una sottoclasse di Database, perciò eredita tutti i metodi e attributi public/protected. 
La sottoclasse DatabaseController introduce delle caratteristiche non presenti nella superclasse, quindi in questo caso è stata utilizzata l'ereditarietà per estensione.
Allo stesso tempo però la sottoclasse DatabaseController effettua l'overriding dei metodi ereditati dalla superclasse Database, fornendo un implementazione dei metodi astratti. Perciò in questo caso è stata utilizzata l'ereditarietà per variazione funzionale poichè si ridefiniscono alcune caratteristiche della superclasse.
Ovviamente questo non è l'unico utilizzo di ereditarietà all'interno del caso di studio.

#### Polimorfismo
E' stato fatto utilizzo del polimorfismo. Con questo termine si intende la possibilità di associare a una operazione diverse realizzazioni. 
Per esempio si è fatto uso del polimorfismo per overloading che consente a una classe di fornire implementazioni diverse dello stesso metodo, in base a tipo o numero dei parametri passati. Un esempio di utilizzo lampante di polimorfismo per overloading nel caso di studio è osservabile nell'implementazione del metodo getPunteggio della classe DatabaseController dove il metodo restituisce il punteggio di una partita sia passando il nome della partita (parametro di tipo String), sia passando l'id della partita (parametro di tipo int).

---
### Collection<a name="collection"></a>
All'interno del caso di studio sono state utilizzate le seguenti collection:
#### List
Le liste vengono utilizzate all'interno del caso di studio nelle seguenti situazioni:
* La classe Classifica ha come attributo una lista di elmenti di tipo Partita, la lista di partite viene utilizzata dal metodo 'ottieniClassificaUtenti' per filtrare le partite degli utenti e costruire il ranking degli utenti che hanno vinto almeno una partita con il punteggio massimo.
* La classe DatabaseController ha un metodo 'ottieniListaPartite' che salva tutte le partite salvate su DB all'interno di una lista, per poi successivamente restituirla.
* La classe GameDescription ha come attributi:
  - una lista di elementi di tipo Stanza
  - una lista di elementi di tipo Comando
  - una lista di elementi di tipo Oggetto per l'inventario
  - una lista di elementi di tipo Oggetto per gli oggetti del gioco
* La classe Inventario ha come attributo una lista di elementi di tipo Oggetto utilizzata dai metodi della classe per aggiungere e rimuovere elementi nell'inventario
* La classe Stanza ha come attributo una lista di elementi di tipo Oggetto
* La classe OggettoContenitore ha come attributo una lista di elementi di tipo Oggetto contenente gli oggetti contenuti dal contenitore
#### Set
* stopwords 
* comandi ControlGioco
* aliasComando classe Comando
#### Map



---
### Eccezioni<a name="eccezioni"></a>

---
### File<a name="file"></a>

---
### JDBC<a name="jdbc"></a>

---
### Thread<a name="thread"></a>

---
### Socket<a name="socket"></a>

---
### Lambda expressions<a name="lambda-expressions"></a>

---
### Swing<a name="swing"></a>

---

