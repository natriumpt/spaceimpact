package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Player;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Controllable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SimpleGfxKeyboard implements KeyboardHandler, Controllable {

    private Keyboard k;
    private Player player;

    public SimpleGfxKeyboard(Player player) {
        this.player = player;
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

        KeyboardEvent fire = new KeyboardEvent();
        fire.setKey(KeyboardEvent.KEY_SPACE);
        fire.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(fire);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_W:
                player.move(0, -10);
                System.out.println(player.getX());
                System.out.println(player.getY());
                System.out.println("Pressed W");
                break;

            case KeyboardEvent.KEY_S:
                player.move(0, 10);
                System.out.println("Pressed S");
                break;

            case KeyboardEvent.KEY_A:
                player.move(-10, 0);
                System.out.println("Pressed A");
                break;

            case KeyboardEvent.KEY_D:
                player.move(10, 0);
                System.out.println("Pressed D");
                break;

            case KeyboardEvent.KEY_SPACE:
                player.fire();
                System.out.println("Pressed Space");
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
