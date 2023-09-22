package com.penjarla.dsa.graph.mst;

import com.penjarla.dsa.graph.repr.Edge;
import com.penjarla.dsa.graph.repr.Graph;
import com.penjarla.dsa.graph.unionFind.UnionFind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
MST, is a spanning tree with minimum cost.
Spanning Tree, T that is having all nodes from G and the edges of T are part of G

here cost of a spanning tree T, is the sum of the cost of all edges in T

Some of the applications of MST are
- travelling salesman problem,
- cluster analysis
- handwriting recognition
- multi-terminal minimum cut problem
- image segmentation

In Kruskal's algorithm, for a undirected wt graph G
- exactly N - 1 edges are required for MST given N is # of vertices/nodes of G
- Here an edge with smallest wt considered everyTime
        -  take this smallest edge and try adding it to MST
        -  ignore the edge if it forms a cycle
        -   repeat above step with all edges until either all edges are visited or all nodes are visited whichever happens first
- above algo happens in a greedy way
- TimeComplexity: O(ElogE)
- SpaceComplexity: O(V)
 */
public class Kruskal {

    public Graph graph;

    public List<Edge> minSpanningTree() {
        List<Edge> mstRoute = new ArrayList<>();
        List<Edge> edgeList = graph.edgeList;
        edgeList.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.weight - edge2.weight;
            }
        });
        UnionFind unionFind = new UnionFind(graph.nodes.size());
        for (Edge edge : edgeList) {
            // if x, y have same parent i.e already connected, then this edge forms a cycle so ignore
            int x = edge.from.getValue();
            int y = edge.to.getValue();
            if (!unionFind.connected(x, y)) {
                mstRoute.add(edge);
                unionFind.union(x, y);
            }
            // total number of edges required are V - 1 for V nodes then no need to check remaining
            if (mstRoute.size() == graph.nodes.size() - 1) {
                break;
            }
        }
        return mstRoute.size() == graph.nodes.size() - 1 ? mstRoute : null;
    }

    public int minSpanningTreeCost() {
        List<Edge> mstRoute = minSpanningTree();
        // no such route exists
        if (mstRoute == null) {
            return -1;
        }
        int minCost = 0;
        for (Edge edge : mstRoute) {
            minCost += edge.weight;
        }
        return minCost;
    }
}
