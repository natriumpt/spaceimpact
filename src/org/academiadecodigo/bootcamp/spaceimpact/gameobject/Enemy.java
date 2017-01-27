package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Enemy extends Ship {

    ProjectileFactory projectileFactory;
    private int currentPattern;
    private TargetPosition targetPosition;
    private int [] stepsSmoothing = new int [2];

    public Enemy(Representable representation, int x, int y, int w, int h, ProjectileFactory projectileFactory) {
        super(representation, x, y, w, h);
        this.projectileFactory = projectileFactory;
        setHitPoints(3);
        setSpeed(4); // TODO: Change this to reasonable values
        targetPosition = new TargetPosition(100,100);
    }

    public void enemyMove(int x, int y) {
        // TODO: Change this to ensure more realistic diagonal movement
        if (getX() != x || getY() != y) {
            if (getX() > x) {
                move(-getSpeed(), 0);
            }
            if (getX() < x) {
                move(getSpeed(), 0);
            }
            if (getY() > y) {
                move(0, -getSpeed());
            }
            if (getY() < y) {
                move(0, getSpeed());
            }
        }
    }

    @Override
    public void fire() {
        projectileFactory.createProjectile(GameObjectType.ENEMYPROJECTILE, getX(), getY(), 16, 4, false, 1, 30);
    }

    public void pattern() {
        // TODO: Implement a pattern for the enemy

        if (!inTargetPosition()){
            move(getSpeed()*stepsSmoothing[0],getSpeed()*stepsSmoothing[1]);
        }

        switch (currentPattern){

            case 0:
                fire();
                targetPosition.setTargetX(50);
                targetPosition.setTargetY(50);
                stepsCalc();
                currentPattern++;
                break;
            case 1:
                fire();
                targetPosition.setTargetX(100);
                targetPosition.setTargetY(100);
                stepsCalc();
                currentPattern++;
                break;
            case 2:
                fire();
                targetPosition.setTargetX(150);
                targetPosition.setTargetY(150);
                stepsCalc();
                currentPattern = 0;
                break;
            default:
                System.out.println("Shit");


        }
    }

    public void stepsCalc(){
        int enemyCurX = getX();
        int enemyCurY = getY();

        int goalX = targetPosition.getTargetX();
        int goalY = targetPosition.getTargetY();

        int xIncrement;
        int yIncrement;

        int movePattern [] =  new int[2];

        int dx = goalX - enemyCurX;
        int dy = goalY - enemyCurY;

        int steps;

        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }


        xIncrement = dx/steps;
        yIncrement = dy/steps;

        stepsSmoothing[0] = xIncrement;
        stepsSmoothing[1] = yIncrement;

    }

    public boolean inTargetPosition(){
        return (this.getX()==this.targetPosition.getTargetX() && this.getY() == this.targetPosition.getTargetY());
    }


}
