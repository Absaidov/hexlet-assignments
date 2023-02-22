package exercise;

import java.util.*;

// BEGIN
class App {
    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>(
                Map.of("one", "eon", "two", "two", "four", true)
        );

        Map<String, Object> data2 = new HashMap<>(
                Map.of("two", "own", "zero", 4, "four", true)
        );

        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result);

        Map<String, Object> data11 = new HashMap<>(
                Map.of("two", "own")
        );
        Map<String, Object> data22 = new HashMap<>();
        Map<String, String> result11 = App.genDiff(data11, data22);
        System.out.println(result11);
    }

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> linkedHashMap2 = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (Map.Entry<String, Object> words1 : data1.entrySet()) {
            list.add(words1.getKey());
        }
        for (Map.Entry<String, Object> words2 : data2.entrySet()) {
            list2.add(words2.getKey());
        }
//        for (Map.Entry<String, Object> words2 : data2.entrySet()) {
//            for (Map.Entry<String, Object> words1 : data1.entrySet()) {
                for (String w : list) {
                    if (!(list2.contains(w))) {
                        linkedHashMap2.put(w, "deleted");
                    }
                }
                for (String w : list2) {
                    if (!(list.contains(w))) {
                        linkedHashMap2.put(w, "added");
                    }
                }

//            }
//        }


        for (Map.Entry<String, Object> words1 : data1.entrySet()) {
            for (Map.Entry<String, Object> words2 : data2.entrySet()) {
                if (words1.getKey().equals(words2.getKey()) && words1.getValue().equals(words2.getValue())) {
                    linkedHashMap2.put(words2.getKey(), "unchanged");
                }
                if (words1.getKey().equals(words2.getKey()) && !(words1.getValue().equals(words2.getValue()))) {
                    linkedHashMap2.put(words2.getKey(), "changed");
                }

//                for (String s : list) {
//                    if ((list2.contains(s))) {
//                        linkedHashMap2.put(s, "added");
//                    }
//                }

                }
            }
        return linkedHashMap2;
        }
    }
//END
