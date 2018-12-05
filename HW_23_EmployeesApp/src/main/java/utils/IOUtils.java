package utils;

import java.util.Scanner;

public class IOUtils {

    public static int getHireYear() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a year of interest employees were hired in: ");
            return scanner.nextInt();
        }
    }

}
