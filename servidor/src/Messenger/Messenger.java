/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Messenger;

import Messenger.conector;
import Messenger.ventanaServidor;

/**
 *
 * @author HUARCAYA
 */
public class Messenger {
public static conector servidor;
   
    public static void main(String[] args) {
      ventanaServidor  server=new ventanaServidor();
      server.main();
     }
 
    public static void initserver(String ip)
    {
    servidor=new conector();
    servidor.start();
    
    }
            
    
    
    
}
