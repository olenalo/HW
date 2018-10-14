package com.company;

/**
 * HW4.2 by OPersian.
 *
 * Reference:
 *     https://en.wikipedia.org/wiki/Merge_sort
 */

public class MergeSort {

    private static void sort(int array[], int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middleIndex = (lowerIndex + higherIndex) / 2;
            // Sort each half
            sort(array, lowerIndex, middleIndex);
            sort(array , middleIndex + 1, higherIndex);
            merge(array, lowerIndex, middleIndex, higherIndex);
        }
    }

    private static void merge(int array[], int lowerIndex, int midIndex, int higherIndex) {
        // Better create two separate temporary arrays (easier to write and read)
        int leftArraySize = midIndex - lowerIndex + 1;
        int rightArraySize = higherIndex - midIndex;

        // Populate temporary sub-arrays
        int leftSubArray[] = new int[leftArraySize];
        int rightSubArray[] = new int[rightArraySize];
        for (int i = 0; i < leftArraySize; i++) {
            leftSubArray[i] = array[lowerIndex + i];
        }
        for (int i = 0; i < rightArraySize; i++) {
            rightSubArray[i] = array[midIndex + i + 1];
        }

        // Merge sub-arrays
        int l = 0;
        int r = 0;
        while (l < leftArraySize && r < rightArraySize) {
            if (leftSubArray[l] <= rightSubArray[r]) {
                array[lowerIndex] = leftSubArray[l];
                l++;
            } else {
                array[lowerIndex] = rightSubArray[r];
                r++;
            }
            lowerIndex++;
        }

        handleRemainingElements(array, lowerIndex, leftSubArray, l);
        handleRemainingElements(array, lowerIndex, rightSubArray, r);
    }

    private static void handleRemainingElements(int[] array, int index, int[] subArray, int subIndex) {
//        for (int i = subIndex; i < subArray.length; i++) {
//            array[index] = subArray[i];
//            index++;
//        }
        while (subIndex < subArray.length)
        {
            array[index] = subArray[subIndex];
            subIndex++;
            index++;
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