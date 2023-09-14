package com.penjarla.dsa.graph.repr;

import java.util.*;

/** TODO  documentation
 * This class represents a graph and its representation
 *
 */
public class Graph {
    int V;
    List<List<Node>> adjList;
    List<List<Integer>> adjMatrix;
    List<Edge> edgeList;

    public List<Integer> bfs(int start, int end) {
        if (V == 0) {
            return new ArrayList<>();
        }
        List<Integer> bfsNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Node> list = adjList.get(node);
            for(Node graphNode:list) {
                int toNode = graphNode.getTo();
                if (!visited.contains(toNode)) {
                    visited.add(toNode);
                    bfsNodes.add(toNode);
                    queue.add(toNode);
                }
            }
        }
        if (visited.contains(end)) {
            return bfsNodes;
        }
        return new ArrayList<>();
    }

    public List<Integer> dfs() {
        if (V == 0) {
            return new ArrayList<>();
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> dfsNodes = new ArrayList<>();
        for(int node = 0; node < V; node++) {
            if (!visited.contains(node)) {
                dfsUtil(node, dfsNodes, visited);
            }
        }
        return dfsNodes;
    }

    private void dfsUtil(int node, List<Integer> dfsNodes, Set<Integer> visited) {
        visited.add(node);
        dfsNodes.add(node);
        for (Node graphNode:adjList.get(node)) {
            int to = graphNode.getTo();
            if (!visited.contains(to)) {
                dfsUtil(to, dfsNodes, visited);
            }
        }
    }
}
