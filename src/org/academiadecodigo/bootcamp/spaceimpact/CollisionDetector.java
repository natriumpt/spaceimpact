package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Enemy;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Player;
import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Projectile;

/**
 * Created by codecadet on 1/25/17.
 */
public class CollisionDetector {

    private Player player;
    private Enemy[] enemies;
    private Projectile[] projectiles;

    public CollisionDetector(Player player, Enemy[] enemies, Projectile[] projectiles) {

        this.player = player;
        this.enemies = enemies;
        this.projectiles = projectiles;

    }


    public void checkCollisions(Player player, Enemy[] enemies, Projectile[] projectiles) {

        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                player.destroy();
                enemy.destroy();
            }
        }

        for (Projectile projectile : projectiles) {
            if (!projectile.isFriendly() && projectile.getX() == player.getX() && projectile.getY() == player.getY()) {
                player.destroy();
                projectile.destroy();
            }
        }

        for (Projectile projectile : projectiles) {

            for (Enemy enemy : enemies) {

                if (projectile.isFriendly() && projectile.getX() == enemy.getX() && projectile.getY() == enemy.getY()) {
                    enemy.destroy();
                    projectile.destroy();

                }

            }

        }

    }

}
