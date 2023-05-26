package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void main(String[] args) {
//        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
//        App.swapKeyValue(storage);
//        System.out.println(storage.toMap());
//        System.out.println(storage.get("key", "default")); // "default"
//        storage.get("value", "default"); // "key"

//        System.out.println(storage.toMap()); // => {value=key, value2=key2}

        KeyValueStorage storage2 = new InMemoryKV(Map.of("foo", "bar", "bar", "zoo"));
        App.swapKeyValue(storage2);
        System.out.println(storage2.get("bar", "default"));

//        System.out.println(storage2.toMap());

//        System.out.println(storage.toMap()); // => {value=key, value2=key2}
    }
    public static void swapKeyValue(KeyValueStorage storage){
        for(Map.Entry<String, String> map : storage.toMap().entrySet()){
                storage.unset(map.getKey());
                storage.set(map.getKey(), map.getValue());
        }
    }
}
// END
