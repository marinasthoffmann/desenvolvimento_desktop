/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula1.service;

import java.util.Random;


/**
 *
 * @author marina.hoffmann
 */
public class Calculadora {
    public int somar(int valor1, int valor2, int valor3){
        return valor1 + valor2 + valor3;
    }
    
    public int contarLetras(String frase) {
        return frase.length();
    }
    
    public int geraNumero(){
        Random random = new Random();
        return random.nextInt(9);
    }
}
