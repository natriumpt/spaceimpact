package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.init.SplashScreen;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.MovableRepresentable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class GameObjectFactory {

    private RepresentableFactory representableFactory;

    public GameObjectFactory(RepresentableFactory representableFactory) {
        this.representableFactory = representableFactory;
    }

    public RepresentableFactory getRepresentableFactory() {
        return representableFactory;
    }

    public GameObject createObject(GameObjectType type, int x, int y) {

        GameObject gameObject = null;

        switch (type) {
            case FIELD:
                gameObject = new Field((Representable) representableFactory.createRepresentation(type, x, y));
                break;
            case SPLASHSCREEN:
                gameObject = new SplashScreen((Representable) representableFactory.createRepresentation(type, x, y));
                break;
        }

        return gameObject;

    }

    public GameObject createObject(GameObjectType type, int x, int y, int w, int h, ProjectileFactory projectileFactory) {

        GameObject gameObject = null;

        switch (type) {
            case PLAYER:
                gameObject = new Player((MovableRepresentable) representableFactory.createRepresentation(type, x, y), x, y, w, h, projectileFactory);
                break;
            case ENEMY:
                gameObject = new Enemy((MovableRepresentable) representableFactory.createRepresentation(type, x, y), x, y, w, h, projectileFactory);
                break;
        }

        return gameObject;

    }

    public GameObject createPowerUp(GameObjectType type, int x, int y, int w, int h, Player player){
        GameObject gameObject = null;

        gameObject = new PowerUpLives((MovableRepresentable) representableFactory.createRepresentation(type,x,y), x, y, w, h,player);

        return gameObject;
    }

}
