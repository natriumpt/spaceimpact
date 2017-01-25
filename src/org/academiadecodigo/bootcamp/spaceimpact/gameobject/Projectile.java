package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Projectile extends MovableGameObject {

    private boolean friendly;

    public Projectile(Representable representation, int x, int y, boolean friendly, int speed) {
        super(representation);
        setX(x);
        setY(y);
        this.friendly = friendly;
        setSpeed(speed);
    }

    public boolean isFriendly() {
        return friendly;
    }

    public void projectileMove() {
        if (friendly) {
            super.move(getSpeed(),0);
        } else {
            super.move(-getSpeed(),0);
        }
    }

}

//    public void projectileMove(MoveDirection moveDirection) {
//
//        switch (moveDirection) {
//
//            case RIGHT:
//                move(getSpeed(), 0);
//                break;
//            case LEFT:
//                move(-getSpeed(), 0);
//                break;
//            default:
//                System.out.println("Shit happened");
//
//        }
//
//    }
