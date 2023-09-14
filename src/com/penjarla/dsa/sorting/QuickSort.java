package com.penjarla.dsa.sorting;

import java.util.List;

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

//    private int partition(int left, int right) {
//        int pivot = this.list.get(right);
//
//        int index = left - 1;
//        int startIndex = left;
//        int endIndex = right - 1;
//        while (startIndex <= endIndex) {
//            int currentElement = this.list.get(startIndex);
//            if (currentElement < pivot) {
//                index++;
//                this.list.set(startIndex, this.list.get(index));
//                this.list.set(index, currentElement);
//            }
//            startIndex++;
//        }
//        this.list.set(right, this.list.get(index + 1));
//        this.list.set(index + 1, pivot);
//        return index + 1;
//    }

    public int partition(int left, int right) {
        int pivot = this.list.get(left);
        int i = left;
        int j = right;
        while (i < j) {
            while (pivot >= list.get(i) && i < right) {
                i++;
            }
            while (pivot < list.get(j) && j > left) {
                j--;
            }
            if (i < j) {
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        list.set(left, list.get(j));
        list.set(j, pivot);
        return j;
    }

}
