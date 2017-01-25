package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class GameObject {

    private Representable representation;
    private int x;
    private int y;
    private int w;
    private int h;

    public GameObject(Representable representation) {
        this.representation = representation;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean comparePos(GameObject gameObject1, GameObject gameObject2) {
        return (
                gameObject1.getX() < gameObject2.getX() + gameObject2.getW() &&
                gameObject1.getX() + gameObject1.getW() > gameObject2.getX() &&
                gameObject1.getY() < gameObject2.getY() + gameObject2.getH() &&
                gameObject1.getY() + gameObject1.getH() > gameObject2.getY());
    }

}
