package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
    Map<String, String> mapKV = new HashMap<>();

    public InMemoryKV(Map<String, String> storage) {
        this.mapKV.putAll(storage);
    }

    @Override
    public void set(String key, String value) {
        mapKV.put(key, value);
    }

    @Override
    public void unset(String key) {
        mapKV.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (!mapKV.containsKey(key)){
            return defaultValue;
        }
        return mapKV.get(key);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(mapKV);
    }
}
// END
