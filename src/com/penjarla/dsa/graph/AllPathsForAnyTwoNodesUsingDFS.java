package com.penjarla.dsa.graph;

import java.util.*;

public class AllPathsForAnyTwoNodesUsingDFS {
    public List<List<Integer>> getAllPaths(Map<Integer, List<Integer>> graph, int src, int dest) {
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        path.add(src);
        List<List<Integer>> paths = new ArrayList<>();
        getPathUsingDFS(graph, paths, path, visited, src, dest);
        return paths;
    }

    // using backtracking we can get all paths
    private void getPathUsingDFS(Map<Integer, List<Integer>> graph, List<List<Integer>> paths, List<Integer> path, Set<Integer> visited, int cur, int dest) {
        if (cur == dest) {
            paths.add(new ArrayList<>(path));
            return;
        }
        visited.add(cur);
        for (Integer neighbor : graph.get(cur)) {
            if (!visited.contains(neighbor)) {
                path.add(neighbor);
                getPathUsingDFS(graph, paths, path, visited, neighbor, dest);
                path.remove(neighbor);
            }
        }
        visited.remove(cur);
    }

}
