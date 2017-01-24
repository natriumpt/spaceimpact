package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectType;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class SimpleGfxRepresentableFactory implements RepresentableFactory {

    public Representable createRepresentation(GameObjectType type) {

        Representable representation = null;

        switch (type) {
            case PLAYER:
                representation = new SimpleGfxPlayer(50,50);
                break;
            case ENEMY:
                representation = new SimpleGfxEnemy(100,100);
                break;
            case FIELD:
                representation = new SimpleGfxField(500,600);
                break;
            case PROJECTILE:
                break;
        }

        return representation;
    }

}


