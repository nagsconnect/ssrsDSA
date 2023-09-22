package com.penjarla.dsa.graph.unionFind;

public class QuickFind {
    int[] parent;

    public QuickFind(int size) {
        this.parent = new int[size];

        for (int index = 0; index < size; index++) {
            parent[index] = index;
        }
    }

    // O(1)
    public int find(int x) {
        return parent[x];
    }

    // O(n), given n: total # of nodes
    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            for (int index = 0; index < parent.length; index++) {
                if (parent[index] == parentY)
                    parent[index] = parentX;
            }
        }
    }

    // O(1)
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
