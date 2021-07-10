package main.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * TODO documentation
 */
@Setter
@Getter
public class GraphNode implements Comparator<GraphNode> {
    int to;
    int weight;

    public GraphNode() {}

    public GraphNode(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compare(GraphNode graphNode1, GraphNode graphNode2) {
        if (graphNode1.weight < graphNode2.weight) {
            return -1;
        } else if (graphNode1.weight > graphNode2.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}