package org.academiadecodigo.bootcamp.spaceimpact.gameobject;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.sound.SoundHandler;

import java.io.IOException;

public class Player extends Ship {

    private ProjectileFactory projectileFactory;
    private SoundHandler soundHandler = new SoundHandler();
    private int fireBuffer;
    private int lives;
    private int score;
    private String playerName;

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

    public void increaseScore(){
        score++;
    }

    public int getScore(){
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

    @Override
    public void fire() {
        if (fireBuffer == 0) {
            projectileFactory.createProjectile(GameObjectType.PROJECTILE, getX() + getW(), getY() + getH() / 2, 16, 4, true, 1, 20);
            try {
                soundHandler.playFire();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fireBuffer = 3;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public String toString() {
        return "Player Position: " + this.getX() + ":" + this.getY();
    }
}
