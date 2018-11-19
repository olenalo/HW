package InterfileIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class InterfileNIO {

    public static String read(String filename, long linesNumber) {
        String content = "";
        long linesCount = 0;
        try {
            RandomAccessFile inputFile = new RandomAccessFile(Configs.INPUT_FILE, "rw");
            while (inputFile.readLine()!= null) {
                content += inputFile.readLine();
                content += "\r\n";
                linesCount++;
            }
            // TODO
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static long checkFileLinesNumber(RandomAccessFile file, long linesNumber) {
        // TODO
        return linesNumber;
    }

    public static void main(String[] args) {
        // TODO finish (see REQS)
        try {
            RandomAccessFile copyFrom = new RandomAccessFile(Configs.INPUT_FILE, "rw");

            FileChannel fromChannel = copyFrom.getChannel();
            RandomAccessFile copyTo = new RandomAccessFile(Configs.OUTPUT_FILE, "rw");
            FileChannel toChannel = copyTo.getChannel();

            long count = fromChannel.size();
            toChannel.transferFrom(fromChannel, 0, count);

            fromChannel.close();
            toChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
