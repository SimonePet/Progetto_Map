/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.adventure.type;

import swing.JFrameApp;

/**
 *
 * @author Giannantonio
 */
public class ThreadTime implements Runnable{
    
    JFrameApp frame;
    
    public ThreadTime(JFrameApp frame){
        this.frame = frame;
    }
    
    @Override
    public void run() {
        int ore=-1,min=0,sec=0;
        for(int i=0;i<10000;i++){
            if(i%3600==0) {
                ore++;
                min = 0;
                sec = 0;
            }
            else{
                if (i % 60 == 0) {
                    min++;
                    sec = 0;
                }
                else {
                    sec++;
                }
            }
            printTime(ore+":"+min+":"+sec);
            System.out.println(ore+":"+min+":"+sec);
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Ciao");
            }
        }
    }
    
    public void printTime(String time){
        frame.writeOnLabelTime(time);
    }

    
}
