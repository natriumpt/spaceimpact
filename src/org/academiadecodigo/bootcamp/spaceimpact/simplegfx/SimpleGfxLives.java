package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxLives extends SimpleGfxRepresentable{

    private Player player;
    private int x;
    private int y;
    private Text lives;
    private Picture[] hearts;


    public SimpleGfxLives(Player player){
        this.player = player;
        x = 40;
        y = 20;
    }


    //TODO check the position in X and Y for more reasonable ones
    public void lives(){
        lives = new Text(20,20,"LIFE: ");
        lives.setColor(Color.YELLOW);
        lives.draw();
    }

    //TODO check the position in X and Y for more reasonable ones

    public void getHearts(){
        hearts = new Picture[player.getLives()];
        for (int i = 0; i < hearts.length;i++){
            hearts[i] = new Picture(x*3,y, "heart.png");
            hearts[i].draw();
        }
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
