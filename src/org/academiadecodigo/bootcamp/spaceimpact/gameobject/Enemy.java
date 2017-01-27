package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Enemy extends Ship {

    private ProjectileFactory projectileFactory;
    private TargetPosition targetPosition;
    private int currentPattern;
    private int[] stepsSmoothing = new int[2];
    private boolean destroyed;

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

        if (!inTargetPosition()) {
            move(getSpeed() * stepsSmoothing[0], getSpeed() * stepsSmoothing[1]);
        }

        switch (currentPattern) {

            case 0:
                fire();
                targetPosition.setTargetX(50);
                targetPosition.setTargetY(50);
                stepsCalc(targetPosition.getTargetX(), targetPosition.getTargetY());
                // currentPattern++;
                break;
            case 1:
                fire();
                targetPosition.setTargetX(100);
                targetPosition.setTargetY(100);
                stepsCalc(targetPosition.getTargetX(), targetPosition.getTargetY());
                currentPattern++;
                break;
            case 2:
                fire();
                targetPosition.setTargetX(150);
                targetPosition.setTargetY(150);
                stepsCalc(targetPosition.getTargetX(), targetPosition.getTargetY());
                currentPattern++;
                break;
            default:
                System.out.println("Shit");


        }
    }

    public int[] stepsCalc(int targetX, int targetY) {
        int enemyCurX = getX();
        int enemyCurY = getY();

        int goalX = targetPosition.getTargetX();
        int goalY = targetPosition.getTargetY();

        int xIncrement;
        int yIncrement;

        int movePattern[] = new int[2];

        int dx = goalX - enemyCurX;
        int dy = goalY - enemyCurY;

        int steps;

        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }


        xIncrement = dx / steps;
        yIncrement = dy / steps;

        movePattern[0] = xIncrement;
        movePattern[1] = yIncrement;

        return movePattern;

    }

    public boolean inTargetPosition() {
        return (this.getX() == this.targetPosition.getTargetX() && this.getY() == this.targetPosition.getTargetY());
    }

    public void destroy() {
        super.destroy();
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }


    @Override
    public String toString() {
        return "Enemy " + getX() + " " + getY() + " HP:" + getHitPoints();
    }
}
