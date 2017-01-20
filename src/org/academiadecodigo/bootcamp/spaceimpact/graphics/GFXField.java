package org.academiadecodigo.bootcamp.spaceimpact.graphics;

import org.academiadecodigo.bootcamp.spaceimpact.field.Field;

public class GFXField implements Field {

    int posX;
    int posY;
    int width;
    int height;

    public GFXField(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

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
