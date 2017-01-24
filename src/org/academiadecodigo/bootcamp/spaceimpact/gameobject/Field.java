package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Field extends GameObject {

    private int w;
    private int h;
    private int x;
    private int y;

    public Field(Representable representation) {
        super(representation);
        setField(10,10,10,10, 5);
    }

    private void setField(int x, int y, int w, int h, int PADDING){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

    }

    public int getW() { return w;}

    public int getH() { return h;}

}
