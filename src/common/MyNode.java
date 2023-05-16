package common;


public class MyNode {
    public int val;
    public MyNode left;
    public MyNode right;
    public MyNode next;

    public MyNode() {
    }

    public MyNode(int _val) {
        val = _val;
    }

    public MyNode(int _val, MyNode _left, MyNode _right, MyNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
