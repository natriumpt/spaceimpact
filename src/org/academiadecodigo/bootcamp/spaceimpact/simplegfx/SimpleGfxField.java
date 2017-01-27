package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;

public class SimpleGfxField extends SimpleGfxRepresentable {

    private int currentFrame;
    private int frameSkip;
    private Picture[] animation;

    public SimpleGfxField(int x, int y) {
        try {
            new SimpleGfxSound("/sound/hydra.wav");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.animation = new Picture[30];
        for (int i = 0; i < animation.length; i++) {
            animation[i] = new Picture(x, y, "/background/background" + i + ".png");
        }
    }

    public void playAnimation() {
        animation[currentFrame].delete();
        if (frameSkip < 0) {
            if (currentFrame == animation.length - 1) {
                currentFrame = 0;
            } else {
                currentFrame++;
            }
            frameSkip = 1;
        }
        frameSkip--;
        animation[currentFrame].draw();
    }


}
