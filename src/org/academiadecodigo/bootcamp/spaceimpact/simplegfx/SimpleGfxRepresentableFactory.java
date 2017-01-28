package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectType;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class SimpleGfxRepresentableFactory implements RepresentableFactory {

    private static final int PADDING = 10;

    public Representable createRepresentation(GameObjectType type, int x, int y) {

        Representable representation = null;

        switch (type) {
            case PLAYER:
                representation = new SimpleGfxPlayer(x, y);
                break;
            case ENEMY:
                representation = new SimpleGfxEnemy(x, y);
                break;
            case FIELD:
                representation = new SimpleGfxField(PADDING, PADDING);
                break;
            case PROJECTILE:
                representation = new SimpleGfxProjectile(GameObjectType.PROJECTILE,x, y);
                break;
            case ENEMYPROJECTILE:
                representation = new SimpleGfxProjectile(GameObjectType.ENEMYPROJECTILE,x,y);
                break;

        }

        return representation;
    }

}


