package InterfileIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class InterfileNIO {

    public static long getLinesNumber() {
        long linesNumber;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter the number of lines:");
            linesNumber = (long) scanner.nextInt();
        }
        return linesNumber;
    }

    public static void checkFile(String filename) {
        if (filename.equals("") || filename == null) {
            throw new IllegalArgumentException("Input file name is not indicated.");
        }
        if (!Files.exists(Paths.get(filename))) {
            throw new IllegalArgumentException("Input file is not found.");
        }
    }

    public static void readWriteInterfile(String inputFileName, String outputFileName, long linesNumber) {
        // FIXME work on bigger files (channel is bigger than buffer's capacity)
        // FIXME case with max number of lines (equal to file lines number)

        checkFile(inputFileName);
        // TODO check lines number

        try {
            RandomAccessFile copyFrom = new RandomAccessFile(inputFileName, "rw");
            FileChannel fromChannel = copyFrom.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(Configs.NIO_BUFFER_CAPACITY);
            int bytesRead = fromChannel.read(buf);
            int linesCount = 0;

            while (bytesRead != -1) {
                buf.flip();  // make buffer ready for read
                while (buf.hasRemaining() && linesCount < linesNumber) {
                    byte[] contentBytes = buf.array();
                    for (int i = 0; i < contentBytes.length; i++) {
                        if (contentBytes[i] == '\n' && linesCount < linesNumber) {
                            byte[] fileAsByteArray = new byte[i + 1];
                            System.arraycopy(contentBytes, 0, fileAsByteArray, 0, i + 1);
                            // FIXME do not write '\n'
                            Files.write(Paths.get(outputFileName), fileAsByteArray);
                            linesCount++;
                        }
                        // TODO else write remaining bytes
                    }
                }
                buf.clear(); // make buffer ready for writing
                bytesRead = fromChannel.read(buf);
            }
            copyFrom.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long linesNumber = getLinesNumber();
        // linesNumber = 5;
        readWriteInterfile(Configs.INPUT_FILE, Configs.OUTPUT_FILE, linesNumber);
    }
}
