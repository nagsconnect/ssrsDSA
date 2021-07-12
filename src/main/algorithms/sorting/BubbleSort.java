package main.algorithms.sorting;

import java.util.List;

public class BubbleSort {

    List<Integer> list;

    public BubbleSort(List<Integer> list) {
        this.list = list;
    }

    public void sort() {
        for (int index = 0; index < list.size() - 1; index++) {
            boolean isSwapped = false;
            for (int secIndex = 0; secIndex < list.size() - index - 1; secIndex++) {
                if (list.get(secIndex) > list.get(secIndex + 1)) {
                    int temp = list.get(secIndex);
                    list.set(secIndex, list.get(secIndex + 1));
                    list.set(secIndex + 1, temp);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }
}
