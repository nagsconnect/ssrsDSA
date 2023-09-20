package com.penjarla.dsa.graph;

import com.penjarla.dsa.graph.repr.Edge;
import com.penjarla.dsa.graph.repr.Graph;
import com.penjarla.dsa.graph.repr.Node;
import javafx.util.Pair;

import java.util.*;

/**
 * Dijkstra algorithm helps in finding out the shortest path to all nodes from a single node.
 * - All the weights of the nodes must be non-negative
 * - TimeComplexity: O((V + E)(LogV)) = O(ELogV) where V=# of nodes, E=# of edges
 *  Here, O(V + E) time complexity to parse all edges, nodes for shortest path using BFS, O(logV) for minHeap operations
 * - SpaceComplexity: O(V)
 */
public class Dijkstra {
    public Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public Map<Node, Integer> shortestPath(Node from, Map<Node, Node> prev) {
        Map<Node, List<Edge>> adjList = graph.adjList;
        Map<Node, Integer> distance = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<Pair<Node, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Node, Integer>>() {
            @Override
            public int compare(Pair<Node, Integer> pair1, Pair<Node, Integer> pair2) {
                return pair1.getValue() - pair2.getValue();
            }
        });
        for (Node node : adjList.keySet()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.put(from, 0);
        queue.add(new Pair<>(from, 0));
        while (!queue.isEmpty()) {
            Pair<Node, Integer> cur = queue.poll();
            Node curNode = cur.getKey();
            visited.add(curNode);
            int curDistance = cur.getValue();
            // curNode can be reached via different path in smaller distance than curDistance
            if (distance.get(curNode) < curDistance) {
                continue;
            }
            for (Edge edge : adjList.get(curNode)) {
                // relaxation
                Node node = edge.to;
                if (!visited.contains(node)) {
                    int newDistance = distance.get(curNode) + edge.weight;
                    // it is shorter to reach node from curNode than its distance recorded
                    if (distance.get(node) > newDistance) {
                        prev.put(node, curNode);
                        distance.put(node, newDistance);
                        queue.add(new Pair<>(node, newDistance));
                    }
                }
            }
        }
        return distance;
    }

    public List<Node> shortestPath(Node from, Node to) {
        Map<Node, Node> prev = new HashMap<>();
        Map<Node, Integer> distance = shortestPath(from, prev);
        List<Node> shortestPath = new ArrayList<>();
        Node prevNode = to;
        while (prevNode != null) {
            shortestPath.add(0, prevNode);
            if (prevNode == from) {
                break;
            }
            prevNode = prev.get(prevNode);
        }
        return shortestPath;
    }
}
