package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;

public class SimpleGfxProjectile extends SimpleGfxMovableRepresentable {

    private int currentFrame;
    private int frameSkip;
    private Picture[] animation;

    public SimpleGfxProjectile(GameObjectType type, int x, int y) {
        try {
            new SimpleGfxSound("/sound/fire.wav");
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (type) {

            case PROJECTILE:
                this.animation = new Picture[4];
                for (int i = 0; i < animation.length; i++) {
                    animation[i] = new Picture(x, y, "/projectile/playershot" + i + ".png");
                }
                break;

            case ENEMYPROJECTILE:
                this.animation = new Picture[4];
                for (int i = 0; i < animation.length; i++) {
                    animation[i] = new Picture(x, y, "/projectile/enemyshot" + i + ".png");
                }
                break;

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
