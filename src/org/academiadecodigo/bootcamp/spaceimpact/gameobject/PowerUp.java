package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

/**
 * Created by codecadet on 1/28/17.
 */
public abstract class PowerUp extends MovableGameObject {


    public PowerUp(Representable representation, int x, int y, int w, int h) {
        super(representation);
        this.setX(x);
        this.setY(y);
        this.setW(w);
        this.setH(h);
    }

    public boolean isDestroyed(){
        return false;
    }

    public abstract void setPoints();

}
