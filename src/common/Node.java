package common;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;
    public List<Node> neighbors;
    public Node prev;
    public Node next;
    public Node left;
    public Node right;
    public Node child;
    public Node parent;
    public Node random;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
