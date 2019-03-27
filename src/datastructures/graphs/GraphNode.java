package datastructures.graphs;

import java.util.*;
import java.util.function.Predicate;

public class GraphNode {

    private int data;
    private List<GraphNode> neighbours;

    public GraphNode(int data) {
        this.data = data;
        this.neighbours = new LinkedList<>();
    }

    private static Optional<GraphNode> getNextUnvisitedNeighbour(GraphNode peek, HashSet<Integer> visitedMap) {

        return peek.neighbours.stream()
                .filter(unvisitedNodePredicate(visitedMap))
                .findFirst();
    }

    private static Predicate<GraphNode> unvisitedNodePredicate(HashSet<Integer> visitedMap) {
        return node -> !visitedMap.contains(node.data);
    }

    public int getData() {
        return data;
    }

    public List<GraphNode> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(GraphNode neighbour) {
        this.neighbours.add(neighbour);
    }

    public void bfs() {

        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        HashSet<Integer> visitedNodes = new HashSet<>();

        queue.addLast(this);

        while (!queue.isEmpty()) {

            GraphNode removedNode = queue.removeFirst();
            System.out.print(removedNode.data + " ");

            visitedNodes.add(removedNode.data);

            for (GraphNode neighbour : removedNode.neighbours) {
                if (unvisitedNodePredicate(visitedNodes).test(neighbour)) {
                    queue.addLast(neighbour);
                }
            }
        }
        System.out.println();
    }

    public void dfs() {

        Stack<GraphNode> stack = new Stack<>();
        HashSet<Integer> visitedNodes = new HashSet<>();
        stack.push(this);

        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.peek();
            if (unvisitedNodePredicate(visitedNodes).test(currentNode)) {
                System.out.print(currentNode.data + " ");
            }
            visitedNodes.add(currentNode.data);
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

    public boolean hasPathTo(GraphNode destination) {
        if (destination == null) {
            return false;
        } else if (destination == this) {
            return true;
        }
        ArrayDeque<GraphNode> queue = new ArrayDeque<>();
        HashSet<Integer> visitedNodes = new HashSet<>();
        queue.addLast(this);

        while (!queue.isEmpty()) {
            GraphNode removedNode = queue.removeFirst();
            visitedNodes.add(removedNode.data);
            for (GraphNode neighbour : removedNode.neighbours) {
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
