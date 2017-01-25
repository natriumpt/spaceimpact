package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxProjectile extends SimpleGfxMovableRepresentable {

    public SimpleGfxProjectile(int x, int y) {
        super(new Picture(x, y, "playershot.png"));
    }

}
