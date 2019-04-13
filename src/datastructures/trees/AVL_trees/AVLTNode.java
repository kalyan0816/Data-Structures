package datastructures.trees.AVL_trees;

import java.util.StringJoiner;

public class AVLTNode {

    private int data;
    private int height;
    private AVLTNode left;
    private AVLTNode right;

    public AVLTNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLTNode getLeft() {
        return left;
    }

    public void setLeft(AVLTNode left) {
        this.left = left;
    }

    public AVLTNode getRight() {
        return right;
    }

    public void setRight(AVLTNode right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", AVLTNode.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("height=" + height)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }
}