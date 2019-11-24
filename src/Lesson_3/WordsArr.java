package Lesson_3;

import java.util.*;

public class WordsArr {
    public static void main(String[] args) {
        Utils.CustomRandomizer rnd = new Utils.CustomRandomizer();
        ArrayList<String> wordsArrList = new ArrayList<>();
        for (int j = 0; j < rnd.rnd(10, 20); j++) {
            wordsArrList.add("A" + rnd.rnd(1, 8));
        }

        System.out.println(wordsArrList);
        Set<String> wordSet = new HashSet<>(wordsArrList);
        System.out.println(wordSet);

        for (String key : wordSet) {
            System.out.println(key + ": " + Collections.frequency(wordsArrList, key));
        }
    }
}
