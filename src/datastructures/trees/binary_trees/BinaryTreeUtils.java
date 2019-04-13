package datastructures.trees.binary_trees;

import java.util.ArrayDeque;

public class BinaryTreeUtils {

    static void inOrderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderTraversal(node.getRight());
    }

    static void postOrderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getData() + " ");
    }

    static void preOrderTraversal(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    static void levelOrderTraversal(BinaryTreeNode node) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode binaryTreeNode = queue.removeFirst();
            System.out.print(binaryTreeNode.getData() + " ");
            if (binaryTreeNode.getLeft() != null) {
                queue.addLast(binaryTreeNode.getLeft());
            }
            if (binaryTreeNode.getRight() != null) {
                queue.addLast(binaryTreeNode.getRight());
            }
        }
    }

    static void insert(BinaryTreeNode node, Integer key) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode binaryTreeNode = queue.removeFirst();
            if (binaryTreeNode.getLeft() == null) {
                binaryTreeNode.setLeft(new BinaryTreeNode(key));
                break;
            } else {
                queue.addLast(binaryTreeNode.getLeft());
            }
            if (binaryTreeNode.getRight() == null) {
                binaryTreeNode.setRight(new BinaryTreeNode(key));
                break;
            } else {
                queue.addLast(binaryTreeNode.getRight());
            }
        }
    }

    static void delete(BinaryTreeNode binaryTreeNode, int key) {

        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.addLast(binaryTreeNode);
        BinaryTreeNode keyNode = null, tempNode = null, deletionNode;

        while (!queue.isEmpty()) {
            tempNode = queue.removeFirst();
            if (tempNode.getData() == key) {
                keyNode = tempNode;
            }
            if (tempNode.getLeft() != null) {
                queue.addLast(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.addLast(tempNode.getRight());
            }
        }
        if (keyNode != null) {
            deletionNode = tempNode;
            int deletionKey = deletionNode.getData();
            deleteNode(binaryTreeNode, deletionNode);
            keyNode.setData(deletionKey);
        }
    }

    public static int heightRecursive(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightRecursive(root.getLeft()), heightRecursive(root.getRight())) + 1;
    }

    private static void deleteNode(BinaryTreeNode binaryTreeNode, BinaryTreeNode deletionNode) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.addLast(binaryTreeNode);

        while (!queue.isEmpty()) {
            BinaryTreeNode currentNode = queue.removeLast();
            if (currentNode.getRight() != null) {
                if (currentNode.getRight() == deletionNode) {
                    currentNode.setRight(null);
                    return;
                } else {
                    queue.addLast(currentNode.getRight());
                }
            }
            if (currentNode.getLeft() != null) {
                if (currentNode.getLeft() == deletionNode) {
                    currentNode.setLeft(null);
                    return;
                } else {
                    queue.addLast(currentNode.getLeft());
                }
            }
        }
    }
}
