package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxField extends SimpleGfxRepresentable {

    private int currentFrame;
    private Picture[] animation;

    public SimpleGfxField(int x, int y) {
        this.animation = new Picture[30];
        for (int i = 0; i < animation.length; i++) {
            animation[i] = new Picture(x, y, "background" + i + ".png");
        }
    }

    public void playAnimation() {
        animation[currentFrame].delete();
        if (currentFrame == animation.length - 1) {
            currentFrame = 0;
        } else {
            currentFrame++;
        }
        animation[currentFrame].draw();
    }


}
