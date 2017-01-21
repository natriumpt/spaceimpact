package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Field extends GameObject {

    private int x;
    private int y;
    private int w;
    private int h;

    public Field(Representable representation) {
        super(representation);
    }

}
