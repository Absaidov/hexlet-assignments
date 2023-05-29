package exercise;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap;
import jdk.jshell.execution.Util;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    Map<String, String> mapKV = new HashMap<>();

    String stringPath;

    public FileKV(String stringPath, Map<String, String> storage) {
        this.mapKV.putAll(storage);
        this.stringPath = stringPath;
    }

    @Override
    public void set(String key, String value) {
        String readPath = Utils.readFile(stringPath);
        Map<String, String> map = Utils.unserialize(readPath);
        map.put(key, value);
        Utils.writeFile(this.stringPath, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        String readPath = Utils.readFile(stringPath);
        Map<String, String> map = Utils.unserialize(readPath);
        map.remove(key);
        Utils.writeFile(this.stringPath, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        String readPath = Utils.readFile(stringPath);
        Map<String, String> map = Utils.unserialize(readPath);
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {
        String readPath = Utils.readFile(stringPath);
        Map<String, String> map = Utils.unserialize(readPath);
        return map;
    }
}
// END
