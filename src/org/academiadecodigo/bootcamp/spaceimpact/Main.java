package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectFactory;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        RepresentableFactory representableFactory = null; // = new SimpleGfxRepresentableFactory();

        GameLogic g = new GameLogic(new GameObjectFactory(representableFactory));
        g.start();

    }
}
