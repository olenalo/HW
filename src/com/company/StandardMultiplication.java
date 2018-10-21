package com.company;

import java.util.Scanner;

public class StandardMultiplication {

    // TODO: move to utils (DRY)
    public static int getSize(long number) {
        int basePower = 0;
        while (number != 0) {
            basePower++;
            number /= 10;
        }
        return basePower;
    }

    public static long multiplyByGradeSchoolApgorithm(long x, long y) {
        // Long multiplication, or Grade School multiplication, or Standard Multiplication
        // Ref.: https://en.wikipedia.org/wiki/Multiplication_algorithm
        if (x < 10 || y < 10) {
            return x * y;
        }
        long minValue = Math.min(x, y);
        long maxValue = Math.max(x, y);

        int xSize = getSize(x);
        int ySize = getSize(y);
        int minSize = Math.min(xSize, ySize);

        // TODO: this isn't really a Grade School; change it
        long result = 0;
        for (int i = 1; i <= minSize; i++) {
            long multiplier = (long) Math.pow(10, i);
            long remainder = ((minValue % multiplier) / (multiplier/10)) * (multiplier/10);
            result += maxValue * remainder;
        }

        return result;
    }

    public static void main(String[] args) {
        /*
        long x = 23958233;
        long y = 5830;
        */
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two long numbers\n");
        long x = scan.nextLong();
        long y = scan.nextLong();

        // TODO: change to BigInteger so that we can compare running time (big enough numbers should be)

        long startTime1 = System.currentTimeMillis();
        long result1 = x*y;
        System.err.println(System.currentTimeMillis() - startTime1);

        long startTime2 = System.currentTimeMillis();
        long result2 = StandardMultiplication.multiplyByGradeSchoolApgorithm(x, y);
        System.err.println(System.currentTimeMillis() - startTime2);

        long startTime3 = System.currentTimeMillis();
        long result3 = KaratsubaAlgorithm.multiplyByKaratsubaAlgorithm(x, y);
        System.err.println(System.currentTimeMillis() - startTime3);

        System.out.printf("The product of %d and %d is %d\n", x, y, result1);
        System.out.printf("The product of %d and %d is %d (Standard Algorithm)\n", x, y, result2);
        System.out.printf("The product of %d and %d is %d (Karatsuba Algorithm)\n", x, y, result3);
        System.out.println(result1 == result2);
    }

}
