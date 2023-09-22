package com.penjarla.dsa.graph.shortestpath;

import java.util.*;

/*
Assuming there was a grid, with each cell either empty or with a block, to reach from start to end,
find the shortest path.

In the grid, each cell is a node and left, right, up, down allowed moments
a block cell represented by -1
a empty cell represented by 0
 */
public class ShortestPathInGrid {

    private int[][] graph;

    /*
    Using prev array can store the path and that gives the route from (sx, sy) to (ex, ey)
     */
    public int getShortestDistance(int sx, int sy, int ex, int ey) {
        int minDistance = 0;
        List<Integer> pathX = new ArrayList<>();
        List<Integer> pathY = new ArrayList<>();
        Deque<Integer> queueX = new ArrayDeque<>();
        Deque<Integer> queueY = new ArrayDeque<>();
        int rows = graph.length;
        int cols = graph[0].length;
        boolean[][] visited = new boolean[rows][cols];
        visited[sx][sy] = true;
        queueX.offerLast(sx);
        queueY.offerLast(sy);
        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int curLayerSize = queueX.size();
            while (curLayerSize > 0) {
                int x = queueX.pollFirst();
                int y = queueY.pollFirst();
                if (x == ex && y == ey) {
                    return minDistance;
                }
                if (y + 1 < cols && graph[x][y + 1] != -1 && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    queueX.offerLast(x);
                    queueY.offerLast(y + 1);
                }
                if (x + 1 < rows && graph[x + 1][y] != -1 && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    queueX.offerLast(x + 1);
                    queueY.offerLast(y);
                }
                if (y - 1 >= 0 && graph[x][y - 1] != -1 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    queueX.offerLast(x);
                    queueY.offerLast(y - 1);
                }
                if (x - 1 >= 0 && graph[x - 1][y] != -1 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    queueX.offerLast(x - 1);
                    queueY.offerLast(y);
                }
                curLayerSize--;
            }
            minDistance++;
        }
        return -1;
    }
}
