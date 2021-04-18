package entity;

/**
 * TODO documentation
 */
public class GraphEdge {
    int from;
    int to;
    int weight;

    public GraphEdge() {}

    public GraphEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
