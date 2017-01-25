package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class Ship extends MovableGameObject {

    int fireBuffer;

    public Ship(Representable representation) {
        super(representation);
    }

    public abstract void fire();

    public abstract void hit();

}
