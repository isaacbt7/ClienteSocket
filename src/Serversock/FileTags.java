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
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import Serversock.Mp3Object;

/**
 *
 * @author Chack
 */
public class FileTags {

    private File Mp3File;
    private AudioFile audio;
    private Tag tags;
    private ID3v1Tag mp3tags;

    public FileTags(String path) {
        Mp3File = new File(path);
        try {
            audio = (MP3File) AudioFileIO.read(Mp3File);
            tags = audio.getTag();
            mp3tags = (ID3v1Tag) tags;
        } catch (CannotReadException ex) {
            Logger.getLogger(FileTags.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileTags.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagException ex) {
            Logger.getLogger(FileTags.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ReadOnlyFileException ex) {
            Logger.getLogger(FileTags.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAudioFrameException ex) {
            Logger.getLogger(FileTags.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getFileTags() {//asignando valores Mp3Object obtenidos del archivo mp3
        Mp3Object tagsObject = new Mp3Object();
        tagsObject.setArtist(mp3tags.getFirstArtist());
        tagsObject.setTitle(mp3tags.getFirstTitle());
        tagsObject.setFileName(mp3tags.getFirstArtist() + " - " + mp3tags.getFirstTitle() + ".mp3");
        System.out.println("nombre creado "+tagsObject.getFileName());
        tagsObject.setMp3File(Mp3File);
    }

    public void setFileTags() {

    }

}
