package datastructures.trees.binary_search_tree;

import java.util.StringJoiner;

class BSTNode {

    private int data;
    private int count;
    private BSTNode left, right;

    BSTNode(int data) {
        this.data = data;
        this.count = 1;
    }

    int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    BSTNode getLeft() {
        return left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getCount() {
        return count;
    }

    BSTNode getRight() {
        return right;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BSTNode.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("count=" + count)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }
}