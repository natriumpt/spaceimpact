package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.MovableRepresentable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class MovableGameObject extends GameObject {

    private int speed;

    public MovableGameObject(Representable representation) {
        super(representation);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move(int dx, int dy) {
        ((MovableRepresentable) getRepresentation()).move(dx, dy);
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public void destroy() {
        ((MovableRepresentable) getRepresentation()).destroy();
    }

}
