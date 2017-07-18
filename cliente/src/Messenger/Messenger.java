/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Messenger;

/**
 *
 * @author HUARCAYA
 */
public class Messenger {
public static conector cliente;
   
    public static void main(String[] args) {
      ventanaCliente  server=new ventanaCliente();
      server.main();
     }
    public static void initserver()
    {
    cliente=new conector();
    }
    
    public static void initserver(String ip)
    {
    cliente=new conector(ip);
    cliente.start();// que comiensa el hilo a funcionar
    }
            
    
    
    
}
