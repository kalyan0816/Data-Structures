package datastructures.trees.AVL_trees;

import java.util.Scanner;

public class AVLTTest {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        AVLTNode avltNode = null;
        System.out.println("Select option");
        System.out.println("1 . insert x");
        System.out.println("2 . remove x");
        do {
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    int x = scanner.nextInt();
                    avltNode = AVTUtils.insert(avltNode, x);
                    System.out.println("Inserted " + x);
                    break;
                }
                case 2: {
                    int x = scanner.nextInt();
                    avltNode = AVTUtils.delete(avltNode, x);
                    System.out.println("Removed " + x);
                    break;
                }
            }
            System.out.println(avltNode);
        } while (true);
    }
}