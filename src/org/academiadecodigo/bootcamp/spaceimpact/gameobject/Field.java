package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Field extends GameObject {

    private int w;
    private int h;
    private int x;
    private int y;

    public Field(Representable representation) {
        super(representation);
        this.x = 0;
        this.y = 0;
        this.w = 720;
        this.h = 480;

    }



    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

}
