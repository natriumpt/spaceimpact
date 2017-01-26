package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxProjectile extends SimpleGfxMovableRepresentable {
/*
    public SimpleGfxProjectile(int x, int y) {
        super(new Picture(x, y, "playershot.png"));
    }
*/
    private int currentFrame;
    private Picture[] animation;

    public SimpleGfxProjectile(int x, int y) {
        super(new Picture(x, y, "playershot0.png"));
        this.animation = new Picture[4];
        for (int i = 0; i < animation.length; i++) {
            animation[i] = new Picture(x, y, "playershot" + i + ".png");
        }
    }

    @Override
    public void move(int dx, int dy) {
        playAnimation();
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
        if (currentFrame == animation.length - 1) {
            currentFrame = 0;
        } else {
            currentFrame++;
        }
        animation[currentFrame].draw();
    }

}
