package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobjects.MoveDirection;

public interface Movable extends Representable {

    void move(MoveDirection direction);

    void spawn();

    void despawn();

}
