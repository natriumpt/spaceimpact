package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.*;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Controllable;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.representable.Representable;
import org.academiadecodigo.bootcamp.spaceimpact.simplegfx.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameLogic {

    private static final int PROJECTILE_LIMIT = 100;
    private static final int ENEMY_LIMIT = 3;
    private static final int POWERUP_LIMIT = 2;
    private GameObjectFactory gameObjectFactory;
    private ProjectileFactory projectileFactory;
    private Controllable controllable;
    private Enemy[] enemies;
    private PowerUp[] powerUps;
    private Field field;
    private Player player;
    private Representable score;
    private Representable lives;
    private int enemieRespawnTimer = 0;


    public GameLogic(GameObjectFactory gameObjectFactory, ProjectileFactory projectileFactory) {
        this.gameObjectFactory = gameObjectFactory;
        this.projectileFactory = projectileFactory;
        enemies = new Enemy[ENEMY_LIMIT];
        powerUps = new PowerUp[POWERUP_LIMIT];
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
            this.lives = new SimpleGfxLives(player);
            this.score = new SimpleGfxScore(player);
        }

        while (controllable.isRunning()) {

            //screenLabels();
            createPowerUps();
            createEnemies();
            fieldLogic(field, player);
            playerLogic(field, player);
            enemyLogic(enemies);
            powerUpLogic(powerUps, player);
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

    public void createPowerUps() {

        for (int i = 0; i < POWERUP_LIMIT; i++) {

            if (powerUps[i] == null || powerUps[i].isDestroyed()) {

                int minX = field.getW() / 2;
                int posX = randomPosition(minX, field.getW() - 20);
                int posY = randomPosition(20, field.getH() - 40);

                if (player.getX() != posX && player.getY() != posY) {

                    for (int j = 0; j < POWERUP_LIMIT; j++) {
                        if (powerUps[j] != null && !powerUps[j].isDestroyed()) {
                            if (powerUps[j].getX() != posX && powerUps[j].getY() != posY) {
                                powerUps[i] = (PowerUp) gameObjectFactory.createPowerUp(GameObjectType.POWERUP, posX, posY, 47, 53, player);
                                return;
                            }
                        }
                    }

                    if (powerUps[i] == null || powerUps[i].isDestroyed()) {
                        powerUps[i] = (PowerUp) gameObjectFactory.createPowerUp(GameObjectType.POWERUP, posX, posY, 47, 53, player);
                        return;
                    }
                }
            }
        }
    }


    public int randomPosition(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));

    }

    /*
        Player logic
     */
    private void playerLogic(Field field, Player player) {

        if (player.getLives() > 0) {


            player.decreaseFireBuffer();
            controllable.controlCycle(field);

            if (player.isDestroyed()) {
                player.decreaseRespawnTimer();
                player.hasControl();

            }

            if (player.getHitPoints() <= 0) {

                player.destroy();
                player.decreaseLives();
                player.respawn();

            }

            // show player/score
            // setScore in the shistory.txt file
            //gameOver();

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
                    ((SimpleGfxEnemy) enemy.getRepresentation()).playAnimation(); // TODO: instance of SimpleGfx needed
                    enemy.updatePattern(enemy);

                    if (player.comparePos(enemy)) {
                        player.destroy();
                        if(player.getLives()>0) {
                            player.decreaseLives();
                            player.respawn();
                        }
                        enemy.destroy();

                    }

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

                }
                if (projectile.outOfBounds(field)) {
                    projectile.destroy();
                }
            }
        }

    }

    public void screenLabels() { //to represent the labels of the score and lives

        if (gameObjectFactory.getRepresentableFactory() instanceof SimpleGfxRepresentableFactory) {
            ((SimpleGfxScore) score).score();
            ((SimpleGfxLives) lives).lives();
            ((SimpleGfxLives) lives).getHearts();
        }


    }


    /* Power Up
     *
     */

    private void powerUpLogic(PowerUp[] powerUps, Player player) {
        for (PowerUp powerUp : powerUps) {

            if (powerUp != null) {
                if (!powerUp.isDestroyed()) {
                    ((SimpleGfxPowerUp) powerUp.getRepresentation()).playAnimation();
                    //usar update pattern do enemy do tiago?
                    if (player.comparePos(powerUp)) {
                        powerUp.destroy();
                        player.increaseLives();
                    }
                }
            }

        }

    }

    /*
     * Init
     */

    public void init() throws InterruptedException {
        SimpleGfxInit init = new SimpleGfxInit(0, 0);
        init.playAnimationDraw();
        Thread.sleep(2000);
        init.playAnimationDelete();
    }


}
