package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class GraphNode {

    private int data;
    private List<GraphNode> neighbours;

    public GraphNode(int data) {
        this.data = data;
        this.neighbours = new LinkedList<>();
    }


    public int getData() {
        return data;
    }

    public List<GraphNode> getNeighbours() {
        return neighbours;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNeighbours(List<GraphNode> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(GraphNode neighbour) {
        this.neighbours.add(neighbour);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GraphNode.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("neighbours=" + neighbours)
                .toString();
    }
}
