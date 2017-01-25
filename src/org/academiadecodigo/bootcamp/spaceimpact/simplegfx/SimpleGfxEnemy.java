package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxEnemy extends SimpleGfxMovableRepresentable {

    public SimpleGfxEnemy(int x, int y) {
        super(new Picture(x, y, ""));
    }

    public void move(int x, int y) {
        super.move(x, y);
    }

    @Override
    public void destroy() {

    }

}
