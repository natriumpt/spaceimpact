package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Enemy extends Ship {

    private ProjectileFactory projectileFactory;
    private boolean destroyed;
    private int enemyProjectileCount = 0;
    private Pattern pattern;


    public Enemy(Representable representation, int x, int y, int w, int h, ProjectileFactory projectileFactory) {
        super(representation, x, y, w, h);
        this.projectileFactory = projectileFactory;
        setHitPoints(3);
        setSpeed(4); // TODO: Change this to reasonable values
        pattern = new Pattern();
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


    public void updatePattern(Enemy enemy){
        enemy.pattern.doPattern(enemy);
    }

    @Override
    public void fire() {
        projectileFactory.createProjectile(GameObjectType.ENEMYPROJECTILE, getX(), getY() + getH() / 2, 16, 4, 1, 12);


    }


    public void destroy() {
        super.destroy();
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }


    @Override
    public String toString() {
        return "Enemy " + getX() + " " + getY() + " HP:" + getHitPoints();
    }
}
