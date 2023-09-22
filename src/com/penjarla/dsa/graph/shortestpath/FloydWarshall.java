package com.penjarla.dsa.graph.shortestpath;

import com.penjarla.dsa.graph.repr.Graph;

import java.util.List;

/**
 * FloydWarshall, this helps in figuring out shortest distance b/w any two nodes
 * TimeComplexity: O(V^3)
 * SpaceComplexity: O(V^2)
 */
public class FloydWarshall {
    public Graph graph;

    public int[][] shortestPath() {
        List<List<Integer>> adjMatrix = graph.adjMatrix;
        int V = adjMatrix.size();
        int[][] distance = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                distance[i][j] = adjMatrix.get(i).get(j);
            }
        }
        // consider k as a node that can be part of path from i to j
        // so for every i, j possibility any k can be intermediatary node
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        printDistanceMatrix(distance);
        return distance;
    }

    public void printDistanceMatrix(int[][] distance) {
        int V = graph.adjMatrix.size();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (distance[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(distance[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
