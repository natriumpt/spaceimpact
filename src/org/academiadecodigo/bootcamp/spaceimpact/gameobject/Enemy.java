package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Enemy extends Ship {

    public Enemy(Representable representation) {
        super(representation);
        setSpeed(1);
    }

    public void enemyMove(int x, int y) {
        if (getX() != x || getY() != y) {
            if (getX() > x) {
                move(-getSpeed(), 0);
            }
            if (getX() < x) {
                move(getSpeed(), 0);
            }
            if (getY() > y) {
                move(0, -getSpeed());
            }
            if (getY() < y) {
                move(0, getSpeed());
            }
        }
    }

    public void pattern() {
        //enemyMove(20,30);
        fire();
        //enemyMove(80,20);
        fire();

    }

}
