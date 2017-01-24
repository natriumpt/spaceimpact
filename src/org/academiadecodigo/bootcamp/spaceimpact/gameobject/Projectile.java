package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Projectile extends MovableGameObject {

    private boolean friendly;
    private int speed;

    public Projectile(Representable representation, Boolean friendly) {
        super(representation);
        this.friendly = friendly;
        this.speed = 10;
    }

    public void projectileMove(MoveDirection moveDirection){

        switch (moveDirection){

            case RIGHT:
                move(speed,0);
                break;
            case LEFT:
                move(-speed,0);
                break;
            default:
                System.out.println("Shit happened");

        }

    }

    public Boolean friendly(){
        return friendly;
    }




}
