package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Controllable;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxKeyboard;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.SimpleGfxRepresentableFactory;

public class GameLogic {

    private static final int PROJECTILE_LIMIT = 100;
    private static final int ENEMY_LIMIT = 25;
    private GameObjectFactory gameObjectFactory;
    private ProjectileFactory projectileFactory;
    private Controllable controllable;
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
        field = (Field) gameObjectFactory.createObject(GameObjectType.FIELD, 0, 0);
        player = (Player) gameObjectFactory.createObject(GameObjectType.PLAYER, field.getW() / 4, field.getH() / 2, 34, 15, projectileFactory);
        enemies = new Enemy[ENEMY_LIMIT];
        projectiles = new Projectile[PROJECTILE_LIMIT];
        projectileFactory.setProjectileArray(projectiles);

        if (gameObjectFactory.getRepresentableFactory() instanceof SimpleGfxRepresentableFactory) {
            this.controllable = new SimpleGfxKeyboard(this.player);
        }

        while (true) {

            /* Each cycle of our game (1/30th of a second) will run one iteration of the behaviour of all non-player
                objects */

            // TODO: Implement methods to run in each cycle

            // TODO: Lower player movement/firing buffer cooldowns until 0;
            player.decreaseFireBuffer();
            controllable.controlCycle(field);

            // TODO: Create enemy array. Run through all the enemies and order next move/fire command.

            /*
            for (Enemy e : enemies) {
                e.nextPatternStepCycle?
                e.moveToTarget;
            }
            */

            // TODO: Create projectile array. Run through all projectile and order next move command.

            // TODO: Collision detection

            for (Projectile projectile : projectiles) {
                if (projectile != null) {
                    projectile.projectileMove();
                    if (!projectile.isFriendly() && projectile.comparePos(player)) {
                        player.hit(projectile.getDamage());
                        projectile.destroy();
                    }
                    for (Enemy enemy : enemies) {
                        if (enemy != null) {
                            if (projectile.isFriendly() && projectile.comparePos(enemy)) {
                                enemy.hit(projectile.getDamage());
                                projectile.destroy();
                            }
                        }
                    }
                    if (projectile.outOfBounds(field)) {
                        projectile.destroy();
                    }
                }
            }

            Thread.sleep(33); // Pauses the thread every 1/30th of a second
        }

    }

//    // TODO: this should be checked by the collision detector
//    public boolean checkFieldLimits(Projectile p) {
//
//        int fieldHeight = 420; //TODO: alterar estes magic numbers, isto é só para testes
//        int fieldWidth = 800;
//        boolean projectileOutOfBounds = false;
//
//
//        if (p.getX() < 0 || p.getX() > fieldWidth || p.getY() > fieldHeight || p.getY() < 0) {
//            System.out.println("Projectile out of bounds"); //do something instead of sout
//            projectileOutOfBounds = true;
//        }
//
//        return projectileOutOfBounds;
//
//    }

}
