package com.penjarla.dsa.graph;

import java.util.*;

/*
Topological Sort, determines the order of the dependencies utilizing the DFS approach.
TimeComplexity: O(V + E)
SpaceComplexity: O(V)
 */
public class TopologicalSortUsingDFS {
    Map<Integer, List<Integer>> adjList;
    public List<Integer> topologicalSort() {
        Set<Integer> visited = new HashSet<>();
        List<Integer> ordering = new ArrayList<>();
        for(int i = 0; i < adjList.size(); i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                topologicalSortUtil(i, visited, ordering);
            }
        }
        // reverse the ordering as dfs approach first adds the last dependency..
        Collections.reverse(ordering);
        return ordering;
    }

    private void topologicalSortUtil(int node, Set<Integer> visited, List<Integer> ordering) {
        if (visited.contains(node)) {
            return;
        }
        List<Integer> list = adjList.get(node);
        for (Integer toNode : list) {
            if (!visited.contains(toNode)) {
                visited.add(toNode);
                topologicalSortUtil(toNode, visited, ordering);
            }
        }
        ordering.add(node);
    }
}
