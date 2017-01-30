package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

/**
 * Created by codecadet on 27/01/17.
 */
public class Pattern {

    private TargetPosition targetPosition;
    private int[] stepsSmoothing = new int[2];

    public Pattern(){
        targetPosition = new TargetPosition();
    }


    public void doPattern(Enemy enemy) {
        // TODO: Implement a pattern for the enemy

        stepsCalc(enemy);

        //System.out.println(targetPosition.getX() + " "+ targetPosition.getY());

        //System.out.println(inTargetPosition(enemy));


        if (!enemy.comparePos(targetPosition)) {
            if( (int)(Math.random()*1000) < 1 ) {
                enemy.fire();
            }
            enemy.move(enemy.getSpeed()*stepsSmoothing[0], enemy.getSpeed() * stepsSmoothing[1]);
            return;
        }

                enemy.fire();
                targetPosition.setX((int)(Math.random()*720));
                targetPosition.setY((int)(Math.random()*480));
                //System.out.println("Calculated a new position");


    }

    public void stepsCalc(Enemy enemy) {

        if (inTargetPosition(enemy)) return;

        int enemyCurX = enemy.getX();
        int enemyCurY = enemy.getY();

        int goalX = targetPosition.getX();
        int goalY = targetPosition.getY();

        int xIncrement;
        int yIncrement;


        int dx = goalX - enemyCurX;
        int dy = goalY - enemyCurY;

        int steps;

        if (Math.abs(dx) >= Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }


        xIncrement = dx / steps;
        yIncrement = dy / steps;

        stepsSmoothing[0] = xIncrement;
        stepsSmoothing[1] = yIncrement;


    }

    public boolean inTargetPosition(Enemy enemy) {
        return (enemy.getX() == this.targetPosition.getX() && enemy.getY() == this.targetPosition.getY());
    }



}
