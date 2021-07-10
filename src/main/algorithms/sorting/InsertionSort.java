package main.algorithms.sorting;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class InsertionSort {
    List<Integer> list;

    public InsertionSort(List<Integer> list) {
        this.list = list;
    }

    /**
     * This method sorts the given list of integers using insertion sort technique.
     * Current element is placed in its sorted position by checking all elements
     * present in the left side of the list. The position of current element is
     * determined by moving left side of the list from previous index and stop
     * at position if current element greater than element at check index.
     */
    public void sort() {
        long startTime = System.currentTimeMillis();
        for (int index = 1; index < list.size(); index++) {
            int curElement = list.get(index);
            int secIndex = index - 1;
            for (; secIndex >= 0; secIndex--) {
                if (curElement < list.get(secIndex)) {
                    list.set(secIndex + 1, list.get(secIndex));
                } else {
                    break;
                }
            }
            list.set(secIndex + 1, curElement);
        }
        long endTime = System.currentTimeMillis();
        log.info("[Insertion Sort] Runtime taken for given list :" + (endTime - startTime));
    }
}