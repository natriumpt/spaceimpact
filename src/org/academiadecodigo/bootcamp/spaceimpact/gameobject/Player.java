package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Player extends Ship {

    private ProjectileFactory projectileFactory;
    private int fireBuffer;
    private int lives;

    public Player(Representable representation, int x, int y, int w, int h, ProjectileFactory projectileFactory) {
        super(representation, x, y, w, h);
        this.projectileFactory = projectileFactory;
        setHitPoints(3);
        setLives(3);
        setSpeed(16); // TODO: change this to a more reasonable value
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

    public void decreaseFireBuffer() {
        if (fireBuffer > 0) fireBuffer--;
    }

    @Override
    public void fire() {
        if (fireBuffer == 0) {
            projectileFactory.createProjectile(GameObjectType.PROJECTILE, getX() + getW(), getY() + getH() / 2, 16,4, true, 1, 30);
            fireBuffer = 3;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public String toString() {
        return "Player Position: " + this.getX() + ":" + this.getY();
    }
}
