package com.company;

public class KaratsubaAlgorithm {

    public static int getBasePower(long number) {
        int basePower = 0;
        while (number != 0) {
            basePower++;
            number /= 10;
        }
        return basePower;
    }

    public static long multiplyByKaratsubaAlgorithm(long x, long y) {
        // Ref.: https://en.wikipedia.org/wiki/Karatsuba_algorithm

        int xPower = getBasePower(x);
        int yPower = getBasePower(y);

        int minPower = Math.min(xPower, yPower);

        if (minPower < 2) {
            return x * y;
        }

        long multiplier = (long) Math.pow(10, minPower - 1);

        long xFirstPart = (x - x % multiplier) / multiplier;
        long yFirstPart = (y - y % multiplier) / multiplier;

        long xSecondPart = x % multiplier;
        long ySecondPart = y % multiplier;

        long z2 = xFirstPart * yFirstPart;
        long z0 = xSecondPart * ySecondPart;
        long z1 = (xFirstPart + xSecondPart) * (yFirstPart + ySecondPart) - z2 - z0;

        return z2 * ((long) Math.pow(multiplier, 2)) +  z1 * multiplier + z0;
    }

    public static void main(String[] args) {
        // Cases:
        // x = 4,     y = 5
        // x = 40,    y = 50
        // x = 4000,  y = 5000
        // x = 40000, y = 50000
        // x = 40044, y = 50055
        // x = 40444, y = 50555 ---> 2044646420
        // x = 40444, y = 5555  ---> 224666420
        long x = 4;
        long y = 5;
        System.out.printf("The product of %d and %d is %d\n", x, y, x*y);
        System.out.printf("The product of %d and %d is %d (by Karatsuba Algorithm)", x, y, multiplyByKaratsubaAlgorithm(x, y));
    }
}
