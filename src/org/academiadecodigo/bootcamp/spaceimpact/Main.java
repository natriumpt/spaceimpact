package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Field;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectFactory;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.MoveDirection;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Projectile;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.RepresentableFactory;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxField;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxMovableRepresentable;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxPlayer;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxRepresentable;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        RepresentableFactory representableFactory = null; // = new SimpleGfxRepresentableFactory();

        GameLogic g = new GameLogic(new GameObjectFactory(representableFactory));
        g.start();


        //projectile testing code

        //        Projectile p = new Projectile(new SimpleGfxPlayer(0,0),true);
//
//        System.out.println(p.getX() + "," + p.getY());
//
//        p.projectileMove(MoveDirection.RIGHT);

    }
}
