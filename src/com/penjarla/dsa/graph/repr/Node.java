package com.penjarla.dsa.graph.repr;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * TODO documentation
 */
@Setter
@Getter
public class Node {
    int to;
    int weight;

    public Node() {}

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}