/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.semaforo;

/**
 *
 * @author stefa
 */
public class ConsumaDato extends Thread
{
    public static boolean stop = true;
    Semaforo pieno;
    Semaforo vuoto;
    
    public ConsumaDato(Semaforo semaforo1, Semaforo semaforo2)
    {
        pieno = semaforo1;
        vuoto = semaforo2;
    }
   
    public void run()
    {
        while(stop) 
        {      
            pieno.P();
            if(!stop == false)
            System.out.println("Lettore: " + " Dato Letto: " + ProdConsSem.buffer);
            vuoto.V();
        }
    }
    
    public void ferma()
    {
        stop = false;
    }
}
