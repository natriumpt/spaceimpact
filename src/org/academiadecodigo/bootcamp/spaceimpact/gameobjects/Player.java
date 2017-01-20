package org.academiadecodigo.bootcamp.spaceimpact.gameobjects;

public class Player extends Ships {

    private int lives;
    private int score;

    public Player(int posX, int posY, int width, int height, int speed, int hitPoints, int lives) {
        super(posX, posY, width, height, speed, hitPoints);
        this.lives = lives;
    }


    @Override
    public void move(MoveDirection direction) {
        switch (direction) {
            case UP:
                setPosY(getPosY() - getSpeed());
                break;
            case DOWN:
                setPosY(getPosY() + getSpeed());
                break;
            case LEFT:
                setPosX(getPosX() - getSpeed());
                break;
            case RIGHT:
                setPosX(getPosX() + getSpeed());
                break;
        }
    }

    @Override
    public void spawn() {

    }

    @Override
    public void despawn() {

    }

    @Override
    public void fire() {

    }

    @Override
    public void hit() {

    }
}
