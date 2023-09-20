package com.penjarla.dsa.graph;

import com.penjarla.dsa.graph.repr.Edge;
import com.penjarla.dsa.graph.repr.Graph;
import com.penjarla.dsa.graph.repr.Node;

import java.util.*;

/**
 * BellamanFord, a single source shortest path algorithm
 * - An alternative to Dijkstra where edge wt are negative
 * - TimeComplexity:
 * - SpaceComplexity:
 */
public class BellmanFord {

    public Graph graph;

    public BellmanFord(Graph graph) {
        this.graph = graph;
    }

    public Map<Node, Integer> shortestPath(Node from, Map<Node, Node> prev) {
        Map<Node, Integer> distance = new HashMap<>();
        List<Edge> edgeList = graph.edgeList;
        for (Node node : graph.nodes.values()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        // starting node distance is zero b/c it is the starting point to reach any other node
        distance.put(from, 0);
        // Relax all edges, V - 1 times here V=# of nodes, why V - 1 b/c shortest path atmost will have V - 1 edges
        for (int i = 0; i < graph.nodes.size() - 1; i++) {
            for (Edge edge : edgeList) {
                if (distance.get(edge.from) + edge.weight < distance.get(edge.to)) {
                    distance.put(edge.to, distance.get(edge.from) + edge.weight);
                }
            }
        }
        // Relax all edges again to detect any negative cycles
        for (int i = 0; i < graph.nodes.size() - 1; i++) {
            for (Edge edge : edgeList) {
                if (distance.get(edge.from) + edge.weight < distance.get(edge.to)) {
                    System.out.println("Negative wt detected");
                    distance.put(edge.to, Integer.MIN_VALUE);
                }
            }
        }
        return distance;
    }
}
