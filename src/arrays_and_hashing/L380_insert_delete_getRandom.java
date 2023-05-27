package arrays_and_hashing;

import java.util.*;

public class L380_insert_delete_getRandom {
    List<Integer> arr;
    // value : index in arr
    Map<Integer, Integer> map;
    Random rand;

    /**
     * Initialize your data structure here.
     */
    public L380_insert_delete_getRandom() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr.add(val);
        map.put(val, arr.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // 1. move last
        int index = map.get(val);
        int last = arr.get(arr.size() - 1);
        arr.set(index, last);
        // 2. delete last
        arr.remove(arr.size() - 1);
        // 3. update last entry
        map.put(last, index);
        // 4. delete val entry
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = rand.nextInt(arr.size());
        return arr.get(index);
    }
}
