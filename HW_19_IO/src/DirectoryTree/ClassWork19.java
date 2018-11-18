package DirectoryTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ClassWork19 {
    // ClassWork19: https://github.com/teaFunny/ClassWork19

    public static void main(String[] args) {
        doAll();
    }

    public static void doAll() {
        try (FileWriter writer = new FileWriter("hw19_directory_tree.txt")) {
            File directory = new File(getDirectoryPath());
            if (directory.exists() && directory.isDirectory() && directory.listFiles() != null) {
                writeAllFiles(writer, directory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllFiles(FileWriter writer, File directory) throws IOException {
        int nestingLevel = 0; // Defines indents number
        Stack<File> filesStack = new Stack<>();
        filesStack.push(directory);

        while(!filesStack.isEmpty()) {
            File file = filesStack.pop();
            File[] filesList = file.listFiles();
            if (file.isDirectory()) {
                // Empty dir should be taken into account too
                writer.write(generateBlankString(nestingLevel) + file.getName() + ":" + file.lastModified() + "\r\n");
                if (filesList != null) {
                    for (File f : filesList) {
                        filesStack.push(f);
                    }
                    nestingLevel++;  // FIXME fix indents
                }
            } else if (file.isFile()) {
                writer.write(generateBlankString(nestingLevel) + file.getName() + ":" + file.lastModified() + "\r\n");
            }
        }
    }

    private static String getDirectoryPath() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.next();
        }
    }

    private static String generateBlankString(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += "    ";
        }
        return result;
    }
}