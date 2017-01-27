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
        outputStream.print(player.getPlayerName() + " ");
        outputStream.print(player.getScore() + '\n');
        outputStream.close();
    }

    public int checkScore(Player p) throws IOException {
        FileInputStream inputStream = new FileInputStream("shistory.txt");

        int c;
        int index = 0;
        char temp [] = new char[40];
        int score = 0;
        String playerName = "";

        while ((c = inputStream.read()) != ' ') {
            if (c >= 65 && c <= 123 )
                temp[index] = (char) c;
            index ++;
        }

        index = 0;
        temp = null;
        playerName = temp.toString();

        while ((c = inputStream.read()) != '\n') {
            if (c >= 65 && c <= 123 )
                score  = (score * 10) + c;
            index ++;
        }
        return score;
    }


}
