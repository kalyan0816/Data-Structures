package datastructures.graphs;

import java.util.List;
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

        List<GraphNode> topologicalSort = TopologicalSort.topologicalSort(nodesArray);
        topologicalSort.forEach(node->{
            System.out.print(node.getData()+" ");
        });

    }
}