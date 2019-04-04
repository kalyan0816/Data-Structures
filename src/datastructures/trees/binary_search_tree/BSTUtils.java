package datastructures.trees.binary_search_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTUtils {
    static int size(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + ((node.getLeft() == null) ? 0 : size(node.getLeft())) + ((node.getRight() == null) ? 0 : size(node.getRight()));
    }

    static int height(BSTNode node) {
        return 1 + Math.max(((node.getLeft() == null) ? 0 : height(node.getLeft())), ((node.getRight() == null) ? 0 : height(node.getRight())));
    }

    private static void inOrderNodesList(LinkedList<BSTNode> nodes, BSTNode root) {
        if (root.getLeft() != null) {
            inOrderNodesList(nodes, root.getLeft());
        }
        nodes.add(root);
        if (root.getRight() != null) {
            inOrderNodesList(nodes, root.getRight());
        }
    }

    static void printLevelOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        ArrayDeque<BSTNode> queue = new ArrayDeque<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            BSTNode bstNode = queue.removeFirst();
            System.out.println(bstNode.getData());
            if (bstNode.getLeft() != null) {
                queue.addLast(bstNode.getLeft());
            }
            if (bstNode.getRight() != null) {
                queue.addLast(bstNode.getRight());
            }
        }
    }

    static BSTNode balance(BSTNode node) {
        if (node == null) {
            return null;
        }
        LinkedList<BSTNode> nodesList = new LinkedList<>();
        inOrderNodesList(nodesList, node);

        return buildTree(nodesList, 0, nodesList.size() - 1);
    }

    private static BSTNode buildTree(LinkedList<BSTNode> nodesList, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        BSTNode node = nodesList.get(mid);
        node.setLeft(buildTree(nodesList, left, mid - 1));
        node.setRight(buildTree(nodesList, mid + 1, right));
        return node;
    }

    static boolean isBalanced(BSTNode node) {
        if (node == null) {
            return true;
        }
        return checkBalance(node.getLeft()) != -1 && checkBalance(node.getRight()) != -1;
    }

    private static int checkBalance(BSTNode node) {

        if (node == null) {
            return 0;
        }
        int leftHeight = checkBalance(node.getLeft());
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkBalance(node.getRight());
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }


    static void insert(BSTNode node, int value) {
        if (node == null) {
            return;
        }
        if (value == node.getData()) {
            node.setCount(node.getCount() + 1);
        } else if (value < node.getData()) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTNode(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BSTNode(value));
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    static BSTNode delete(BSTNode node, int x) {
        if (x > node.getData() && node.getRight() != null) {
            node.setRight(delete(node.getRight(), x));
        } else if (x < node.getData() && node.getLeft() != null) {
            node.setLeft(delete(node.getLeft(), x));
        } else if (node.getData() == x) {
            boolean isLeaf = node.getLeft() == null && node.getRight() == null;
            boolean hasOnlyLeftChild = node.getLeft() != null && node.getRight() == null;
            boolean hasOnlyRightChild = node.getLeft() == null && node.getRight() != null;
            if (isLeaf) {
                return null;
            } else if (hasOnlyLeftChild) {
                return node.getLeft();
            } else if (hasOnlyRightChild) {
                return node.getRight();
            } else {
                BSTNode maxOfLeftSubTree = getMax(node.getLeft());
                node.setData(maxOfLeftSubTree.getData());
                node.setCount(maxOfLeftSubTree.getCount());
                delete(node.getLeft(), maxOfLeftSubTree.getData());
            }
        }
        return node;
    }

    static BSTNode getMax(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    static BSTNode getMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getRight();
        }
        return temp;
    }

    static boolean contains(BSTNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.getData()) {
            return true;
        } else if (value < node.getData()) {
            return (node.getLeft() != null) && contains(node.getLeft(), value);
        } else {
            return (node.getRight() != null) && contains(node.getRight(), value);
        }
    }

    static BSTNode find(BSTNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.getData()) {
            return node;
        } else if (value > node.getData()) {
            return (node.getRight() == null) ? null : find(node.getRight(), value);
        } else {
            return (node.getLeft() == null) ? null : find(node.getLeft(), value);
        }
    }

    static List<Integer> retrieveInOrderList(BSTNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> order = new LinkedList<>();
        if (node.getLeft() != null) {
            List<Integer> leftValues = retrieveInOrderList(node.getLeft());
            order.addAll(leftValues);
        }
        for (int i = 0; i < node.getCount(); i++) {
            order.add(node.getData());
        }
        if (node.getRight() != null) {
            List<Integer> rightValues = retrieveInOrderList(node.getRight());
            order.addAll(rightValues);
        }
        return order;
    }

    static void printInOrder(BSTNode node) {

        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            printInOrder(node.getLeft());
        }
        for (int i = 0; i < node.getCount(); i++) {
            System.out.println(node.getData());
        }
        if (node.getRight() != null) {
            printInOrder(node.getRight());
        }
    }
}