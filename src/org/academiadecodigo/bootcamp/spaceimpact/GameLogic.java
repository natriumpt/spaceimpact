package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;

public class GameLogic {

    private GameObjectFactory gameObjectFactory;

    private Player player;
    private Enemy[] enemies;
    private Projectile[] projectiles;
    private Field field;

    private int enemyLimit;
    private int projectileCounter;
    private int projectileLimit;


    public GameLogic(GameObjectFactory gameObjectFactory) {
        this.gameObjectFactory = gameObjectFactory;
    }


    public void start() throws InterruptedException {

        // TODO: Create instances for permanent objects (i.e. player, field)

        /* The below declarations are not final
        * Missing initialization properties for player && field
        */

        player = (Player) gameObjectFactory.createObject(GameObjectType.PLAYER);
        field = (Field) gameObjectFactory.createObject(GameObjectType.FIELD);
        enemies = new Enemy[enemyLimit];
        projectiles = new Projectile[projectileLimit];


        while (true) {

            /* Each cycle of our game (1/30th of a second) will run one iteration of the behaviour of all non-player
                objects */

            // TODO: Implement methods to run in each cycle

            // TODO: Lower player movement/firing buffer cooldowns until 0;
            player.decreaseFireBuffer();

            // TODO: Create enemy array. Run through all the enemies and order next move command.

            /*
            for (Enemy e : enemies) {
                e.nextPatternStepCycle?
                e.moveToTarget;
            }
            */

            // TODO: Create projectile array. Run through all projectile and order next move command.

            /*
            for (Projectile p : projectiles) {
                p.moveToTarget;
            }
            */


            Thread.sleep(33); // Pauses the thread every 1/30th of a second
        }

    }

    public void addProjectile(Projectile projectile) {
        projectiles[projectileCounter] = projectile;
        projectileCounter++;
    }

}
