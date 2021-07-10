package algorithms.sorting;

import main.algorithms.sorting.InsertionSort;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSortTest {

    @Test
    public void test_InsertionSorting_WhenListIsUnsortedRandomly() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 1, 7, 15, 2, 7, 9));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        InsertionSort insertionSort = new InsertionSort(list);
        insertionSort.sort();
        Assert.assertEquals(list, sortedList);
    }

    @Test
    public void test_InsertionSorting_WhenListIsSorted_IncreasingOrder() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        InsertionSort insertionSort = new InsertionSort(list);
        insertionSort.sort();
        Assert.assertEquals(list, sortedList);
    }

    @Test
    public void test_InsertionSorting_WhenListIsSorted_DecreasingOrder() {
        List<Integer> list = new ArrayList<>(Arrays.asList(15, 9, 7, 7, 4, 2, 1));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        InsertionSort insertionSort = new InsertionSort(list);
        insertionSort.sort();
        Assert.assertEquals(list, sortedList);
    }
}
