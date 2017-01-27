package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Projectile extends MovableGameObject {

    private boolean friendly;
    private boolean destroyed;
    private int damage;

    public Projectile(Representable representation, int x, int y, int w, int h, boolean friendly, int damage, int speed) {
        super(representation);
        this.friendly = friendly;
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
        return friendly;
    }

    public void projectileMove() {
        if (!destroyed) {
            if (friendly) {
                super.move(getSpeed(), 0);
            } else {
                super.move(-getSpeed(), 0);
            }
        }
    }

}
