package org.academiadecodigo.bootcamp.spaceimpact.gameobject.init;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObject;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public class SplashScreen extends GameObject {

    private int w;
    private int h;
    private int x;
    private int y;

    public SplashScreen(Representable representation) {
        super(representation);
        this.x = 0;
        this.y = 0;
        this.w = 720;
        this.h = 480;

    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

}
