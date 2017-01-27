package org.academiadecodigo.bootcamp.spaceimpact.sound;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

public class SoundHandler {

    public void playBackground() throws IOException {
        InputStream bgInput = this.getClass().getResourceAsStream("/hydra.wav");
        AudioStream bgStream = new AudioStream(bgInput);
        AudioPlayer.player.start(bgStream);
    }

    public void playFire() throws IOException {
        InputStream fireInput = this.getClass().getResourceAsStream("/fire.wav");
        AudioStream fireStream = new AudioStream(fireInput);
        AudioPlayer.player.start(fireStream);
    }

}
