package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void main(String[] args) {
        KeyValueStorage storage2 = new InMemoryKV(Map.of("foo", "bar", "bar", "zoo"));
        App.swapKeyValue(storage2);
//        System.out.println(storage2.get("bar", "default"));


        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        // Получение значения по ключу
        System.out.println(storage.get("key", "default")); // "value"

//        System.out.println(storage.toMap());
    }
        public static void swapKeyValue(KeyValueStorage storage) {
            for (Map.Entry<String, String> map: storage.toMap().entrySet()) {
                storage.unset(map.getKey());
                storage.set(map.getValue(), map.getKey());
            }
        }
}
// END
