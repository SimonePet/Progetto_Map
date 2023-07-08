/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giannantonio
 * @param <T>
 */
public class StampaListe<T> {
    private List<T> lista = new ArrayList<>();
    
    public StampaListe(List<T> lista){
        this.lista = lista;
    }
        
    public void stampa(){       
        for(T elemento : lista){
            if(elemento.getClass()==Partita.class){
                Partita p = (Partita) elemento;
                p.stampaPartita();
                System.out.println("-----------------------------------------------------------------------------");
            }else{
                System.out.println(elemento);
            }
        }
    }  
}
