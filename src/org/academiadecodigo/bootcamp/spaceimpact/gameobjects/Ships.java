package org.academiadecodigo.bootcamp.spaceimpact.gameobjects;

import org.academiadecodigo.bootcamp.spaceimpact.Movable;

abstract public class Ships implements Movable {

    private int hitPoints;
    private int height;
    private int width;
    private int posX;
    private int posY;
    private int speed;

    public Ships(int posX, int posY, int width, int height, int speed, int hitPoints) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.hitPoints = hitPoints;
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

    public int getHitPoints() {
        return hitPoints;
    }

    public int getSpeed() {
        return speed;
    }

    abstract public void fire();

    abstract public void hit();

}
