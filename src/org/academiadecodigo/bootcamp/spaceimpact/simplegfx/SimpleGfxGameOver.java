package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/31/17.
 */
public class SimpleGfxGameOver {

    private Picture animation;

    public SimpleGfxGameOver(int x, int y){
        this.animation = new Picture(x, y, "/splashscreens/gameover_screen.png");;
    }

    public void playAnimationDraw() {
        animation.draw();
    }

    public void playAnimationDelete() {
        animation.delete();
    }

}

