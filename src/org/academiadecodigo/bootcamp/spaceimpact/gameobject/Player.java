package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Player extends Ship {

    private ProjectileFactory projectileFactory;
    private int lives;

    public Player(Representable representation, int x, int y, ProjectileFactory projectileFactory) {
        super(representation, x, y);
        this.projectileFactory = projectileFactory;
        // TODO: Implement hit points
        setLives(3);
        setSpeed(200); // TODO: change this to a more reasonable value
    }

    public void increaseLives() {
        lives++;
    }

    public void decreaseLives() {
        lives--;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public void hit() {
        lives--;
    }

    @Override
    public void fire() {
        if (super.fireBuffer == 0) {
            projectileFactory.createProjectile(GameObjectType.PROJECTILE, getX(), getY(), true, 100);
            super.fireBuffer = 10;
        }
    }

    public void decreaseFireBuffer() {
        if (fireBuffer > 0) fireBuffer--;
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
        return getX() + " " + getY();
    }
}
