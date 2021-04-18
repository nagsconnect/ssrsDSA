package datastructure;

import entity.GraphEdge;
import entity.GraphNode;
import lombok.Builder;

import java.util.*;

/** TODO  documentation
 * This class represents a graph and its representation
 *
 */
@Builder
public class Graph {
    int V;
    List<List<GraphNode>> adjList;
    List<List<Integer>> adjMatrix;
    List<GraphEdge> edgeList;

    public Graph() {}

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
            if (visited.contains(end)) {
                break;
            }
            List<GraphNode> list = adjList.get(node);
            for(GraphNode graphNode:list) {
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
        int connectedComponents = 0;
        Set<Integer> visited = new HashSet<>();
        List<Integer> dfsNodes = new ArrayList<>();
        for(int node = 0; node < V; node++) {
            if (!visited.contains(node)) {
                connectedComponents++;
                dfsUtil(node, dfsNodes, visited);
            }
        }
        return dfsNodes;
    }

    private void dfsUtil(int node, List<Integer> dfsNodes, Set<Integer> visited) {
        visited.add(node);
        dfsNodes.add(node);
        for (GraphNode graphNode:adjList.get(node)) {
            int to = graphNode.getTo();
            if (!visited.contains(to)) {
                dfsUtil(to, dfsNodes, visited);
            }
        }
    }

    public List<Integer> topologicalSort() {
        Set<Integer> visited = new HashSet<>();
        List<Integer> ordering = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            ordering.add(stack.pop());
        }
        return ordering;
    }

    private void topologicalSortUtil(int node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);
        List<GraphNode> list = adjList.get(node);
        for (GraphNode graphNode:list) {
            int to = graphNode.getTo();
            if (!visited.contains(to)) {
                topologicalSortUtil(to, visited, stack);
            }
        }
        stack.push(node);
    }
}
