package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.MovableRepresentable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class MovableGameObject extends GameObject {

    private int speed;

    public MovableGameObject(Representable representation) {
        super(representation);
    }

    public void move(int dx, int dy){
        ((MovableRepresentable) getRepresentation()).move(dx, dy);
    }

}
