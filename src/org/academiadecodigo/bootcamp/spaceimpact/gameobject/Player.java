package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Player extends Ship {

    private int lives;
    private int fireBuffer;

    public Player(Representable representation) {
        super(representation);
        setSpeed(200);
    }

    @Override
    public void fire() {
        if (fireBuffer == 0) {
            // TODO: Special method for projectile creation needed
            fireBuffer = 10;
        }
    }

    public void decreaseFireBuffer() {
        if (fireBuffer > 0)  fireBuffer--;
    }

    public void playerMove(MoveDirection moveDirection) {
        switch (moveDirection) {
            case UP:
                move(0, -getSpeed());
                break;
            case DOWN:
                move(0, getSpeed());
                break;
            case LEFT:
                move(-getSpeed(), 0);
                break;
            case RIGHT:
                move(getSpeed(), 0);
                break;
        }
    }

    @Override
    public String toString() {
        return getX() + " " +getY();
    }
}
