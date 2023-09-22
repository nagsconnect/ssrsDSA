package com.penjarla.dsa.graph.mst;

import com.penjarla.dsa.graph.repr.Edge;
import com.penjarla.dsa.graph.repr.Graph;
import com.penjarla.dsa.graph.repr.Node;
import javafx.util.Pair;

import java.util.*;

/*
MST, is a spanning tree with minimum cost.
Spanning Tree, T that is having all nodes from G and the edges of T are part of G
refer: https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/

here cost of a spanning tree T, is the sum of the cost of all edges in T

Some of the applications of MST are
- travelling salesman problem,
- cluster analysis
- handwriting recognition
- multi-terminal minimum cut problem
- image segmentation

In Prim's algorithm, for a undirected wt graph G
- determining a MST using adjacencyMatrix or adjList
- TimeComplexity: O(ElogV)
- SpaceComplexity: O(V)
 */
public class Prim {
    public static int DEFAULT_SRC = 0;

    public Graph graph;

    public void mstUsingAdjList() {
        Map<Node, List<Edge>> adjList = graph.wtAdjList;
        Map<Node, Integer> key = new HashMap<>();
        Map<Node, Node> parent = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        // sort based on node's key value
        PriorityQueue<Pair<Node, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Node, Integer>>() {
            @Override
            public int compare(Pair<Node, Integer> pair1, Pair<Node, Integer> pair2) {
                return pair1.getValue() - pair2.getValue();
            }
        });

        Node src = graph.nodes.get(DEFAULT_SRC);
        queue.offer(new Pair<>(src, 0));
        key.put(src, 0);

        while (!queue.isEmpty()) {
            Pair<Node, Integer> curPair = queue.poll();
            Node curNode = curPair.getKey();

            if (visited.contains(curNode)) {
                continue;
            }
            visited.add(curNode);
            for (Edge edge : adjList.get(curNode)) {
                if (!visited.contains(edge.to)) {
                    Node destination = edge.to;
                    int newKey = edge.weight;

                    if (key.getOrDefault(destination, Integer.MAX_VALUE) > newKey) {
                        queue.offer(new Pair<>(destination, newKey));
                        parent.put(destination, curNode);
                        key.put(destination, newKey);
                    }
                }
            }
        }
    }
}
