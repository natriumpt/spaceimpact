package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;

public class GameLogic {

    private static final int PROJECTILE_LIMIT = 100;
    private static final int ENEMY_LIMIT = 25;
    private GameObjectFactory gameObjectFactory;
    private ProjectileFactory projectileFactory;
    private Player player;
    private Enemy[] enemies;
    private Projectile[] projectiles;
    private Field field;


    public GameLogic(GameObjectFactory gameObjectFactory, ProjectileFactory projectileFactory) {
        this.gameObjectFactory = gameObjectFactory;
        this.projectileFactory = projectileFactory;
    }


    public void start() throws InterruptedException {

        // TODO: Create instances for permanent objects (i.e. player, field)

        /* The below declarations are not final
            Missing initialization properties for player && field */

        player = (Player) gameObjectFactory.createObject(GameObjectType.PLAYER, projectileFactory);
        field = (Field) gameObjectFactory.createObject(GameObjectType.FIELD);
        enemies = new Enemy[ENEMY_LIMIT];
        projectiles = new Projectile[PROJECTILE_LIMIT];
        projectileFactory.setProjectileArray(projectiles);

        while (true) {

            /* Each cycle of our game (1/30th of a second) will run one iteration of the behaviour of all non-player
                objects */

            // TODO: Implement methods to run in each cycle

            // TODO: Lower player movement/firing buffer cooldowns until 0;
            player.decreaseFireBuffer();

            // TODO: Create enemy array. Run through all the enemies and order next move/fire command.

            /*
            for (Enemy e : enemies) {
                e.nextPatternStepCycle?
                e.moveToTarget;
            }
            */

            // TODO: Create projectile array. Run through all projectile and order next move command.
            // Projectile move logic should be inherited from the creator of the object (Player v. Enemy)

            for (Projectile p : projectiles) {

                if (!checkFieldLimits(p)) {
                    if (p.isFriendly()) {
                        p.projectileMove(MoveDirection.RIGHT);
                    } else {
                        p.projectileMove(MoveDirection.LEFT);
                    }
                }
            }

            // TODO: Collision detection

            Thread.sleep(33); // Pauses the thread every 1/30th of a second
        }

    }

    // TODO: this should be checked by the collision detector
    public boolean checkFieldLimits(Projectile p) {

        int fieldHeight = 420; //TODO: alterar estes magic numbers, isto é só para testes
        int fieldWidth = 800;
        boolean projectileOutOfBounds = false;

        if (p.getX() < 0 || p.getX() > fieldWidth || p.getY() > fieldHeight || p.getY() < 0) {
            System.out.println("Projectile out of bounds"); //do something instead of sout
            projectileOutOfBounds = true;
        }

        return projectileOutOfBounds;

    }

}
