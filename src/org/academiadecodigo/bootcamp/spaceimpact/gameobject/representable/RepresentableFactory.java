package org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.GameObjectType;

public interface RepresentableFactory {

    Representable createRepresentation(GameObjectType type, int x, int y);

}
