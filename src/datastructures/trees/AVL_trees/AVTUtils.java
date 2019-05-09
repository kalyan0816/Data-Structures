package datastructures.trees.AVL_trees;

public class AVTUtils {

    public static final int BALANCE_FACTOR = 1;

    static int height(AVLTNode node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private static AVLTNode singleRotationLeft(AVLTNode x) {
        AVLTNode w = x.getLeft();
        x.setLeft(w.getRight());
        w.setRight(x);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        w.setHeight(Math.max(height(w.getLeft()), height(w.getRight())) + 1);
        return w;
    }

    private static AVLTNode singleRotationRight(AVLTNode x) {
        AVLTNode w = x.getRight();
        x.setRight(w.getLeft());
        w.setLeft(x);
        w.setHeight(Math.max(height(w.getLeft()), height(w.getRight())) + 1);
        x.setHeight(Math.max(height(x.getRight()), height(x.getLeft())) + 1);
        return w;
    }

    private static AVLTNode doubleRotateWithLeft(AVLTNode x) {
        x.setLeft(singleRotationRight(x.getLeft()));
        return singleRotationLeft(x);
    }

    private static AVLTNode doubleRotateWithRight(AVLTNode x) {
        x.setRight(singleRotationLeft(x.getRight()));
        return singleRotationRight(x);
    }

    public static AVLTNode insert(AVLTNode node, int data) {
        if (node == null) {
            return new AVLTNode(data);
        }
        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insert(node.getRight(), data));
        }
        return balance(node);
    }

    public static AVLTNode delete(AVLTNode node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(delete(node.getRight(), data));
        } else {
            if (node.getLeft() != null && node.getRight() != null) {
                int maxOfLeftSubTree = getMax(node.getLeft()).getData();
                node.setData(maxOfLeftSubTree);
                node.setLeft(delete(node.getLeft(), maxOfLeftSubTree));
            } else {
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            }
        }
        return balance(node);
    }

    private static AVLTNode balance(AVLTNode node) {

        if (node == null) {
            return null;
        }
        if (height(node.getLeft()) - height(node.getRight()) > BALANCE_FACTOR) {
            if (height(node.getLeft().getLeft()) >= getBalance(node.getLeft().getRight())) {
                node = singleRotationLeft(node);
            } else {
                node = doubleRotateWithLeft(node);
            }
        } else if (height(node.getRight()) - height(node.getLeft()) > BALANCE_FACTOR) {
            if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                node = singleRotationRight(node);
            } else {
                node = doubleRotateWithRight(node);
            }
        }
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        return node;
    }

    private static int getBalance(AVLTNode root) {
        if (root == null) {
            return 0;
        }
        return height(root.getLeft()) - height(root.getRight());
    }

    static AVLTNode getMax(AVLTNode node) {
        if (node == null) {
            return null;
        }
        AVLTNode temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    public static void printInOrder(AVLTNode x) {
        if (x == null) {
            return;
        }
        printInOrder(x.getLeft());
        System.out.println(x.getData());
        printInOrder(x.getRight());
    }
}