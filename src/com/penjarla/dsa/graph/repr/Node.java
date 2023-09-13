package com.penjarla.dsa.graph.repr;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * TODO documentation
 */
@Setter
@Getter
public class Node implements Comparator<Node> {
    int to;
    int weight;

    public Node() {}

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight) {
            return -1;
        } else if (node1.weight > node2.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}