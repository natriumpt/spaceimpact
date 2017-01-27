package org.academiadecodigo.bootcamp.spaceimpact.gameobject;

import java.io.*;
import java.security.PublicKey;

import static java.lang.System.in;

/**
 * Created by filipe on 26-01-2017.
 */
public class HighScore {

    //TODO: Assigned to Branco

    Player player;

    public HighScore(Player player){
        this.player = player;
    }


    public void isHighscore(int score) throws IOException{
         FileInputStream inputStream = new FileInputStream("highscores.txt");;

         byte[] buffer = new byte[1024]; //nova linha
         int line = inputStream.read(buffer);

         // hashmap key value

         while (line != '\0'){

         }


         inputStream.close();
    }


    public void setHighScore(){

    }


}
