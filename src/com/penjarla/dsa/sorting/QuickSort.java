package com.penjarla.dsa.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class QuickSort {

    List<Integer> list;

    public QuickSort(List<Integer> list) {
        this.list = list;
    }

    public void sort() {
        divideAndSort(0, list.size() - 1);
    }

    private void divideAndSort(int left, int right) {
        if (left < right) {
            int partitionIndex = partition(left, right);

            divideAndSort(left, partitionIndex - 1);
            divideAndSort(partitionIndex + 1, right);
        }
    }

    private int partition(int left, int right) {
        int pivot = this.list.get(right);

        int index = left - 1;
        int startIndex = left;
        int endIndex = right - 1;
        while (startIndex <= endIndex) {
            int currentElement = this.list.get(startIndex);
            if (currentElement < pivot) {
                index++;
                this.list.set(startIndex, this.list.get(index));
                this.list.set(index, currentElement);
            }
            startIndex++;
        }
        this.list.set(right, this.list.get(index + 1));
        this.list.set(index + 1, pivot);
        return index + 1;
    }

}
