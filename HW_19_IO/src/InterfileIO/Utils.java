package InterfileIO;

import java.util.Scanner;

public class Utils {

    public static String[] getUserDefinedData() {
        System.out.println("Please type: \n" +
                "(1) name of an input file e.g. 'hw19_custom_data_input.txt', \n" +
                "(2) name of an output file, e.g. 'hw19_custom_data_output.txt', and \n" +
                "(3) number of lines to read from the input file (and to write to the output).");
        try (Scanner scanner = new Scanner(System.in)) {
            String first = scanner.next();
            String second = scanner.next();
            String linesNumber = scanner.next();
            return new String[]{first, second, linesNumber};
        }
    }

}
