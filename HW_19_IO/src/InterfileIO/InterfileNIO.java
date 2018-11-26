package InterfileIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InterfileNIO {

    public static void checkFile(String filename) {
        if (filename.equals("") || filename == null) {
            throw new IllegalArgumentException("Input file name is not indicated.");
        }
        if (!Files.exists(Paths.get(filename))) {
            throw new IllegalArgumentException("Input file is not found.");
        }
    }

    public static void readWriteInterfile(String inputFileName, String outputFileName, long linesNumber) {
        // FIXME case with max number of lines (bytes number being equal to buffer capacity)

        checkFile(inputFileName);
        // TODO check lines number

        try {
            RandomAccessFile copyFrom = new RandomAccessFile(inputFileName, "rw");
            FileChannel fromChannel = copyFrom.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(Configs.NIO_BUFFER_CAPACITY);
            int bytesRead = fromChannel.read(buf);
            int linesCount = 0;

            while (bytesRead != -1 && linesCount < linesNumber) {
                buf.flip();  // make buffer ready for reading
                while (buf.hasRemaining() && linesCount < linesNumber) {
                    byte[] contentBytes = buf.array();
                    for (int i = 0; i < contentBytes.length; i++) {
                        if (contentBytes[i] == '\n' && linesCount < linesNumber) {
                            byte[] fileAsByteArray = new byte[i];
                            System.arraycopy(contentBytes, 0, fileAsByteArray, 0, i);
                            // FIXME do not write neither '\n' nor '\r'
                            Files.write(Paths.get(outputFileName), fileAsByteArray);
                            linesCount++;
                        }
                        // TODO else keep remaining bytes
                    }
                }
                buf.compact(); // make buffer ready for writing
                bytesRead = fromChannel.read(buf);
            }
            copyFrom.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Checking NIO.");
        long linesNumber = Utils.getUserDefinedLinesNumber();
        // linesNumber = 5;
        readWriteInterfile(Configs.INPUT_FILE, Configs.OUTPUT_FILE, linesNumber);
    }
}
