package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectType;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class SimpleGfxRepresentableFactory implements RepresentableFactory {
    @Override
    public Representable createRepresentation(GameObjectType type, int x, int y) {

        Representable representation = null;

        switch (type) {
            case PLAYER:
                representation = new SimpleGfxPlayer(x,y);
                break;
            case ENEMY:
                representation = new SimpleGfxEnemy();
                break;
            case FIELD:
                representation = new SimpleGfxField();
                break;
            case PROJECTILE:
                representation = new SimpleGfxProjectile()
        }

        return representation;
    }

}
