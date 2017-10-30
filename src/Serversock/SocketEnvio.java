/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chack
 */
public class SocketEnvio {
    private String host;
    private int puerto;

    public SocketEnvio(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }
 
    public void enviando(Mp3Object tagsObject){
        try {
            System.out.println("envio "+host+" "+puerto);
            Socket sock = new Socket(host, puerto);//conectando con el servidor
            ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());//creando objeto de tipo ObjectOutputStream y donde sera enviada 
            out.writeObject(tagsObject);//enviando
            out.flush();//limpiando ObjectOutputStream
            out.close();//cerrando ObjectOutputStream
            sock.close();//cerrando el socket
        } catch (IOException ex) {
            Logger.getLogger(SocketEnvio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
