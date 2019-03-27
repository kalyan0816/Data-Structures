package datastructures.practice.binary_search_tree;

public class BinarySearchTree {

    public static void main(String[] args) {

//        int[] x = ArrayUtils.randomIntArray(10, 1, 20);
        int[] x = new int[]{1, 2, 3, 4, 5};
        BSTNode tree = new BSTNode(x[0]);
        for (int i = 1; i < x.length; i++) {
            tree.insert(x[i]);
        }
        System.out.println(tree);
        tree = tree.balance();
        System.out.println(tree);
    }
}