package algorithms.sorting;

import com.penjarla.dsa.sorting.SelectionSort;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSortTest {

    @Test
    public void test_SelectionSort_WhenListIsUnsortedRandomly() {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 1, 7, 15, 2, 7, 9));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        SelectionSort selectionSort = new SelectionSort(list);
        selectionSort.sort();
        Assert.assertEquals(list, sortedList);
    }

    @Test
    public void test_SelectionSort_WhenListIsSorted_IncreasingOrder() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        SelectionSort selectionSort = new SelectionSort(list);
        selectionSort.sort();
        Assert.assertEquals(list, sortedList);
    }

    @Test
    public void test_SelectionSort_WhenListIsSorted_DecreasingOrder() {
        List<Integer> list = new ArrayList<>(Arrays.asList(15, 9, 7, 7, 4, 2, 1));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 7, 9, 15));
        SelectionSort selectionSort = new SelectionSort(list);
        selectionSort.sort();
        Assert.assertEquals(list, sortedList);
    }
}
