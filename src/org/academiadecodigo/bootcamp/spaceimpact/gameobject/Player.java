package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.MovableRepresentable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class Player extends Ship {

    private ProjectileFactory projectileFactory;
    private int fireBuffer;
    private int respawnTimer;
    private int lives;
    private int score;
    private String playerName;
    private boolean destroyed;
    private boolean control = true;

    public Player(Representable representation, int x, int y, int w, int h, ProjectileFactory projectileFactory) {
        super(representation, x, y, w, h);
        this.projectileFactory = projectileFactory;
        setHitPoints(3);
        setLives(3);
        setSpeed(8); // TODO: change this to a more reasonable value
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public void increaseLives() {
        lives++;
    }

    public void decreaseLives() {
        lives--;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void decreaseFireBuffer() {
        if (fireBuffer > 0) fireBuffer--;
    }

    public void decreaseRespawnTimer(){
        if (respawnTimer > 0) {
            respawnTimer--;
        }
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    public boolean hasControl() {
        return respawnTimer == 0;
    }

    public void respawn() {
        respawnTimer = 66;
        moveTo(720 / 4, 480 / 2);
        ((MovableRepresentable) getRepresentation()).respawn();
        setHitPoints(3);
    }

    @Override
    public void fire() {
        if (fireBuffer == 0) {
            projectileFactory.createProjectile(GameObjectType.PROJECTILE, getX() + getW(), getY() + getH() / 4, 16, 4, 1, 20);
            fireBuffer = 3;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void moveTo(int x, int y) {

        move(x - getX(), y - getY());

    }

    @Override
    public String toString() {
        return "Player Position: " + this.getX() + ":" + this.getY();
    }
}
