/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Serversock.SocketEnvio;
import com.beaglebuddy.mp3.MP3;

/**
 *
 * @author Chack
 */
public class FileTagx {
    MP3 mp3s = null;
    public FileTagx() {
    }

    public FileTagx(String pathx) {//reciviendo ubicacion del archivo
        try {
            mp3s = new MP3(pathx);//creando un objeto de tipo mp3 con la libreria beaglebuddy
            if (mp3s.hasErrors())
         {
             System.out.println("mp3");
            mp3s.displayErrors(System.out);// display the errors that were found
         }
        } catch (IOException ex) {
           // Logger.getLogger(FileTagx.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error, probablemente no hay metadata");
        }

    }

    public Mp3Object getFileTags() {
        Mp3Object tagsObject = new Mp3Object();//creando objeto de tipo Mp3Object y darle los siguientes valores.
        try {
            tagsObject.setArtist(mp3s.getID3v1Tag().getArtist());
        }catch (NullPointerException e) {
            System.out.println("error, seteando como vacio");
            tagsObject.setArtist("");
        }
        try {
            tagsObject.setTitle(mp3s.getID3v1Tag().getTitle());
        } catch (NullPointerException e) {
            System.out.println("error, seteando como vacio");
            tagsObject.setTitle("");
        }
        return tagsObject;
    }

    public void setFileTags(Mp3Object tagsObject) {
        //enviando el objeto por socket
       SocketEnvio se = new SocketEnvio("localhost", 5000);
       se.enviando(tagsObject);

    }

}
