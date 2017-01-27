package org.academiadecodigo.bootcamp.spaceimpact;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Player;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Score {

    //TODO: Assigned to Branco

    Player player;

    public Score(Player player){
        this.player = player;
    }


    public Score(Player player, int score){
        FileOutputStream outputStream = new FileOutputStream("shistory.txt");

        int c;

        //while ((c = ))
    }

    public void isHighscore(int score) throws IOException {
        try{
            FileInputStream inputStream = new FileInputStream("shistory.txt");


            byte[] buffer = new byte[1024]; //nova linha
            int line = inputStream.read(buffer);


            inputStream.

        } catch (IOException e){
            e.printStackTrace();
        }

         // hashmap key value

        /*
         while (line != '\0'){


         }

         inputStream.close();
         */

    }

    public void readHighScore(){

    }


    public void setHighScore(){

    }


}
