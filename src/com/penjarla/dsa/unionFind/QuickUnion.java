package com.penjarla.dsa.unionFind;

public class QuickUnion {
    int[] parent;

    public QuickUnion(int size) {
        this.parent = new int[size];

        for (int index = 0; index < size; index++) {
            parent[index] = index;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY)
            parent[parentY] = parentX;
    }
}
