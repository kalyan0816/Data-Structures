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
            nodesArray[n].addNeighbour(nodesArray[m]);
        }
        nodesArray[1].bfs();
        nodesArray[1].dfs();
        System.out.println(nodesArray[1].getData() + " has " + ((nodesArray[1].hasPathTo(nodesArray[4])) ? "" : "no ") + "path to " + nodesArray[4].getData());
        System.out.println(nodesArray[2].getData() + " has " + ((nodesArray[2].hasPathTo(nodesArray[5])) ? "" : "no ") + "path to " + nodesArray[5].getData());
        System.out.println(nodesArray[3].getData() + " has " + ((nodesArray[3].hasPathTo(nodesArray[4])) ? "" : "no ") + "path to " + nodesArray[4].getData());
    }
}
