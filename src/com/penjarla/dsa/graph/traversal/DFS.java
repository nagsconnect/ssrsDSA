package com.penjarla.dsa.graph.traversal;

import com.penjarla.dsa.graph.repr.Node;

import java.util.*;

/*
DFS, a traversal of graph that walks through all nodes/vertices in depth-wise.
TimeComplexity: O(V + E), as we visit each and every node/vertex and from vertex each and every edge from it.
SpaceComplexity: O(V) for visited set, recursion stack
 */
public class DFS {
    Map<Integer, List<Integer>> adjList;
    
    public List<Integer> dfs() {
        if (adjList.size() == 0) {
            return new ArrayList<>();
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> dfsNodes = new ArrayList<>();
        for(int node = 0; node < adjList.size(); node++) {
            if (!visited.contains(node)) {
                dfsUtil(node, dfsNodes, visited);
            }
        }
        return dfsNodes;
    }

    private void dfsUtil(int node, List<Integer> dfsNodes, Set<Integer> visited) {
        visited.add(node);
        dfsNodes.add(node);
        for (Integer toNode:adjList.get(node)) {
            if (!visited.contains(toNode)) {
                dfsUtil(toNode, dfsNodes, visited);
            }
        }
    }
}
