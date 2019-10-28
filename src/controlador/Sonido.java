/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author peperony
 */
public class Sonido extends Thread{
    private Thread actual;
    private ArrayList<String> Canciones;
    private Clip fondo;
    public Sonido () {
        try {
            fondo = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        actual = new Thread (this,"Musica");
        Canciones = new ArrayList<>();
        Canciones.add("Demons.wav");
        Canciones.add("RemenberTheName.wav");
        Canciones.add("SkyIsOve.wav");
    }
    
   public void sonidoBotones (Clip clip) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/fxs/Botones.wav")));
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(VistaControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run () {
        int i = (int) (Math.random() * 3);
        try {
            fondo.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/fxs/" + Canciones.get(i))));
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Sonido.class.getName()).log(Level.SEVERE, null, ex);
        }
        fondo.loop(Clip.LOOP_CONTINUOUSLY);
        fondo.start();

    }
}
