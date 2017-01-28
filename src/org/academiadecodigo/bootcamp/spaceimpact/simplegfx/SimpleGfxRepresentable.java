package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class SimpleGfxRepresentable implements Representable {

    private Picture picture;
    private Text text;

    public SimpleGfxRepresentable() {
    }

    public SimpleGfxRepresentable(Picture picture) {
        this.picture = picture;
        picture.draw();
    }

    public SimpleGfxRepresentable(Text text){
        this.text = text;
        text.draw();
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
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
