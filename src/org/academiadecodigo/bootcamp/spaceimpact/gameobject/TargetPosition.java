package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

/**
 * Created by codecadet on 25/01/17.
 */
public class TargetPosition {

    private int x;
    private int y;


    public TargetPosition() {
        this.x = (int)(Math.random()*720);
        this.y = (int)(Math.random()*480);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
