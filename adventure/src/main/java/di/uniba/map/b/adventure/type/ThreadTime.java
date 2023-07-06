/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.type;

import di.uniba.map.b.adventure.Engine;
import swing.JFrameApp;

/**
 *
 * @author Giannantonio
 */
public class ThreadTime implements Runnable{
    private int numMinuti;
    private int numSecondi;
    private JFrameApp frame;
    
    public ThreadTime(JFrameApp frame, int numMinutiIniziali, int numSecondiIniziali){
        this.numMinuti = numMinutiIniziali;
        this.numSecondi = numSecondiIniziali;
        this.frame = frame;
    }
    
    @Override
    public void run() {
        Engine e = frame.getEngine();
        int ore=0;
        for(int i=this.numSecondi;i!=-1;i++){
            if(i%3600==0 && i!=0) {
                ore++;
                e.getGame().setNumSecondi(numSecondi);
                e.getGame().setNumMinuti(numMinuti);
            }
            else{
                if (i % 60 == 0 && i!=0) {
                    this.numMinuti++;
                    this.numSecondi = 0;
                    e.getGame().setNumSecondi(numSecondi);
                    e.getGame().setNumMinuti(numMinuti);
                }
                else {
                    this.numSecondi++;
                    e.getGame().setNumSecondi(numSecondi);
                }
            }
            printTime(ore+":"+this.numMinuti+":"+this.numSecondi);
            //System.out.println(ore+":"+min+":"+sec);
            try {
                Thread.sleep(100);
            }catch(InterruptedException ex){
                System.out.println("Thread interrotto");
                return;
            }
        }
    }
    
    public void printTime(String time){
        frame.writeOnLabelTime(time);
    }

    
}
