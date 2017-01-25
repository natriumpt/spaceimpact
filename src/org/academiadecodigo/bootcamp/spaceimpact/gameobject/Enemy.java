package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Enemy extends Ship {

    ProjectileFactory projectileFactory;
    private int hitPoints;
    private int currentPattern;
    private TargetPosition targetPosition;
    private int [] stepsSmoothing = new int [2];

    public Enemy(Representable representation, int x, int y, ProjectileFactory projectileFactory) {
        super(representation, x, y);
        this.projectileFactory = projectileFactory;
        setHitPoints(3);
        setSpeed(1); // TODO: Change this to reasonable values
        targetPosition = new TargetPosition(100,100);
    }

    public int getHitPoints() {
        return hitPoints;
    }

    private void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
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
        if (super.fireBuffer == 0) {
            projectileFactory.createProjectile(GameObjectType.PROJECTILE, getX(), getY(),false, 100);
            super.fireBuffer = 10;
        }
    }

    @Override
    public void hit() {
        hitPoints--;
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
                stepsCalc(targetPosition.getTargetX(),targetPosition.getTargetY());
                currentPattern++;
                break;
            case 1:
                fire();
                targetPosition.setTargetX(100);
                targetPosition.setTargetY(100);
                stepsCalc(targetPosition.getTargetX(),targetPosition.getTargetY());
                currentPattern++;
                break;
            case 2:
                fire();
                targetPosition.setTargetX(150);
                targetPosition.setTargetY(150);
                stepsCalc(targetPosition.getTargetX(),targetPosition.getTargetY());
                currentPattern++;
                break;
            default:
                System.out.println("Shit");


        }
    }

    public int [] stepsCalc(int targetX , int targetY){
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
            steps =Math.abs(dy);
        }


        xIncrement = dx/steps;
        yIncrement = dy/steps;

        movePattern[0] = xIncrement;
        movePattern[1] = yIncrement;

        return movePattern;

    }

    public boolean inTargetPosition(){
        return (this.getX()==this.targetPosition.getTargetX() && this.getY() == this.targetPosition.getTargetY());
    }


}
