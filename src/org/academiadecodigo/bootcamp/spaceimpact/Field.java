package org.academiadecodigo.bootcamp.spaceimpact;

public class Field implements Representable {

    int posX;
    int posY;
    int width;
    int height;

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
