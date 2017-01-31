package org.academiadecodigo.bootcamp.spaceimpact.simplegfx.init;

import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxRepresentable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxSplash extends SimpleGfxRepresentable implements KeyboardHandler {

    private Keyboard k;
    private boolean started;

    public SimpleGfxSplash(int x, int y) {
        super(new Picture(x, y, "/splashscreens/spaceimpact_screen.png"));
        initializeKeyboard();
    }

    public boolean isStarted() {
        return started;
    }

    public void initializeKeyboard() {

        k = new Keyboard(this);

        KeyboardEvent pressFire = new KeyboardEvent();
        pressFire.setKey(KeyboardEvent.KEY_SPACE);
        pressFire.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(pressFire);

        KeyboardEvent releaseFire = new KeyboardEvent();
        releaseFire.setKey(KeyboardEvent.KEY_SPACE);
        releaseFire.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(releaseFire);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                started = true;
                System.out.println("Pressed Space");
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}