package algorithms.graph;

import com.penjarla.dsa.graph.repr.Edge;
import com.penjarla.dsa.graph.repr.Graph;
import com.penjarla.dsa.graph.repr.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphTest {
    public static Graph buildSampleGraph() {
        return null;
    }

    /*

        visualization of below weighted graph: to note <> represent wt b/w nodes

            0 ---<2>--- 1
            |           |
           <6>         <5>
            |           |
            2 --<6>---- 3
                      /   \
                   <10>   <15>
                    /       \
                   4 --<6>-- 5
                    \       /
                    <2>   <6>
                       \ /
                        6
     */
    public static Graph buildSampleWeightedGraph() {
        Graph graph = new Graph();
        graph.nodes = new HashMap<>();
        graph.wtAdjList = new HashMap<>();
        Map<Integer, Node> nodes = graph.nodes;
        for (int i = 0; i < 7; i++) {
            graph.nodes.put(i, new Node(i));
            graph.wtAdjList.put(nodes.get(i), new ArrayList<>());
        }
        graph.wtAdjList.get(nodes.get(0)).add(new Edge(nodes.get(0), nodes.get(1), 2));
        graph.wtAdjList.get(nodes.get(0)).add(new Edge(nodes.get(0), nodes.get(2), 6));
        graph.wtAdjList.get(nodes.get(1)).add(new Edge(nodes.get(1), nodes.get(3), 5));
        graph.wtAdjList.get(nodes.get(2)).add(new Edge(nodes.get(2), nodes.get(3), 8));
        graph.wtAdjList.get(nodes.get(3)).add(new Edge(nodes.get(3), nodes.get(4), 10));
        graph.wtAdjList.get(nodes.get(3)).add(new Edge(nodes.get(3), nodes.get(5), 15));
        graph.wtAdjList.get(nodes.get(4)).add(new Edge(nodes.get(4), nodes.get(5), 6));
        graph.wtAdjList.get(nodes.get(4)).add(new Edge(nodes.get(4), nodes.get(6), 2));
        graph.wtAdjList.get(nodes.get(5)).add(new Edge(nodes.get(5), nodes.get(6), 6));
        return graph;
    }
}
