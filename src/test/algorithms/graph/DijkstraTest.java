package algorithms.graph;

import com.penjarla.dsa.graph.shortestpath.Dijkstra;
import com.penjarla.dsa.graph.repr.Graph;
import com.penjarla.dsa.graph.repr.Node;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DijkstraTest {
    private Dijkstra dijkstra;
    private Graph graph;

    @BeforeClass
    public void init() {
       graph = GraphTest.buildSampleWeightedGraph();
       dijkstra = new Dijkstra(graph);
    }

    @Test
    public void getShortestPathForSampleWeightedGraph() {
        List<Node> shortestPath = dijkstra.shortestPath(graph.nodes.get(0), graph.nodes.get(6));
        List<Node> actualShortestPath = Arrays.asList(graph.nodes.get(0), graph.nodes.get(1), graph.nodes.get(3), graph.nodes.get(4), graph.nodes.get(6));
        for (Node node : shortestPath) {
            System.out.print(node.getValue() + " => ");
        }
        Assert.assertEquals(shortestPath, actualShortestPath);
    }
}
