package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/28/17.
 */
public class SimpleGfxPowerUp extends SimpleGfxMovableRepresentable {

    private int currentFrame;
    private int frameSkip;
    private Picture[] animation;

    public SimpleGfxPowerUp(int x, int y) {
        this.animation = new Picture[5];
        for (int i = 0; i < animation.length; i++) {
            animation[i] = new Picture(x, y, "/powerup/powerup.png");
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (Picture picture : animation) {
            if (picture != null) {
                picture.translate(dx, dy);
            }
        }
    }

    @Override
    public void destroy() {
        for (Picture picture : animation) {
            if (picture != null) {
                picture.delete();
            }
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
            frameSkip = 2;
        }
        frameSkip--;
        animation[currentFrame].draw();
    }


}
