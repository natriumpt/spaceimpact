package org.academiadecodigo.bootcamp.spaceimpact;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by codecadet on 1/27/17.
 */
public class ScoreHashComp implements Iterable<String> {

        private Map<String,Integer> highScoreHashData;

        public ScoreHashComp(String text){
            highScoreHashData = new HashMap<>();

            for(String word : text.split(" ")){
                highScoreHashData.put(word, highScoreHashData.containsKey(word) ? highScoreHashData.get(word) + 1 : 1);
            }
        }

        public int size(){
            return highScoreHashData.size();
        }

        public int get(String word){
            return highScoreHashData.get(word);
        }

        @Override
        public Iterator<String> iterator() {
            return highScoreHashData.keySet().iterator();
        }

    }

