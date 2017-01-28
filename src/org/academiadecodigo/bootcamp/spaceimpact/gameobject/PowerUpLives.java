package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.MovableRepresentable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

/**
 * Created by codecadet on 1/28/17.
 */
public class PowerUpLives extends PowerUp {

    private Player player;
    private boolean destroyed;


    public PowerUpLives(MovableRepresentable representation, int x, int y, int w, int h, Player player){
        super(representation, x,y,w,h);
        this.player = player;
        setX(x);
        setY(y);
        setW(w);
        setH(h);
    }

    @Override
    public void setPoints() {
        player.increaseLives();
    }

    public void destroy() {
        super.destroy();
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
