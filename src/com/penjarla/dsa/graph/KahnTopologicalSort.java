package com.penjarla.dsa.graph;

import java.util.*;

/*
Topological sort using Kahn's algorithm utilizes BFS traversal with indegree concept.
TimeComplexity: O(V + E)
SpaceComplexity: O(V)
 */
public class KahnTopologicalSort {

    Map<Integer, List<Integer>> adjList;

    public List<Integer> topologicalSort() {
        List<Integer> ordering = new ArrayList<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (Integer node : adjList.keySet()) {
            for (Integer toNode : adjList.get(node)) {
                indegree.put(toNode, indegree.getOrDefault(toNode, 0) + 1);
            }
        }
        for (Integer node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offerLast(node);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.pollFirst();
            ordering.add(node);
            List<Integer> edges = adjList.get(node);
            for (Integer toNode : edges) {
                if (indegree.get(toNode) > 0) {
                    indegree.put(toNode, indegree.get(toNode) - 1);
                    if (indegree.get(toNode) == 0) {
                        queue.offerLast(toNode);
                    }
                }
            }
        }
        // if the graph is not DAG then this happens
        if (ordering.size() != adjList.size()) {
            return new ArrayList<>();
        }
        return ordering;
    }
}
