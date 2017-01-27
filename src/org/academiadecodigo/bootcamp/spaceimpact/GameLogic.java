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

    /*
     * Start game method
     */

    public void start() throws InterruptedException {

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

            fieldLogic(field, player);
            playerLogic(field, player);
            enemyLogic(enemies);
            projectileLogic(field, player, enemies, projectiles);

            Thread.sleep(33);

        }

    }

    private void fieldLogic(Field field, Player player) {
        if (gameObjectFactory.getRepresentableFactory() instanceof SimpleGfxRepresentableFactory) {
            ((SimpleGfxField) field.getRepresentation()).playAnimation();
            ((SimpleGfxRepresentable) player.getRepresentation()).getPicture().delete();
            ((SimpleGfxRepresentable) player.getRepresentation()).getPicture().draw();
        }
    }

    /*
        Player logic
     */
    private void playerLogic(Field field, Player player) {

        if(!player.isDestroyed()) {

            player.decreaseFireBuffer();
            player.decreaseRespawnTimer();
            controllable.controlCycle(field);

            if (player.getHitPoints() <= 0) {

                player.destroy();
                player.decreaseLives();
                player.respawn(); // Still has no code

                if (player.getLives() <= 0){

                    //gameover();
                }

            }

        }

    }



    /*
     * Enemy logic
     */
    private void enemyLogic(Enemy[] enemies) {
        for (Enemy enemy : enemies) {


            if (enemy != null) {
                if (!enemy.isDestroyed()) {
                    // TODO: Enemy behaviour
                    ((SimpleGfxEnemy) enemy.getRepresentation()).playAnimation();
                    System.out.println(enemy);

                    if (enemy.getHitPoints() <= 0) {

                        enemy.destroy();

                    }
                }
            }
        }
    }

    /*
     * Projectile and collision
     */
    private void projectileLogic(Field field, Player player, Enemy[] enemies, Projectile[] projectiles) {
        for (Projectile projectile : projectiles) {
            if (projectile != null) {
                if (!projectile.isDestroyed()) {
                    projectile.projectileMove();
                    if (!projectile.isFriendly() && projectile.comparePos(player)) {
                        player.hit(projectile.getDamage());
                        projectile.destroy();
                    }
                    for (Enemy enemy : enemies) {
                        if (enemy != null) {
                            if (projectile.isFriendly() && projectile.comparePos(enemy)) {
                                enemy.hit(projectile.getDamage());
                                player.increaseScore();
                                projectile.destroy();
                            }
                        }
                    }
                    if (projectile.outOfBounds(field)) {
                        projectile.destroy();
                    }
                }
            }
        }
    }

}
