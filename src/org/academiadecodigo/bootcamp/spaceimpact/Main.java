package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectFactory;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.ProjectileFactory;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxRepresentableFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        RepresentableFactory representableFactory = new SimpleGfxRepresentableFactory();

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
