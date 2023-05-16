package linked_list;

import java.util.HashMap;

class L146_LRU_cache {
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public L146_LRU_cache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // remove current
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // move current to tail
        appendNode(node);

        return map.get(key).value;
    }

    public void put(int key, int value) {
        // already move to tail
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        appendNode(insert);
    }

    private void appendNode(Node node) {
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}