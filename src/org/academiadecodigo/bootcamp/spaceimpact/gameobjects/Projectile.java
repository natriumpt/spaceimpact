package org.academiadecodigo.bootcamp.spaceimpact.gameobjects;

import org.academiadecodigo.bootcamp.spaceimpact.Movable;

public class Projectile implements Movable {

    private int height;
    private int width;
    private int posX;
    private int posY;
    private int speed;
    private boolean friendly;

    Projectile(int posX, int posY, boolean friendly){
        this.posX = posX;
        this.posY = posY;
        this.width = 10;
        this.height = 2;
        this.speed = 60;
        this.friendly = friendly;
    }


    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void move(MoveDirection direction) {

    }

    @Override
    public void spawn() {

    }

    @Override
    public void despawn() {

    }
}
