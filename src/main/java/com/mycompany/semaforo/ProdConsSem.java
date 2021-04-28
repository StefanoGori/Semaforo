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
public class ProdConsSem{
    
    protected static int buffer;
    
    public static void main(String args[]) throws InterruptedException
    {
        Semaforo pieno = new Semaforo(0);
        Semaforo vuoto = new Semaforo(1);
        ProduciDato prod = new ProduciDato(pieno, vuoto);
        ConsumaDato cons = new ConsumaDato(pieno, vuoto);
        
        prod.start();
        cons.start();
        
        Thread.sleep(3000);
        System.out.println("Termine Del Main");
    }
}