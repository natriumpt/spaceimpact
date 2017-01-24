package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class GameObject {

    private Representable representation;
    private int x;
    private int y;

    public Representable getRepresentation() {
        return representation;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GameObject(Representable representation) {
        this.representation = representation;
    }


}
