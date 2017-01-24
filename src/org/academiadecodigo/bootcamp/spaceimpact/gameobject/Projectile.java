package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Projectile extends MovableGameObject {

    boolean friendly;

    public Projectile(Representable representation, boolean friendly, int speed) {
        super(representation);
        this.friendly = friendly;
        setSpeed(speed);
    }


}
