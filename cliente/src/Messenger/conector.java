/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Messenger;
//los iportes
import java.net.*;
import java.io.*;
import Messenger.Messenger;//hemos importado el paquete messenger y clase messeger

        
public class conector extends Thread{ // hilos
    //creamos variables de clse private
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;// la entrada de socket o de lector 
    private DataOutputStream salida;//la salida de soket o de datos 
    private BufferedReader entrada;//para leer el mesajes
    final int puerto=8000;
    // crear metodos llamado conector 
    public conector()
    {
        try{
                ss=new ServerSocket(puerto);// el servidor se ba conectar al puerto y se al macena en ss
                s=ss.accept();// el aceptacion al socket servidor
                //se crea la entrada de datos pra la lectura de un mensaje
                entradaSocket=new InputStreamReader(s.getInputStream());
                entrada=new BufferedReader(entradaSocket);
                // la creacion de salida ded datos para el envio del mesaje
                salida=new DataOutputStream(s.getOutputStream());
                }catch(Exception e){};   
    } 
    
    
    
    
    public conector(String ip)//recibir ip
    {
     try{
               s=new Socket(ip,this.puerto);
               
                //se crea la entrada de datos pra la lectura de un mensaje
                entradaSocket=new InputStreamReader(s.getInputStream());
                entrada=new BufferedReader(entradaSocket);
                // la creacion de salida ded datos para el envio del mesaje
                salida=new DataOutputStream(s.getOutputStream());
                
               }catch(Exception e){}; 
    }
    
    
    
    public void  run()
    {
    String texto;
    while(true)
    {
    try{
        texto=entrada.readLine();//guardamos el mensaje que resibinos
        ventanaCliente.jTextArea1.setText(ventanaCliente.jTextArea1.getText() + "\n" +texto);
        
        }catch(IOException e){};
    }
    
    }
    
    
    
    
    
    
    public void inviarMsg(String msg)
    {
        try{
        salida.writeUTF(msg+"\n");
        }catch(Exception e){};
    
    }
    
    
    
    public String LeerMSG()
    {
        try{
        return entrada.readLine();
        }catch(IOException e){};
        
        return null; 
    }
    
    
    public void desconectar()
    {
        try{
         s.close();
        }catch(IOException e){};
        
        
        try{
        ss.close();
        }catch(IOException e){};
    
    }
    
    
    
    
}
