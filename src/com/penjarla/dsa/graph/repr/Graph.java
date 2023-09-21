package com.penjarla.dsa.graph.repr;

import java.util.*;

/** TODO  documentation
 * This class represents a graph and its representation
 *
 */
public class Graph {
    int V;
    public Map<Integer, Node> nodes;
    public Map<Node, List<Edge>> wtAdjList;
    public Map<Node, List<Node>> adjList;
    public List<List<Integer>> adjMatrix;
    public List<Edge> edgeList;
}
