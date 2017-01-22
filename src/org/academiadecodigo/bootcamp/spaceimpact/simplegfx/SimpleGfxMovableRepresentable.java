package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.MovableRepresentable;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class SimpleGfxMovableRepresentable extends SimpleGfxRepresentable implements MovableRepresentable {

    public SimpleGfxMovableRepresentable(Picture picture) {
        super(picture);
    }

    @Override
    public void move(int dx, int dy) {
        if (getPicture() instanceof Movable) {
            ((Movable) getPicture()).translate(dx, dy);
        }
    }

}
