package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class ProjectileFactory extends GameObjectFactory {

    private RepresentableFactory representableFactory;
    private Projectile[] projectiles;
    private int projectileCounter;

    public ProjectileFactory(RepresentableFactory representableFactory) {
        super(representableFactory);
        this.representableFactory = representableFactory;
    }

    public Projectile createProjectile(GameObjectType type, int x, int y, int w, int h, int damage, int speed) {

        Projectile projectile = null;

        switch (type) {
            case PROJECTILE:
                projectile = new Projectile((Representable) representableFactory.createRepresentation(type, x, y), type, x, y, w, h, damage, speed);
                addToProjectileArray((Projectile) projectile);
                break;
            case ENEMYPROJECTILE:
                projectile = new Projectile((Representable) representableFactory.createRepresentation(type,x,y),type,x,y,w,h,damage,speed);
                addToProjectileArray((Projectile) projectile);
                break;
        }

        return projectile;

    }

    public void setProjectileArray(Projectile[] projectiles) {
        this.projectiles = projectiles;
    }

    private void addToProjectileArray(Projectile projectile) {
        projectiles[projectileCounter] = projectile;
        if (projectileCounter == projectiles.length - 1) projectileCounter = 0;
        else projectileCounter++;
    }

}
