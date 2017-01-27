package score;

import org.academiadecodigo.bootcamp.spaceimpact.gameobject.Player;

import java.io.*;

public class Score {

    //TODO: Assigned to Branco

    Player player;

    public Score(Player player){
        this.player = player;
    }


    public void setScore(Player player) throws IOException {
        /*Streams (InputStream and OutputStream) transfer binary data. If you want to write a string to a stream, you must first convert it to bytes, or in other words encode it. You can do that manually (as you suggest) using the String.getBytes(Charset) method, but you should avoid the String.getBytes() method, because that uses the default encoding of the JVM, which can't be reliably predicted in a portable way.
        The usual way to write character data to a stream, though, is to wrap the stream in a Writer, (often a PrintWriter), that does the conversion for you when you call its write(String) (or print(String)) method. The corresponding wrapper for InputStreams is a Reader.
        PrintStream is a special OutputStream implementation
        */
        PrintStream outputStream = new PrintStream("shistory.txt");
        outputStream.print(player.getPlayerName());
        //outputStream.prin(player.getScore());
        outputStream.close();
        //while ((c = ))
    }

    public void checkHighscore(int score) throws IOException {
        try{
            FileInputStream inputStream = new FileInputStream("shistory.txt");


            byte[] buffer = new byte[1024]; //nova linha
            int line = inputStream.read(buffer);


            //inputStream.

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
