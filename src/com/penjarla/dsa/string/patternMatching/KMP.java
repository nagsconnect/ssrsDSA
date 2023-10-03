package com.penjarla.dsa.string.patternMatching;

import java.util.ArrayList;
import java.util.List;

/*
    KMP, algo searches for pattern string in the given string.
    usually naive way of search a pattern in a string takes O(m * n) given m: len(pattern), n: len(str)
    Using KMP algo, it is much faster as it takes O(n + m)

    how? it utilizes the concept of longest proper prefix

 */
public class KMP {

    public List<Integer> searchPattern(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[] pi = calculatePi(p);
        List<Integer> index = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = j > 0 ? pi[j - 1] : 0;

                if (j == 0) {
                    i++;
                }
            }
            if (j == m) {
                index.add(i - j);
                j = 0;
            }
        }
        return index;
    }

    private int[] calculatePi(String p) {
        int m = p.length();
        int[] pi = new int[m];

        int i = 1;
        int j = 0;
        while (i < m) {
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            } else {
                if (j > 0) {
                    j = pi[j - 1];
                } else {
                    j = 0;
                }
                if (p.charAt(i) == p.charAt(j)) {
                    j++;
                }
            }
            pi[i] = j;
            i++;
        }
        for (i = 0; i < m; i++) {
            System.out.print(pi[i] + " ");
        }
        return pi;
    }
}
