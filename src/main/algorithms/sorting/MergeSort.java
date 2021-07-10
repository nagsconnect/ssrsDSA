package main.algorithms.sorting;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MergeSort {

    List<Integer> list;

    public MergeSort(List<Integer> list) {
        this.list = list;
    }

    public void sort() {
        divideAndSort(0, list.size() - 1);
    }

    /**
     * This method divides the list into equal halves recursively and then send divided halves to merge.
     * @param left
     * @param right
     */
    private void divideAndSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            divideAndSort(left, mid);
            divideAndSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    /**
     * This method merges two sorted lists into a single sorted list.
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int left, int mid, int right) {
        int leftArraySize = mid - left + 1;
        int rightArraySize = right - mid;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int index = 0; index < leftArraySize; index++) {
            leftArray.add(this.list.get(index + left));
        }

        for (int index = 0; index < rightArraySize; index++) {
            rightArray.add(this.list.get(index + mid + 1));
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int index = left;
        while (leftIndex < leftArraySize && rightIndex < rightArraySize) {
            if (leftArray.get(leftIndex) <= rightArray.get(rightIndex)) {
                this.list.set(index, leftArray.get(leftIndex));
                leftIndex++;
            } else {
                this.list.set(index, rightArray.get(rightIndex));
                rightIndex++;
            }
            index++;
        }

        while (leftIndex < leftArraySize) {
            this.list.set(index, leftArray.get(leftIndex));
            leftIndex++;
            index++;
        }

        while (rightIndex < rightArraySize) {
            this.list.set(index, rightArray.get(rightIndex));
            rightIndex++;
            index++;
        }
    }
}
