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

/*    public boolean outOfBounds(Field field) {
        if (this.getW() > this.getX()) {
            this.move(getSpeed(),0);
            return true;
        }
        if (this.getH() > this.getY()) {
            this.move(0,getSpeed());
            return true;
        }
        if (field.getW() < this.getX() + this.getW()) {
            this.move(-getSpeed(),-getSpeed());
            return true;
        }
        if (field.getH() < this.getY() + this.getH()) {
            this.move(-getSpeed(), -getSpeed());
            return true;
        }
        return false;
    }*/

    public boolean outOfBounds(Field field) {
        return (this.getW() > this.getX() ||
                this.getH() > this.getY() ||
                field.getW() < this.getX() + this.getW() ||
                field.getH() < this.getY() + this.getH());
    }

}
