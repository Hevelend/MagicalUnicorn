package ca.magical.unicorn.windows;

import java.io.*;
import javazoom.jl.player.*;

public class Toune extends Thread {

    private String fileLocation;
    private boolean loop;
    private Player music_player;

    public Toune(String fileLocation, boolean loop) {
        this.fileLocation = fileLocation;
        this.loop = loop;
    }

    // On démarre la musique
    public void run() {
        try {
            do {
                FileInputStream buff = new FileInputStream(fileLocation);
                music_player = new Player(buff);
                music_player.play();
            } while (loop);
        } catch (Exception ioe) {
            // TODO error handling
        }
    }

    // On stop la musique
    public void close(){
        loop = false;
        music_player.close();
        this.interrupt();
    }
}