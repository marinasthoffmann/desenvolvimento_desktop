
package aula1;

import aula1.service.Calculadora;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author marina.hoffmann
 */
public class Exemplo1 {
    public static void main(String[] args) {
        int valor1 = 10;
        int valor2 = 7;
        int valor3 = 12;
       
//        Exercicio 1
        Calculadora calculadora = new Calculadora();        
        int total = calculadora.somar(valor1, valor2, valor3);        
        System.out.println(total);
        JOptionPane.showMessageDialog(null, "Total: " + total);
        
//        Exercicio 2
        String frase = "Simples como amar";
        System.out.println(calculadora.contarLetras(frase));
        JOptionPane.showMessageDialog(null, "Total de letras: " + calculadora.contarLetras(frase));
        
//        Exercicio 3
        System.out.println(calculadora.geraNumero());
        JOptionPane.showMessageDialog(null, "Número gerado: " + calculadora.geraNumero());
        
    }
    
    
}
