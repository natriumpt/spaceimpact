package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.field.Field;
import org.academiadecodigo.bootcamp.spaceimpact.field.FieldFactory;
import org.academiadecodigo.bootcamp.spaceimpact.field.FieldType;
import org.academiadecodigo.bootcamp.spaceimpact.gameobjects.MoveDirection;
import org.academiadecodigo.bootcamp.spaceimpact.gameobjects.Player;

/**
 * Created by betacodecadet on 20/01/17.
 */
public class GameLogic {

    Player player;
    Field field;

    GameLogic(FieldType fieldType){
        field = FieldFactory.makeField(fieldType, 0, 0, 720, 480);
    }

    public void init() {

    }

    public void start() {
        player = new Player(100, 100, 64,32,10,1,3);
        System.out.println(player.getPosX());
        player.move(MoveDirection.RIGHT);
        System.out.println(player.getPosX());

    }

    public void end() {

    }
}
