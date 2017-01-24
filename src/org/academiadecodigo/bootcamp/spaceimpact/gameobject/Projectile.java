package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Projectile extends MovableGameObject {

    private boolean friendly;

    public Projectile(Representable representation, boolean friendly, int speed) {
        super(representation);
        this.friendly = friendly;
        setSpeed(speed);
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void projectileMove(MoveDirection moveDirection) {

        switch (moveDirection) {

            case RIGHT:
                move(getSpeed(), 0);
                break;
            case LEFT:
                move(-getSpeed(), 0);
                break;
            default:
                System.out.println("Shit happened");

        }

    }

}
