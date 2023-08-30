/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iriarte;



import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author itismeucci
 */
public class Turisti extends Thread {
    
        private int id;
        private Semaphore museoSemaphore;
        private Random  nrandom = new Random();
    
    public Turisti(int id, Semaphore museoSemaphore){
        
        this.id= id;
        this.museoSemaphore = museoSemaphore;
        
    }
    
    
    @Override 
    public void run(){
        
        try{
            System.out.println("turisti" + id + " aspetta di entrare nel museo.");
            museoSemaphore.acquire();
            System.out.println("Il turista "+ id + " entra nel museo");
            
            // Simulare il  tempo trascorso nel museo
            
             int visitaDurata = (int) ((Math.random()*10)+1);
             System.out.println("Turista " + id + " è in visita per " + visitaDurata + " secondi.");
             Thread.sleep(visitaDurata * 1000);
             System.out.println("Il turista " + id + " esce dal museo.");
             museoSemaphore.release();
             
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    
}
