package com.penjarla.dsa.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

enum State {
    NEW, PROCESSING, PROCESSED
}
public class DetectCycleUsingDFS {
    // return true if there is a cycle
    public boolean isCyclePresent(int n, Map<Integer, List<Integer>> graph) {
        if (graph == null) {
            return false;
        }
        // n is the total number of vertices, creating a state array for each vertex to mark for
        State[] state = new State[n];
        Arrays.fill(state, State.NEW); //initially all are unvisited hence marking as NEW
        // there may be multiple connected components for a given graph so doing dfs for all unvisited vertex's
        for (int i = 0; i < n; i++) {
            if (state[i] == State.NEW) {
                // if cycle is detected then return true
                if (dfsUtil(graph, state, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    // dfsUtil returns true if there is a cycle
    private boolean dfsUtil(Map<Integer, List<Integer>> graph, State[] state, int cur) {
        state[cur] = State.PROCESSING; //mark cur vertex as processing i,e visited
        for (Integer neighbor : graph.get(cur)) {
            if (state[neighbor] == State.NEW) { //if neighbor is unvisited till now then further process
                if (dfsUtil(graph, state, neighbor)) // if there is a cycle then return true
                    return true;
            } else if (state[neighbor] == State.PROCESSING) {
                return true; //visited same vertex that is still in recursion stack, i.e. we reached here from same vertex so there is a cycle
            }
        }
        state[cur] = State.PROCESSED; // all the paths leading from cur vertex are visited hence this is marked as fully visited
        return false;
    }
}
