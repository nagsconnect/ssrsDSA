package com.penjarla.dsa.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFSTraversal {

    private Map<Integer, List<Integer>> adjList;

    public DFSTraversal(Map<Integer, List<Integer>> adjList) {
        this.adjList = adjList;
    }

    /*
        DFS traversal, to find all paths between two nodes
        also to check connectivity, # of connected components..
        TimeComplexity: O(V + E), V: nodes in the graph, E: Edges in the graph
        SpaceComplexity: O(V), visited array, recursion stack
     */
    public int connectedComponents() {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer node : adjList.keySet()) {
            if (!visited.contains(node)) {
                count++;
                dfsUtil(node, visited);
            }
        }
        return count;
    }

    private void dfsUtil(Integer node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }
        for (Integer toNode : adjList.get(node)) {
            if (!visited.contains(toNode)) {
                visited.add(toNode);
                dfsUtil(toNode, visited);
            }
        }
    }
}
