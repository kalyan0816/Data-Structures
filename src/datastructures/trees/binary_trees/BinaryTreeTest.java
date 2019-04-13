package datastructures.trees.binary_trees;

public class BinaryTreeTest {

    //    https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwiu6fLS_LfhAhVRb30KHTwkA98QjRx6BAgBEAU&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBinary_tree&psig=AOvVaw3J2PYxTthOHFLyZ91gsEIA&ust=1554520062817164
    public static void main(String[] args) {

        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(10);
        binaryTreeNode1.setLeft(new BinaryTreeNode(11));
        binaryTreeNode1.getLeft().setLeft(new BinaryTreeNode(7));
        binaryTreeNode1.getLeft().setRight(new BinaryTreeNode(12));
        binaryTreeNode1.setRight(new BinaryTreeNode(9));
        binaryTreeNode1.getRight().setLeft(new BinaryTreeNode(15));
        binaryTreeNode1.getRight().setRight(new BinaryTreeNode(8));

        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(10);
        binaryTreeNode2.setLeft(new BinaryTreeNode(11));
        binaryTreeNode2.getLeft().setLeft(new BinaryTreeNode(7));
        binaryTreeNode2.getLeft().setRight(new BinaryTreeNode(12));
        binaryTreeNode2.setRight(new BinaryTreeNode(9));
        binaryTreeNode2.getRight().setLeft(new BinaryTreeNode(15));
        binaryTreeNode2.getRight().setRight(new BinaryTreeNode(8));

        boolean areIdenticalRec = CheckingIfTwoBinaryTreesAreIdentical.areIdenticalRec(binaryTreeNode1, binaryTreeNode2);
        System.out.println(areIdenticalRec);
        boolean areIdenticalIterative = CheckingIfTwoBinaryTreesAreIdentical.areIdenticalIterative(binaryTreeNode1, binaryTreeNode2);
        System.out.println(areIdenticalIterative);
    }
}
