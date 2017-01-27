package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

/**
 * Created by codecadet on 25/01/17.
 */
public class TargetPosition {

    private int x;
    private int y;


    public TargetPosition(int x, int y) {
        this.x = x;
        this.y = y;
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
