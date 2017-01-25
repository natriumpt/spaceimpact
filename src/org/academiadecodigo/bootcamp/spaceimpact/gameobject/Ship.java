package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class Ship extends MovableGameObject {

    private int hitPoints;

    public Ship(Representable representation, int x, int y, int w, int h) {
        super(representation);
        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void hit(int damage) {
        hitPoints -= damage;
    }

    public boolean isDestroyed() {
        return hitPoints <= 0;
    }

    public abstract void fire();

}
