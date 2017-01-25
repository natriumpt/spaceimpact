package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxField extends SimpleGfxRepresentable {

    //TODO implement pictureArray to simulate animation of background

    private Picture[] pictureArray;

    public SimpleGfxField(int x, int y) {
        super(new Picture(x, y, "background01.png"));
        this.pictureArray = new Picture[30];
    }

}
