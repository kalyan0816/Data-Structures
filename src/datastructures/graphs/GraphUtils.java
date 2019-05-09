package datastructures.graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Predicate;

public class GraphUtils {
    public static Optional<GraphNode> getNextUnvisitedNeighbour(GraphNode peek, HashSet<Integer> visitedMap) {

        return peek.getNeighbours().stream()
                .filter(unvisitedNodePredicate(visitedMap))
                .findFirst();
    }

    private static Predicate<GraphNode> unvisitedNodePredicate(HashSet<Integer> visitedMap) {
        return node -> !visitedMap.contains(node.getData());
    }

    public static void bfs(GraphNode graphNode) {

        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        HashSet<Integer> visitedNodes = new HashSet<>();

        queue.addLast(graphNode);

        while (!queue.isEmpty()) {

            GraphNode removedNode = queue.removeFirst();
            System.out.print(removedNode.getData() + " ");

            for (GraphNode neighbour : removedNode.getNeighbours()) {
                if (unvisitedNodePredicate(visitedNodes).test(neighbour)) {
                    visitedNodes.add(neighbour.getData());
                    queue.addLast(neighbour);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(GraphNode graphNode) {

        Stack<GraphNode> stack = new Stack<>();
        HashSet<Integer> visitedNodes = new HashSet<>();
        stack.push(graphNode);

        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.peek();
            if (unvisitedNodePredicate(visitedNodes).test(currentNode)) {
                System.out.print(currentNode.getData() + " ");
            }
            visitedNodes.add(currentNode.getData());
            Optional<GraphNode> nextUnvisitedNeighbour = getNextUnvisitedNeighbour(currentNode, visitedNodes);

            if (nextUnvisitedNeighbour.isPresent()) {
                GraphNode nextUnvisitedNeighbourNode = nextUnvisitedNeighbour.get();
                stack.push(nextUnvisitedNeighbourNode);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    public static boolean hasPathTo(GraphNode source, GraphNode destination) {
        if (destination == null || source == null) {
            return false;
        } else if (destination == source) {
            return true;
        }
        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        HashSet<Integer> visitedNodes = new HashSet<>();
        queue.addLast(source);

        while (!queue.isEmpty()) {
            GraphNode removedNode = queue.removeFirst();
            visitedNodes.add(removedNode.getData());
            for (GraphNode neighbour : removedNode.getNeighbours()) {
                if (neighbour == destination) {
                    return true;
                } else if (unvisitedNodePredicate(visitedNodes).test(neighbour)) {
                    queue.addLast(neighbour);
                }
            }
        }
        return false;
    }
}
