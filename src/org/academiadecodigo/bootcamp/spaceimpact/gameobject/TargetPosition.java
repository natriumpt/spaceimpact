package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

/**
 * Created by codecadet on 25/01/17.
 */
public class TargetPosition {

    private int targetX;
    private int targetY;


    public TargetPosition(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public int getTargetX() {
        return targetX;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }
}
