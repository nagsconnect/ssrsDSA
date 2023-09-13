package com.penjarla.dsa.unionFind;

import java.util.Arrays;

/*
    UnionFind, below uses path compression and Union by rank approaches.
 */
public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        this.parent = new int[size];
        this.rank = new int[size];

        for (int index = 0; index < size; index++) {
            parent[index] = index;
            rank[index] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            int rankX = rank[x];
            int rankY = rank[y];
            if (rankX < rankY) {
                parent[parentX] = parentY;
            } else if (rankX > rankY) {
                parent[parentY] = parentX;
            } else {
                parent[parentY] = parentX;
                rank[x]++;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
