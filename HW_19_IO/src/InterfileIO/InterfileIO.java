package InterfileIO;

import java.io.*;

public class InterfileIO {
    public static final int BUFFER_SIZE = 1000;

    public static void write(String content, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String filename, long linesNumber) {
        if (filename == null) {
            throw new IllegalArgumentException("Input file name is not indicated.");
        }
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalArgumentException("Input file is not found.");
        }
        StringBuilder content = new StringBuilder();
        long checkedLinesNumber = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            checkedLinesNumber = checkFileLinesNumber(reader, linesNumber);
            String contentString;
            int linesCount = 1;
            while ((contentString = reader.readLine()) != null && linesCount <= checkedLinesNumber) {
                content.append(contentString);
                content.append("\r\n");
                linesCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static long checkFileLinesNumber(BufferedReader reader, long linesNumber) {
        // Ref. https://stackoverflow.com/a/4901577
        try {
            reader.mark(BUFFER_SIZE);
            long actualLinesNumber = reader.lines().count();
            if (linesNumber > actualLinesNumber) {
                throw new IllegalArgumentException("User defined lines number is bigger than the actual number");
            }
            if (linesNumber == 0) {
                linesNumber = actualLinesNumber;
            }
            reader.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesNumber;
    }

    public static void doAll(String inputFileName, String outputFileName, long linesNumber) {
        String content = read(inputFileName, linesNumber);
        write(content, outputFileName);
    }

    public static void main(String[] args) {
        String[] userDefinedData = Utils.getUserDefinedData();
        String inputFile = userDefinedData[0];  // hw19_custom_data_input.txt
        String outputFile = userDefinedData[1]; // hw19_custom_data_output.txt
        long linesNumber = Long.valueOf(userDefinedData[2]);

        /*
        String inputFile = "hw19_custom_data_input.txt";
        String outputFile = "hw19_custom_data_output.txt";
        int linesNumber = 1;
        */

        doAll(inputFile, outputFile, linesNumber);

        // TODO: move this to unit tests once implemented
        // Case: input file not indicated
        try {
            doAll("", Configs.OUTPUT_FILE, 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Case: input file does not exist
        try {
            doAll("does_not_exist", Configs.OUTPUT_FILE, 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Case: number of lines bigger than input file's number of lines
        try {
            doAll(Configs.INPUT_FILE, Configs.OUTPUT_FILE, 10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Case: default number of lines is used (input file's number of lines)
        // doAll(Utils.INPUT_FILE, Utils.OUTPUT_FILE, 0);

    }
}
