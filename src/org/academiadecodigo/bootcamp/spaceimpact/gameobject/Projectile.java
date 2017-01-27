package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Projectile extends MovableGameObject {

    private boolean destroyed;
    private int damage;
    private GameObjectType type;

    public Projectile(Representable representation, GameObjectType type, int x, int y, int w, int h, int damage, int speed) {
        super(representation);
        this.type = type;
        this.damage = damage;
        setX(x);
        setY(y);
        setW(w);
        setH(h);
        setSpeed(speed);
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isFriendly() {

        if (type != GameObjectType.ENEMYPROJECTILE) {
            return true;
        }

        return false;


    }

    public void projectileMove() {
        if (!destroyed) {
            if (isFriendly()) {
                super.move(getSpeed(), 0);
            } else {
                super.move(-getSpeed(), 0);
            }
        }
    }

}
