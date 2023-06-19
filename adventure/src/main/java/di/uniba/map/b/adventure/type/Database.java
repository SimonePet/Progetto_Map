/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.type;
/**
 *
 * @author Giannantonio
 */
public class Database{
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS partita (Id INT PRIMARY KEY AUTOINCREMENT, nome VARCHAR(1024) username VARCHAR(1024), punteggio INT DEFAULT 0, tempo TIME DEFAULT NULL, TERMINATA boolean DEFAULT FALSE, num_mosse INT DEFAULT 0)";
    private String username;
    private String password;  
    /* controlla se esiste una tabella con nome partita, se esiste non crearla, altrimenti crea tabella partita*/
    public Database() {
        
    }
    /*aggiunge nuova partita alla tabella*/   
    public boolean add(String username, boolean terminata, int numSecondi, int num_mosse){       
        if(terminata){
            //calcola punteggio con formula legata a tempo e numero mosse
            //inserimento completo
            
        }else{
            //inserimento senza punteggio  
        }
        return false;
    }
    
    public int fetch(String username) {
        return 0;
    }

}
