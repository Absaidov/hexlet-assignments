package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static void main(String[] args) {
        String sentence1 = "word text dog apple word apple word";
//        String sentence = "the java is the best programming language java";
//        Map wordsCount = getWordCount(sentence);
//        String result = toString(wordsCount);
//        System.out.println(result);
        Map wordsCount1 = getWordCount(sentence1);
        String result1 = toString(wordsCount1);
        System.out.println(result1);
    }
    public static Map<String, Integer> getWordCount(String sentence){
        if (sentence.length() == 0) {
            return new HashMap<String, Integer>();
        }
        String[] splitString = sentence.split(" ");
        Map<String, Integer> people = new HashMap<>();
        for (String word : splitString){
            int count = 1;
            if (people.containsKey(word)){
                count = people.get(word);
                count++;
            }
            people.put(word,count);
        }
        return people;
    }
    public static String toString(Map<String, Integer> mapToShow){
        if (mapToShow.isEmpty()) {
            return "{}";
        }
        String result = "{\n";
        for (Map.Entry<String, Integer> words: mapToShow.entrySet()) {
            result = result + "  " + words.getKey()+ ":" + " " + words.getValue() + "\n";
        }
        return result + "}";
    }
}
//END
