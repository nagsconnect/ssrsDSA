package com.penjarla.dsa.graph.repr;

/**
 * TODO documentation
 */
public class Edge {
    public Node from;
    public Node to;
    public int weight;

    public Edge() {}

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
