/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serversock;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Chack
 */
public class Mp3Object implements Serializable{
    private String FileName;
    private String Artist;
    private String Title;
    private File Mp3File;

    public Mp3Object() {
    }

    public Mp3Object(String FileName, String Artist, String Title, File Mp3File) {
        this.FileName = FileName;
        this.Artist = Artist;
        this.Title = Title;
        this.Mp3File = Mp3File;
    }

    /**
     * @return the FileName
     */
    public String getFileName() {
        return FileName;
    }

    /**
     * @param FileName the FileName to set
     */
    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    /**
     * @return the Artist
     */
    public String getArtist() {
        return Artist;
    }

    /**
     * @param Artist the Artist to set
     */
    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Mp3File
     */
    public File getMp3File() {
        return Mp3File;
    }

    /**
     * @param Mp3File the Mp3File to set
     */
    public void setMp3File(File Mp3File) {
        this.Mp3File = Mp3File;
    }



    
    
    
}
