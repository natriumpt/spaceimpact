package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.MovableRepresentable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class GameObjectFactory {

    private RepresentableFactory representableFactory;

    public GameObjectFactory(RepresentableFactory representableFactory) {
        this.representableFactory = representableFactory;
    }

    public GameObject createObject(GameObjectType type) {

        GameObject gameObject = null;

        switch (type) {
            case PLAYER:
                gameObject = new Player((MovableRepresentable) representableFactory.createRepresentation(type));
                break;
            case ENEMY:
                gameObject = new Enemy((MovableRepresentable) representableFactory.createRepresentation(type));
                break;
            case FIELD:
                gameObject = new Field((Representable) representableFactory.createRepresentation(type));
                break;
        }

        return gameObject;

    }

}
