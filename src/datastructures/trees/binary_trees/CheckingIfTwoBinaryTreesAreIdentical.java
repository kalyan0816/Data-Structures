package datastructures.trees.binary_trees;

import java.util.ArrayDeque;

//https://www.techiedelight.com/check-if-two-binary-trees-are-identical-not-iterative-recursive/

public class CheckingIfTwoBinaryTreesAreIdentical {

    public static boolean areIdenticalRec(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (bothAreNull(root1, root2)) {
            return true;
        } else if (onlyOneNodeIsNull(root2, root1)) {
            return false;
        }
        if (dataIsNotSame(root1, root2)) {
            return false;
        }
        return areIdenticalRec(root1.getLeft(), root2.getLeft())
                && areIdenticalRec(root1.getRight(), root2.getRight());
    }

    public static boolean areIdenticalIterative(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (bothAreNull(root1, root2)) {
            return true;
        } else if (onlyOneNodeIsNull(root2, root1)) {
            return false;
        }
        if (dataIsNotSame(root1, root2)) {
            return false;
        }

        ArrayDeque<BinaryTreeNode> queue1 = new ArrayDeque<>();
        ArrayDeque<BinaryTreeNode> queue2 = new ArrayDeque<>();
        queue1.addLast(root1);
        queue2.addLast(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            BinaryTreeNode root1Node = queue1.removeFirst();
            BinaryTreeNode root2Node = queue2.removeFirst();

            if (dataIsNotSame(root1Node, root2Node)) {
                return false;
            }
            if (bothAreNonNull(root1Node.getLeft(), root2Node.getLeft())) {
                queue1.addLast(root1Node.getLeft());
                queue2.addLast(root2Node.getLeft());
            } else if (onlyOneNodeIsNull(root1Node, root2Node)) {
                return false;
            }
            if (bothAreNonNull(root1Node.getRight(), root2Node.getRight())) {
                queue1.addLast(root1Node.getRight());
                queue2.addLast(root2Node.getRight());
            } else if (onlyOneNodeIsNull(root1Node, root2Node)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dataIsNotSame(BinaryTreeNode root1, BinaryTreeNode root2) {
        return root1.getData() != root2.getData();
    }

    private static boolean onlyOneNodeIsNull(BinaryTreeNode root2, BinaryTreeNode root1) {
        return (root1 == null && root2 != null) || (root1 != null && root2 == null);
    }

    private static boolean bothAreNull(BinaryTreeNode root1, BinaryTreeNode root2) {
        return root1 == null && root2 == null;
    }

    private static boolean bothAreNonNull(BinaryTreeNode root1, BinaryTreeNode root2) {
        return root1 != null && root2 != null;
    }
}