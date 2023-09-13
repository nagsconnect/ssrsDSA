package com.penjarla.dsa.graph.repr;

/**
 * TODO documentation
 */
public class Edge {
    int from;
    int to;
    int weight;

    public Edge() {}

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
