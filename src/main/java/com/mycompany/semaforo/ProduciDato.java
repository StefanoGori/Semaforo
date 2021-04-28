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
public class ProduciDato extends Thread {
    int tanti = 5;
    final int attesa = 500;
    Semaforo pieno;
    Semaforo vuoto;
    
    public ProduciDato(Semaforo semaforo1, Semaforo semaforo2)
    {
        pieno = semaforo1;
        vuoto = semaforo2;
    }
    
    public void run()
    {
        int k = 0;
        ConsumaDato d = new ConsumaDato(null, null);
        
        for(;k < tanti; k++)
        {
            vuoto.P();                                         
            ProdConsSem.buffer = k;
            System.out.println("Scrittore: dato scritto: " + k);
            pieno.V();                                          
            
            try
            {
                Thread.sleep(attesa);  
            }
            catch(Exception e)
            {
            }
        }
        
        d.ferma();      
        pieno.V();      
        System.out.println("Scrittore: Termine di scrittura dati");
    }
}
