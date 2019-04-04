package datastructures.graphs;

import java.util.Scanner;

public class GraphTest {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int noOfNodes = scanner.nextInt();
        int noOfEdges = scanner.nextInt();

        GraphNode[] nodesArray = new GraphNode[noOfNodes + 1];

        for (int i = 1; i <= noOfNodes; i++) {
            GraphNode node = new GraphNode(i);
            nodesArray[i] = node;
        }

        for (int i = 1; i <= noOfEdges; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            nodesArray[m].addNeighbour(nodesArray[n]);
        }

        GraphUtils.bfs(nodesArray[1]);
        GraphUtils.dfs(nodesArray[1]);
        System.out.println(nodesArray[1].getData() + " has " + ((GraphUtils.hasPathTo(nodesArray[1], nodesArray[4])) ? "" : "no ") + "path to " + nodesArray[4].getData());
        System.out.println(nodesArray[2].getData() + " has " + ((GraphUtils.hasPathTo(nodesArray[2], nodesArray[5])) ? "" : "no ") + "path to " + nodesArray[5].getData());
        System.out.println(nodesArray[3].getData() + " has " + ((GraphUtils.hasPathTo(nodesArray[3], nodesArray[4])) ? "" : "no ") + "path to " + nodesArray[4].getData());
    }
}