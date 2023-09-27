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
    public int value;
    public Node() {}

    public Node(int value) {
        this.value = value;
    }
}