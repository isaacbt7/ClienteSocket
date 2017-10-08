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
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.tag.FieldKey;
import Serversock.SocketEnvio;

/**
 *
 * @author Chack
 */
public class FileTags {

    MP3File mf;
    AudioFile audio;
    Tag tags;
    ID3v1Tag mp3tags;
    File f;

    public FileTags(String path) {
        f = new File("C:\\Users\\Chack\\Music\\Musica\\03 - This Picture.mp3");
        //f = new File(path);
        try {
            mf =  (MP3File) AudioFileIO.read(f);
            tags = mf.getTag();
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

    public Mp3Object getFileTags() {
        Mp3Object tagsObject = new Mp3Object();
        tagsObject.setArtist(mp3tags.getFirstArtist());
        tagsObject.setTitle(mp3tags.getFirstTitle());
        tagsObject.setFileName(mp3tags.getFirstArtist() + " - " + mp3tags.getFirstTitle() + ".mp3");
        System.out.println("nombre creado "+tagsObject.getFileName());
        //tagsObject.setMp3File(Mp3File);
        return tagsObject;
    }

    public void setFileTags(Mp3Object tagsObject) {
        AudioFile f = null;
        try {
            f = AudioFileIO.read(tagsObject.getMp3File());
            Tag tag = f.getTag();
            tag.setField(FieldKey.ARTIST, tagsObject.getArtist());
            tag.setField(FieldKey.TITLE, tagsObject.getTitle());
            AudioFileIO.write(f);
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
        } catch (CannotWriteException ex) {
            Logger.getLogger(FileTags.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //tag.setField(FieldKey.COMMENT, tagsObject.getFileName());
        
        //envido el objeto por socket
       SocketEnvio se = new SocketEnvio("localhost", 5000);
       se.enviando(tagsObject);

    }

}
