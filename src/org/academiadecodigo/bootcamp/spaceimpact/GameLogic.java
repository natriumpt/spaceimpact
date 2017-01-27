package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Controllable;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.*;

public class GameLogic {

    private static final int PROJECTILE_LIMIT = 100;
    private static final int ENEMY_LIMIT = 25;
    private GameObjectFactory gameObjectFactory;
    private ProjectileFactory projectileFactory;
    private Controllable controllable;


    public GameLogic(GameObjectFactory gameObjectFactory, ProjectileFactory projectileFactory) {
        this.gameObjectFactory = gameObjectFactory;
        this.projectileFactory = projectileFactory;
    }

    /**
     * The start method instances the required objects and sets motion to the main game logic
     * *
     *
     * @throws InterruptedException
     */

    public void start() throws InterruptedException {

        // TODO: Enemy instance creation, creation pattern rollover

        /*
         * The default objects are instanced;
         */

        Field field = (Field) gameObjectFactory.createObject(GameObjectType.FIELD, 0, 0);
        Player player = (Player) gameObjectFactory.createObject(GameObjectType.PLAYER, field.getW() / 4, field.getH() / 2, 34, 15, projectileFactory);
        Enemy[] enemies = new Enemy[ENEMY_LIMIT];
        Projectile[] projectiles = new Projectile[PROJECTILE_LIMIT];
        projectileFactory.setProjectileArray(projectiles);

        enemies[0] = (Enemy) gameObjectFactory.createObject(GameObjectType.ENEMY, field.getW() - 100, field.getH() / 2, 47, 53, projectileFactory);

        /*
         * The line below checks for SimpleGfx and instances it's KeyboardHandler class.
         * It needs to be changed if another library is implemented.
         */

        if (gameObjectFactory.getRepresentableFactory() instanceof SimpleGfxRepresentableFactory) {
            this.controllable = new SimpleGfxKeyboard(player);
        }

        while (true) {

            /*
              Buffer block goes first, handles player fire rate and input latency
             */
            if (gameObjectFactory.getRepresentableFactory() instanceof SimpleGfxRepresentableFactory) {
                ((SimpleGfxField) field.getRepresentation()).playAnimation();
                ((SimpleGfxRepresentable) player.getRepresentation()).getPicture().delete();
                ((SimpleGfxRepresentable) player.getRepresentation()).getPicture().draw();
                ((SimpleGfxEnemy) enemies[0].getRepresentation()).playAnimation();
            }
            player.decreaseFireBuffer();
            controllable.controlCycle(field);


            // TODO: Create enemy array. Run through all the enemies and order next move/fire command.


            enemies[0].pattern();

            /*
             * The below block handles the projectile collision logic in it's entirety (movement && collision)
             */

            for (Projectile projectile : projectiles) { // iterates through projectile array
                if (projectile != null) {               // ignores the index if the object is null
                    if (!projectile.isDestroyed()) {
                        projectile.projectileMove();        // orders all projectiles to move to next step
                        if (!projectile.isFriendly() && projectile.comparePos(player)) { // collision check
                            player.hit(projectile.getDamage()); // damage value is applied to hit() method
                            projectile.destroy();               // destroys projectile
                        }
                        for (Enemy enemy : enemies) {   // iterates through enemy array
                            if (enemy != null) {        // ignores the index if the object is null
                                if (projectile.isFriendly() && projectile.comparePos(enemy)) { // collision check
                                    enemy.hit(projectile.getDamage());  // damage value applied to hit() method
                                    player.increaseScore();             // player score increased
                                    projectile.destroy();               // destroys projectile
                                }
                            }
                        }
                        if (projectile.outOfBounds(field)) {    // checks if the projectile is out of bounds
                            projectile.destroy();               // destroys projectile
                        }
                    }
                }
            }

            Thread.sleep(33); // pauses the thread for 33 ms (for achieving 30fps)
        }

    }

}
