/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.security.SecureRandom;

/**
 *
 * @author marina.hoffmann
 */
public class Gerador {
  
    //        Static, pois não irei instanciar nenhum objeto
    /**
     * qtd é a quantidade de números que serão gerados.
     * 
     * @param quantidade
     * @return exempo quantidade = 3 -> "123"
     */
    public static String gerarNumero(int quantidade){
        String numero = "";
        for (int i = 0; i < quantidade; i++) {
            numero += (int) (Math.random() * 10);
        }        
        return numero;
    }
    
    public static String gerarTelefoneFixo(){
        return "(48)3" + gerarNumero(3) + "-" + gerarNumero(4);        
    }
    
    public static String gerarTelefoneMovel(){
        return "(48)9" + gerarNumero(4) + "-" + gerarNumero(4);        
    }
    
    public static String gerarCPF(){
        return gerarNumero(3) + "." + gerarNumero(3) + "." + 
                gerarNumero(3) + "-" + gerarNumero(2);   
    }

    public static String gerarCNPJ(){
        return gerarNumero(2) + "." + gerarNumero(3) + "." + 
                gerarNumero(3) + "/0001" + "-" + gerarNumero(2);   
    }

    public static String gerarCEP(){
        return gerarNumero(5) + "-" + gerarNumero(3);   
    }
    
    public static String gerarSenha(int quantidade)
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();
 
        for (int i = 0; i < quantidade; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            senha.append(chars.charAt(randomIndex));
        }
 
        return senha.toString();
    }
    
    public static String gerarNome(){
        String nomes[] = {"Juca", "Maria", "Marcos", "Marina", "Felipe", 
            "Kayma", "Creusa", "Lucas", "Diego", "José"};
        
        return nomes[Integer.parseInt(gerarNumero(1))];             
    }
    
    private static String gerarSobrenome(){ 
        String sobrenomes[] = {"Hoffmann", "Reibnitz", "Ticiani", "Kanoon", "Silveira", 
            "Tagliari", "Sousa", "Medeiros", "Rodrigues", "Lindt"};
        
        return sobrenomes[Integer.parseInt(gerarNumero(1))];          
    }
    
    public static String gerarLogin(){ 
        return gerarNome().toLowerCase() + "@";           
    }
    
    public static String gerarCidade(){ 
        //List<String> nomes = Arrays.asList("Junior", "Marina", "Ana");
        String cidades[] = {"Florianópolis", "São José", "Palhoça", "Brusque", "Joinville", 
            "Garopaba", "Rancho Queimado", "Brasília", "São Paulo", "Berlim"};
        
        return cidades[Integer.parseInt(gerarNumero(1))];         
    }
    
    public static String gerarBairro(){ 
        String bairros[] = {"Trindade", "Carvoeira", "Campeche", "Cacupé", "Monte Verde", 
            "Kobrassol", "Serraria", "Estreito", "Agronômica", "Centro"};
        
        return bairros[Integer.parseInt(gerarNumero(1))];         
    }
    
    public static String gerarUF(){ 
        String UFs[] = {"AC", "AM", "SP", "SC", "RJ", 
            "ES", "RS", "PR", "PE", "AL"};
        
        return UFs[Integer.parseInt(gerarNumero(1))];         
    }

    
// Como os dois métodos são estáticos, não é preciso instanciar objeto   
//    public static void main(String[] args) {
//        System.out.println(gerarNumero(3));
//        System.out.println(gerarTelefoneFixo());
//        System.out.println(gerarTelefoneMovel());
//        System.out.println(gerarCPF());
//        System.out.println(gerarCNPJ());
//        System.out.println(gerarCEP());
//        System.out.println(gerarSenha(10));
//        System.out.println(gerarNome());
//        System.out.println(gerarSobrenome());
//        System.out.println(gerarLogin());
//        System.out.println(gerarUF());
//        System.out.println(gerarCidade());
//        System.out.println(gerarBairro());
//    }
}
