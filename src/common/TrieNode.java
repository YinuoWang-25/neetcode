package common;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean isWord;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}
