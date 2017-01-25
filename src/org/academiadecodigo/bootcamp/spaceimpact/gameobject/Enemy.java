package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Enemy extends Ship {

    ProjectileFactory projectileFactory;
    private int hitPoints;

    public Enemy(Representable representation, int x, int y, ProjectileFactory projectileFactory) {
        super(representation, x, y);
        this.projectileFactory = projectileFactory;
        setHitPoints(3);
        setSpeed(1); // TODO: Change this to reasonable values
    }

    public int getHitPoints() {
        return hitPoints;
    }

    private void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void enemyMove(int x, int y) {
        // TODO: Change this to ensure more realistic diagonal movement
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

    @Override
    public void fire() {
        if (super.fireBuffer == 0) {
            projectileFactory.createProjectile(GameObjectType.PROJECTILE, getX(), getY(),false, 100);
            super.fireBuffer = 10;
        }
    }

    @Override
    public void hit() {
        hitPoints--;
    }

    public void pattern() {
        // TODO: Implement a pattern for the enemy
        throw new UnsupportedOperationException();
    }

}
