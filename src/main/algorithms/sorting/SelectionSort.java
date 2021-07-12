package main.algorithms.sorting;

import java.util.List;

public class SelectionSort {

    List<Integer> list;

    public SelectionSort(List<Integer> list) {
        this.list = list;
    }

    public void sort() {
        for (int index = list.size() - 1; index >= 0; index--) {
            int secIndex = 0;
            int maxIndex = index;
            for (; secIndex < index; secIndex++) {
                if (list.get(maxIndex) < list.get(secIndex)) {
                    maxIndex = secIndex;
                }
            }
            int curElement = list.get(index);
            list.set(index, list.get(maxIndex));
            list.set(maxIndex, curElement);
        }
    }
}