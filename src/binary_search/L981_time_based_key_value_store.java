package binary_search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class L981_time_based_key_value_store {
    Map<String, TreeMap<Integer, String>> map;

    public L981_time_based_key_value_store() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
        if (entry == null) {
            return "";
        }

        return entry.getValue();
    }
}