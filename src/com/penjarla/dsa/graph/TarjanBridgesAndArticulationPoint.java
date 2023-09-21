package com.penjarla.dsa.graph;

import com.penjarla.dsa.graph.repr.Graph;
import com.penjarla.dsa.graph.repr.Node;
import javafx.util.Pair;

import java.util.*;

/*
Tarjan algo, helps in finding the articulation points in a graph.
- An articulation point is a vertex which is a weak point that divides a graph into two connected graphs
- TimeComplexity: O(V + E)
- SpaceComplexity: O(V) for visited nodes tracking

1---3---- 4
|  /      |
| /       |
2         5

here 3 is a articulation point as if above graph considered as a n/w graph
if 3 is down
1        4
|        |
|        |
2        5
and here 4 is also a articulation point

1---3
|  /
| /
2         5

Alternative to tarjan algo, simple way to find articulation points is by finding # of connected components by dfs when a vertex removed
repeating this process for each vertex once, helps to figure out which is a articulation point in a graph
TimeComplexity: O(V * (V + E))
SpaceComplexity: O(V)
refer: https://codeforces.com/blog/entry/71146?source=post_page-----a3cc033b5feb--------------------------------

An articulation point 'U'
1. All paths from V to A in a graph 'G' happen through U
2. U as root of the graph with more than one child causing removal of U into multiple connected graphs

here condition(1) can be broken down into below subconditons
* U is articulation point if there is no vertex V to reach A without using U
* U is articulation point if root of some cycle in dfs traversal without any back edges

*/

public class TarjanBridgesAndArticulationPoint {

    public Graph graph;

    int time = 0;
    int bridgeTime = 0;

    public Set<Node> findArticulationPoints() {
        time = 0;
        Set<Node> articulationPoints = new HashSet<>();
        Map<Node, Integer> discoveryTime = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Integer> low = new HashMap<>();
        for (Node node : graph.adjList.keySet()) {
            if (!visited.contains(node)) {
                dfsArticulationPoints(articulationPoints, visited, discoveryTime, low, node, null);
            }
        }
        return articulationPoints;
    }

    private void dfsArticulationPoints(Set<Node> articulationPoints, Set<Node> visited, Map<Node, Integer> discoveryTime, Map<Node, Integer> low, Node cur, Node parent) {
        int children = 0;
        visited.add(cur);
        time++;
        discoveryTime.put(cur, time);
        low.put(cur, time);
        for (Node child : graph.adjList.get(cur)) {
            if (!visited.contains(child)) {
                children++;
                dfsArticulationPoints(articulationPoints, visited, discoveryTime, low, child, cur);

                // V to reach A needs to go through U and no other way then U is articulation point
                // if V ancestor's time > U discovery time, V can't be reached without U
                // as we are checking for U, we use discovery time for U and remaining all use low
                if (parent != null && low.get(child) >= discoveryTime.get(cur)) {
                    articulationPoints.add(cur);
                }
                // low[child] can be ancestor of curNode
                int lowVal = Math.min(low.get(cur), low.get(child));
                low.put(cur, lowVal);

            } else if (parent != child){
                // here checks for a backward edge, so if child is already visited
                // then child discovered earlier than curNode, so the least discovery time considered
                int lowVal = Math.min(low.get(cur), discoveryTime.get(child));
                low.put(cur, lowVal);
            }
        }
        if (parent == null && children > 1) {
            articulationPoints.add(cur);
        }
    }

    public List<Pair<Node, Node>> findBridges() {
        bridgeTime = 0;
        List<Pair<Node, Node>> bridges = new ArrayList<>();
        Map<Node, Integer> low = new HashMap<>();
        Map<Node, Integer> discoveryTime = new HashMap<>();
        for (Node node : graph.adjList.keySet()) {
            if (!discoveryTime.containsKey(node)) {
                dfsBridges(bridges, discoveryTime, low, node, null);
            }
        }
        return bridges;
    }

    private void dfsBridges(List<Pair<Node, Node>> bridges, Map<Node, Integer> discoveryTime, Map<Node, Integer> low, Node cur, Node parent) {
        bridgeTime++;
        low.put(cur, bridgeTime);
        discoveryTime.put(cur, bridgeTime);
        for (Node child : graph.adjList.get(cur)) {
            if (child == parent) {
                continue;
            }
            if (!discoveryTime.containsKey(child)) {
                dfsBridges(bridges, discoveryTime, low, child, cur);

                // if U discovered first than its child V lowest discovery time then it is bridge as there is no way to reach child V
                if (discoveryTime.get(cur) < low.get(child)) {
                    bridges.add(new Pair<>(cur, child));
                }
                // recompute lowest discovery time for current node
                int lowVal = Math.min(low.get(cur), low.get(child));
                low.put(cur, lowVal);
            } else {
                // child V already discovered then recompute lowest discovery for U using discoveryTime of V
                int lowVal = Math.min(low.get(cur), discoveryTime.get(child));
                low.put(cur, lowVal);
            }
        }
    }
}
