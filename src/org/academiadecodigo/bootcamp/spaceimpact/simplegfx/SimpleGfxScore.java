package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class SimpleGfxScore extends SimpleGfxRepresentable {

    private Player player;
    private int x;
    private int y;
    private Text score;
    private Text scoreCount;

    public SimpleGfxScore(Player player){
        this.player = player;
        x = 20;
        y = 40;
        score = new Text(x,y, "SCORE: ");
        scoreCount = new Text(x*3,y*3, "" + player.getScore());
    }

    //TODO check the position in X and Y for more reasonable ones
    public void score(){
        score.setColor(Color.YELLOW);
        score.draw();

        scoreCount.setColor(Color.YELLOW);
        scoreCount.setText("" + player.getScore());
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
