package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Field;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Player;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Controllable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SimpleGfxKeyboard implements KeyboardHandler, Controllable {

    private Keyboard k;
    private Player player;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean firing;
    private boolean running;

    public SimpleGfxKeyboard(Player player) {
        this.player = player;
        this.running = true;
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

        KeyboardEvent pressFire = new KeyboardEvent();
        pressFire.setKey(KeyboardEvent.KEY_SPACE);
        pressFire.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pressFire);

        KeyboardEvent releaseUp = new KeyboardEvent();
        releaseUp.setKey(KeyboardEvent.KEY_W);
        releaseUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(releaseUp);

        KeyboardEvent releaseDown = new KeyboardEvent();
        releaseDown.setKey(KeyboardEvent.KEY_S);
        releaseDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(releaseDown);

        KeyboardEvent releaseLeft = new KeyboardEvent();
        releaseLeft.setKey(KeyboardEvent.KEY_A);
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(releaseLeft);

        KeyboardEvent releaseRight = new KeyboardEvent();
        releaseRight.setKey(KeyboardEvent.KEY_D);
        releaseRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(releaseRight);

        KeyboardEvent releaseFire = new KeyboardEvent();
        releaseFire.setKey(KeyboardEvent.KEY_SPACE);
        releaseFire.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(releaseFire);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_P);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(quit);

    }

    public boolean isRunning() {
        return running;
    }

    public void controlCycle(Field field) {
        if (up && player.getY() > player.getH() * 2) player.move(0,-player.getSpeed());
        if (down && player.getY() < field.getH() - player.getH() * 1.5) player.move(0,player.getSpeed());
        if (left && player.getX() > player.getW()) player.move(-player.getSpeed(),0);
        if (right && player.getX() < field.getW() - player.getW()) player.move(player.getSpeed(),0);
        if (firing) player.fire();
    }


/*
    public void controlCycle() {
        if (up) player.move(0,-player.getSpeed());
        if (down) player.move(0,player.getSpeed());
        if (left) player.move(-player.getSpeed(),0);
        if (right) player.move(player.getSpeed(),0);
        if (firing) player.fire();
    }
*/

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_W:
                up = true;
                System.out.println("Pressed W");
                break;

            case KeyboardEvent.KEY_S:
                down = true;
                System.out.println("Pressed S");
                break;

            case KeyboardEvent.KEY_A:
                left = true;
                System.out.println("Pressed A");
                break;

            case KeyboardEvent.KEY_D:
                right = true;
                System.out.println("Pressed D");
                break;

            case KeyboardEvent.KEY_SPACE:
                firing = true;
                System.out.println("Pressed Space");
                break;

            case KeyboardEvent.KEY_P:
                running = false;
                System.out.println("Pressed P to running");
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        switch (e.getKey()){
            case KeyboardEvent.KEY_W:
                up = false;
                System.out.println("Released W");
                break;

            case KeyboardEvent.KEY_S:
                down = false;
                System.out.println("Released S");
                break;

            case KeyboardEvent.KEY_A:
                left = false;
                System.out.println("Released A");
                break;

            case KeyboardEvent.KEY_D:
                right = false;
                System.out.println("Released D");
                break;

            case KeyboardEvent.KEY_SPACE:
                firing = false;
                System.out.println("Released Space");
                break;
        }

    }

}
