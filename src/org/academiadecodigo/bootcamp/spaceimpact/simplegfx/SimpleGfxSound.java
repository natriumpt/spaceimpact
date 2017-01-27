package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

public class SimpleGfxSound {

    SimpleGfxSound() {

    }

    SimpleGfxSound(String string) throws IOException {
        playSound(string);
    }

    public void playSound(String string) throws IOException {
        InputStream input = this.getClass().getResourceAsStream(string);
        AudioStream stream = new AudioStream(input);
        AudioPlayer.player.start(stream);
    }

}
