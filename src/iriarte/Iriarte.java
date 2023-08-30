/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iriarte;

import java.util.concurrent.Semaphore;

/**
 *
 * @author itismeucci
 */
public class Iriarte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numTuristi = 8;
        int maxCapa = 3;
        
        Semaphore museumSemaphore = new Semaphore(maxCapa);
        
        
         for (int i = 1; i <= numTuristi; i++) {
            Thread touristThread = new Turisti(i, museumSemaphore);
            touristThread.start();
            
            // Introdurre un piccolo ritardo prima di creare il prossimo turista
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
         }
    }
    
}
