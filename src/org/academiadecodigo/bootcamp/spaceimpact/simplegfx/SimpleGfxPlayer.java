package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxPlayer extends SimpleGfxMovableRepresentable {

    public SimpleGfxPlayer(int x, int y) {
        super(new Picture(x, y, "playership.png"));
    }

}
