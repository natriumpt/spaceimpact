package org.academiadecodigo.bootcamp.spaceimpact.score;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by codecadet on 1/27/17.
 */
public abstract class ScoreHash extends HashMap<String,Integer> implements Iterator<String> {

    public ScoreHash(String line){

        for (String word : line.split(" ")) {

            if (!containsKey(word)) {
                put(word, 1);
            } else {
                put(word, get(word) + 1);
            }
        }
    }

    public Iterator<String> iterator() {
        return keySet().iterator();
    }

}
