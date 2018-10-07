package com.company;
/**
 * HW4.1 by OPersian.
 *
 * Reference:
 *     https://en.wikipedia.org/wiki/Quicksort
 */

public class QuickSort {

    private static void swapElements(int[] array, int i, int j) {
        int tempElement = array[i];
        array[i] = array[j];
        array[j] = tempElement;
    }

    private static int partition(int array[], int lowerIndex, int higherIndex) {
        int pivotElement = array[higherIndex];
        int i = lowerIndex - 1;
        for (int j = lowerIndex; j < higherIndex; j++) {
            if (array[j] <= pivotElement) {
                i++;
                swapElements(array, i, j);
            }
        }
        swapElements(array, i + 1, higherIndex);
        return i + 1;
    }

    private static void sort(int matrix[], int lo, int hi) {
        if (lo < hi)
        {
            int pivotIndex = partition(matrix, lo, hi);
            sort(matrix, lo, pivotIndex - 1);
            sort(matrix, pivotIndex + 1, hi);
        }
    }

    public static void main(String[] args) {
        // Examples to try:
        /*
          {7, 4, 1}
          {8, 7, 4, 3, 2}
          {1, 4, 7, 3, 10, 2, 6, 5, 9}
          {1, 4, 7, 3, 10, 2, 6, 5, 9, 8}
          {1, 4, 7, 3, 10, 2, 6, 5, 9, 8, 10}
         */
        int[] array = {1, 4, 7, 3, 10, 2, 6, 5, 9, 8, 10};

        sort(array, 0, array.length - 1);

        for (int el: array) {
            System.out.print(el + " ");
        }

    }

}
