package com.penjarla.dsa.graph.shortestpath;

import java.util.*;

public class ShortestPathForTwoNodesUsingBFS {

    private Map<Integer, List<Integer>> adjList;

    public ShortestPathForTwoNodesUsingBFS(Map<Integer, List<Integer>> adjList) {
        this.adjList = adjList;
    }

    /*
        BFS can be used to get the shortest path between two nodes in a graph.
        TimeComplexity: O(V + E)
        SpaceComplexity: O(V)
     */
    public List<Integer> shortestPath(int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> prev = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        queue.offerLast(start);
        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            if (end == node) {
                break;
            }
            List<Integer> list = adjList.get(node);
            for (Integer toNode : list) {
                if (!visited.contains(toNode)) {
                    visited.add(toNode);
                    prev.put(toNode, node);
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        Integer to = end;
        while (to != null && prev.containsKey(to)) {
            path.add(0, to);
            to = prev.get(to);
        }
        return path;
    }
}
