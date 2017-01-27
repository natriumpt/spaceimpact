package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Enemy extends Ship {

    private ProjectileFactory projectileFactory;
    private TargetPosition targetPosition;
    private int currentPattern;
    private int[] stepsSmoothing = new int[2];

    public Enemy(Representable representation, int x, int y, int w, int h, ProjectileFactory projectileFactory) {
        super(representation, x, y, w, h);
        this.projectileFactory = projectileFactory;
        setHitPoints(3);
        setSpeed(4); // TODO: Change this to reasonable values
        targetPosition = new TargetPosition(600, 260);
    }

    public void enemyMove(int x, int y) {
        // TODO: Change this to ensure more realistic diagonal movement
        if (getX() != x || getY() != y) {
            System.out.println("Position is different");
            if (getX() > x) {
                System.out.println("Position greater than target");
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
        projectileFactory.createProjectile(GameObjectType.PROJECTILE, getX(), getY(), 16, 4, false, 1, 16);
    }

    public void newPattern() {
        switch (currentPattern) {
            case 0:
                if (getX() != 50 && getY() != 50) {
                    enemyMove(50, 50);
                    System.out.println("Attempting move 50 50");
                } else {
                    fire();
                    System.out.println("Attempting fire");
                    currentPattern = 1;
                }
            case 1:
                if (getX() != 1000 && getY() != 200) {
                    enemyMove(1000, 200);
                } else {
                    fire();
                    currentPattern = 0;
                }
        }
    }

    public void pattern() {
        // TODO: Implement a pattern for the enemy

        stepsCalc();

        System.out.println(inTargetPosition());
        System.out.println(currentPattern);


        //if (!inTargetPosition()) {
        if (!this.comparePos(targetPosition)) {
            move(getSpeed() * stepsSmoothing[0], getSpeed() * stepsSmoothing[1]);
            return;
        }

        switch (currentPattern) {

            case 0:
                targetPosition.setX(600);
                targetPosition.setY(240);
                System.out.println("Did case 0 ");
                currentPattern++;
                break;
            case 1:
                targetPosition.setX(360);
                targetPosition.setY(50);
                System.out.println("Did case 1 ");
                currentPattern++;
                break;
            case 2:
                targetPosition.setX(50);
                targetPosition.setY(240);
                currentPattern++;
                System.out.println("Did case 2 ");
                break;
            case 3:
                targetPosition.setX(360);
                targetPosition.setY(400);
                currentPattern++;
                System.out.println("Did case 3");
                currentPattern = 0;
                break;
            default:
                System.out.println("Shit");


        }
    }

    public void stepsCalc() {

        if (inTargetPosition()) return;

        int enemyCurX = getX();
        int enemyCurY = getY();

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

    public boolean inTargetPosition() {
        return (this.getX() == this.targetPosition.getX() && this.getY() == this.targetPosition.getY());
    }

    @Override
    public String toString() {
        return "Enemy " + getX() + " " + getY() + " HP:" + getHitPoints();
    }
}
