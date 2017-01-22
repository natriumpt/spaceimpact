package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class GameLogic {

    private GameObjectFactory gameObjectFactory;

    public GameLogic(GameObjectFactory gameObjectFactory) {
        this.gameObjectFactory = gameObjectFactory;
    }

    public void start() throws InterruptedException{
        // GameObject player = gameObjectFactory.createObject(GameObjectType.PLAYER);
        System.out.println("Start");

        GameObject player = new Player(null);


        //GameObject enemy = gameObjectFactory.createObject(GameObjectType.ENEMY);
//        GameObject enemy = new Enemy(null);

//        while(true){
//            ((Enemy) enemy).enemyMove(200,200);
//            Thread.sleep(32);
//            ((Enemy) enemy).enemyMove(400,150);
//            Thread.sleep(32);
//            ((Enemy) enemy).enemyMove(150,600);
//            Thread.sleep(32);
//        }
    }


}
