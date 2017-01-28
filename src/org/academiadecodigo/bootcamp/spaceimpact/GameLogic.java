package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Controllable;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.*;

public class GameLogic {

    private static final int PROJECTILE_LIMIT = 100;
    private static final int ENEMY_LIMIT = 3;
    private GameObjectFactory gameObjectFactory;
    private ProjectileFactory projectileFactory;
    private Controllable controllable;
    private Enemy[] enemies;
    private Field field;
    private Player player;
    private int enemieRespawnTimer = 0;


    public GameLogic(GameObjectFactory gameObjectFactory, ProjectileFactory projectileFactory) {
        this.gameObjectFactory = gameObjectFactory;
        this.projectileFactory = projectileFactory;
        enemies = new Enemy[ENEMY_LIMIT];
        field = (Field) gameObjectFactory.createObject(GameObjectType.FIELD, 0, 0);
        player = (Player) gameObjectFactory.createObject(GameObjectType.PLAYER, field.getW() / 4, field.getH() / 2, 34, 15, projectileFactory);
    }

    /*
     * Start game method
     */


    public void start() throws InterruptedException {

        /*
         * The default objects are instanced;
         */

        Projectile[] projectiles = new Projectile[PROJECTILE_LIMIT];
        projectileFactory.setProjectileArray(projectiles);
        /*
         * The line below checks for SimpleGfx and instances it's KeyboardHandler class.
         * It needs to be changed if another library is implemented.
         */

        if (gameObjectFactory.getRepresentableFactory() instanceof SimpleGfxRepresentableFactory) {
            this.controllable = new SimpleGfxKeyboard(player);
        }

        while (controllable.isRunning()) {

            createEnemies();
            fieldLogic(field, player);
            playerLogic(field, player);
            enemyLogic(enemies);
            projectileLogic(field, player, enemies, projectiles);

            Thread.sleep(33);

        }

        System.exit(0);

    }

    private void fieldLogic(Field field, Player player) {
        if (gameObjectFactory.getRepresentableFactory() instanceof SimpleGfxRepresentableFactory) {
            ((SimpleGfxField) field.getRepresentation()).playAnimation();
            ((SimpleGfxRepresentable) player.getRepresentation()).getPicture().delete();
            ((SimpleGfxRepresentable) player.getRepresentation()).getPicture().draw();
        }
    }

    public void createEnemies() {

        if (enemieRespawnTimer == 0) {

            for (int i = 0; i < ENEMY_LIMIT; i++) {

                if (enemies[i] == null || enemies[i].isDestroyed()) {

                    int minX = field.getW() / 2;
                    int posX = randomPosition(minX, field.getW() - 20); //to avoid enemies spawn outside of the field
                    int posY = randomPosition(20, field.getH() - 40);   //to avoid enemies spawn outside of the field

                    if (player.getX() != posX && player.getY() != posY) {

                        for (int j = 0; j < ENEMY_LIMIT; j++) {
                            if (enemies[j] != null && !enemies[j].isDestroyed()) {
                                if (enemies[j].getX() != posX && enemies[j].getY() != posY) {

                                    enemies[i] = (Enemy) gameObjectFactory.createObject(GameObjectType.ENEMY, posX, posY, 47, 53, projectileFactory);
                                    return;
                                }
                            }
                        }

                        if (enemies[i] == null || enemies[i].isDestroyed()) {
                            enemies[i] = (Enemy) gameObjectFactory.createObject(GameObjectType.ENEMY, posX, posY, 47, 53, projectileFactory);
                            return;
                        }
                    }
                }
            }
            enemieRespawnTimer = 100;
        }
        enemieRespawnTimer--;
    }

    public int randomPosition(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));

    }

    /*
        Player logic
     */
    private void playerLogic(Field field, Player player) {

        if (!player.isDestroyed()) {

            player.decreaseFireBuffer();
            player.decreaseRespawnTimer();
            controllable.controlCycle(field);

            if (player.getHitPoints() <= 0) {

                player.destroy();
                player.decreaseLives();
                player.respawn(); // Still has no code

                if (player.getLives() <= 0) {

                    // show player/score
                    // setScore in the shistory.txt file
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
                    enemy.updatePattern(enemy);

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
