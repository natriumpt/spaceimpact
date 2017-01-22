package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class SimpleGfxRepresentable implements Representable {

    private Picture picture;

    public Picture getPicture() {
        return picture;
    }

    public SimpleGfxRepresentable(Picture picture){
        this.picture = picture;
        picture.draw();
    }

    @Override
    public int getX() {
        return picture.getX();
    }

    @Override
    public int getY() {
        return picture.getY();
    }

}
