package datastructures.trees.binary_search_tree;

public class BSTTest {

    public static void main(String[] args) {

        int[] x = new int[]{1, 2, 3, 4, 5};
        BSTNode tree = new BSTNode(x[0]);
        for (int i = 1; i < x.length; i++) {
            BSTUtils.insert(tree, x[i]);
        }
        System.out.println("In order");
        BSTUtils.printInOrder(tree);

        System.out.println("Level order");
        BSTUtils.printLevelOrder(tree);

        System.out.println("Is balanced " + BSTUtils.isBalanced(tree));

        System.out.println("\nAfter balancing");
        tree = BSTUtils.balance(tree);

        System.out.println("In order");
        BSTUtils.printInOrder(tree);

        System.out.println("Level order");
        BSTUtils.printLevelOrder(tree);

        System.out.println("Is balanced " + BSTUtils.isBalanced(tree));

        BSTUtils.delete(tree, 2);

        System.out.println("In order");
        BSTUtils.printInOrder(tree);

    }
}