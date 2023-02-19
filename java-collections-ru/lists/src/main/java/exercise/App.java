package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static void main(String[] args) {
        System.out.println(App.scrabble("rkqodlw", "world")); // true
        System.out.println(App.scrabble("ajv", "java")); // false
        System.out.println(App.scrabble("avjafff", "JaVa")); // true
        System.out.println(App.scrabble("", "App")); // false

    }
    public static boolean scrabble (String word, String words){
        String lowercaseChar = word.toLowerCase();
        String lowercaseWord = words.toLowerCase();
        String[] arrayArgs = lowercaseChar.split("");
        String[] arrayWords = lowercaseWord.split("");
        List<String> listArgs = Arrays.asList(arrayArgs);
        List<String> listWords = Arrays.asList(arrayWords);

        List<String> newWord = new ArrayList<>();
        for (String s : listWords) {
            newWord.add(s);
        }
        for (String w : listArgs){
            if (newWord.contains(w)){
                newWord.remove(w);
            }
        }
        System.out.println(newWord);
        return newWord.isEmpty();
    }
}
//END
