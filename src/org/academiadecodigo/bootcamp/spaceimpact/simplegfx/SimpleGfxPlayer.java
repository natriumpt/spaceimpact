package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxPlayer extends SimpleGfxMovableRepresentable implements KeyboardHandler {

    Keyboard k;

    public SimpleGfxPlayer(int x, int y) {
        super(new Picture(x,y,"playership.png"));
        initializeKeyboard();
    }

    public void initializeKeyboard() {
        k = new Keyboard(this);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_W);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pressUp);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_S);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pressDown);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKey(KeyboardEvent.KEY_A);
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pressLeft);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKey(KeyboardEvent.KEY_D);
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pressRight);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_W:
                this.move(0,-10);
                System.out.println(this.getX());
                System.out.println(this.getY());
                System.out.println("Pressed W");
                break;
            case KeyboardEvent.KEY_S:
                this.move(0,10);
                System.out.println("Pressed S");
                break;
            case KeyboardEvent.KEY_A:
                this.move(-10,0);
                System.out.println("Pressed A");
                break;
            case KeyboardEvent.KEY_D:
                this.move(10,0);
                System.out.println("Pressed D");
                break;



        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
