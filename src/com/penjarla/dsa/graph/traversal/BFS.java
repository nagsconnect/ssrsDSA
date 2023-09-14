package com.penjarla.dsa.graph.traversal;

import java.util.*;

/*
BFS, a traversal that walks through nodes level by level.
Here given a start node it gives all nodes level by level.

TimeComplexity: O(V + E)
SpaceComplexity: O(V)
 */
public class BFS {

    Map<Integer, List<Integer>> adjList;

    public List<Integer> bfs(int start) {
        if (adjList.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> bfsNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> list = adjList.get(node);
            for(Integer toNode:list) {
                if (!visited.contains(toNode)) {
                    visited.add(toNode);
                    bfsNodes.add(toNode);
                    queue.add(toNode);
                }
            }
        }
        return new ArrayList<>();
    }
}
