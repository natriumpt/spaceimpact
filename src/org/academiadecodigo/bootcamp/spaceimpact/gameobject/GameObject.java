package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;

public abstract class GameObject {

    private Representable representation;
    private int x;
    private int y;

    public Representable getRepresentation() {
        return representation;
    }

    public GameObject(Representable representation) {
        this.representation = representation;
    }


}
