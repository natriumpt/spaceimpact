package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        RepresentableFactory representableFactory = null; // = new SimpleGfxRepresentableFactory();

        GameLogic g = new GameLogic(new GameObjectFactory(representableFactory), new ProjectileFactory(representableFactory));
        g.start();


        //projectile testing code

        //        Projectile p = new Projectile(new SimpleGfxPlayer(0,0),true);
//
//        System.out.println(p.getX() + "," + p.getY());
//
//        p.projectileMove(MoveDirection.RIGHT);

    }
}
