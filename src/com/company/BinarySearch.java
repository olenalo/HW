package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int[] array, int leftIndex, int rightIndex, int targetValue) {
        if (rightIndex >= leftIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (targetValue == array[middleIndex]) {
                return middleIndex;
            }
            // If so, then it can only be in the left side
            if (targetValue < array[middleIndex]) {
                return binarySearch(array, leftIndex, middleIndex-1, targetValue);
            }
            return binarySearch(array, middleIndex+1, rightIndex, targetValue);
        }
        // No element found
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {4, 9, 7, 10, 1, 11, 5};
        // int targetValue = 10; // 10; 11; 4; 44

        Arrays.sort(array);
        System.out.println("Sorted array: ");
        for (int el: array) {
            System.out.print(el + " ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the target value: ");
        int targetValue = scanner.nextInt();

        int index = binarySearch(array, 0, array.length-1, targetValue);
        if (index == -1) {
            System.out.println("There's no such element as " + targetValue + " in the initial array.");
        } else {
            System.out.println("The index of a target value " + targetValue + " is " + index);
        }

    }
}
