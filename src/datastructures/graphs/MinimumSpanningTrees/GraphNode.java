package datastructures.graphs.MinimumSpanningTrees;

import java.util.HashMap;
import java.util.Objects;

public class GraphNode {

    private int data;
    private HashMap<GraphNode, Integer> neighbours;

    public GraphNode(int data) {
        this.data = data;
        neighbours = new HashMap<>();
    }

    public int getData() {
        return data;
    }

    public HashMap<GraphNode, Integer> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(GraphNode neighbour, Integer cost) {
        this.neighbours.put(neighbour, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return data == graphNode.data &&
                Objects.equals(neighbours, graphNode.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, neighbours);
    }
}