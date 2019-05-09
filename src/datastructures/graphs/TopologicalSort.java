package datastructures.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static List<GraphNode> topologicalSort(GraphNode[] nodes) {
        int no_of_nodes = nodes.length - 1;
        HashSet<Integer> visitedMap = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();
        for (int i = 1; i <= no_of_nodes; i++) {
            if (!visitedMap.contains(nodes[i].getData())) {
                topologicalSortUtil(nodes[i], visitedMap, stack);
            }
        }
        List<GraphNode> topologicalOrder = new LinkedList<>();
        while (!stack.empty()) {
            topologicalOrder.add(stack.pop());
        }
        return topologicalOrder;
    }

    private static void topologicalSortUtil(GraphNode node, HashSet<Integer> visitedMap, Stack<GraphNode> stack) {

        visitedMap.add(node.getData());
        List<GraphNode> nodeNeighbours = node.getNeighbours();
        for (GraphNode nodeNeighbour : nodeNeighbours) {
            if (!visitedMap.contains(nodeNeighbour.getData())) {
                topologicalSortUtil(nodeNeighbour, visitedMap, stack);
            }
        }
        stack.push(node);
    }
}
