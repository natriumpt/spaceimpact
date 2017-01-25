package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class Ship extends MovableGameObject {

    int fireBuffer;

    public Ship(Representable representation, int x, int y) {
        super(representation);
        this.setX(x);
        this.setY(y);
    }

    public abstract void fire();

    public abstract void hit();

}
