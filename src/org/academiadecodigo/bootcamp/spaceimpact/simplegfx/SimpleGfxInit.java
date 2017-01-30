package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 1/30/17.
 */
public class SimpleGfxInit extends SimpleGfxMovableRepresentable {

    private Picture animation;

    public SimpleGfxInit(int x, int y) {
        this.animation = new Picture(x, y, "/init/spaceimpact_screen.png");;
    }

    public void playAnimationDraw() {
        animation.draw();
    }

    public void playAnimationDelete() {
        animation.delete();
    }

}
