package InterfileIO;

import java.io.*;
import java.util.Scanner;

public class InterfileIO {

    private static String[] getUserDefinedData() {
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

    public static void write(String content, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String filename, int linesNumber) {
        if (filename == null) {
            throw new IllegalArgumentException("Input file name is not indicated.");
        }
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalArgumentException("Input file is not found.");
        }
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            if (linesNumber > reader.lines().count()) {
                throw new IllegalArgumentException("User defined lines number is bigger than the actual number");
            }
            String contentString;
            while ((contentString = reader.readLine()) != null) {
                content.append(contentString);
                content.append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void doAll(String inputFileName, String outputFileName, int linesNumber) {
        String content = read(inputFileName, linesNumber);
        write(content, outputFileName);
    }

    public static void main(String[] args) {
        String[] userDefinedData = getUserDefinedData();
        String inputFile = userDefinedData[0];  // hw19_custom_data_input.txt
        String outputFile = userDefinedData[1]; // hw19_custom_data_output.txt
        int linesNumber = Integer.valueOf(userDefinedData[2]);

        /*
        String inputFile = "hw19_custom_data_input.txt";
        String outputFile = "hw19_custom_data_output.txt";
        int linesNumber = 1;
        */

        doAll(inputFile, outputFile, linesNumber);

        // Case: input file not indicated
        try {
            doAll("", "hw19_custom_data_output.txt", 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Case: input file does not exist
        try {
            doAll("does_not_exist", "hw19_custom_data_output.txt", 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Case: number of lines bigger than input file's number of lines
        try {
            doAll("hw19_custom_data_input.txt", "hw19_custom_data_output.txt", 10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
