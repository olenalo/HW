import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class FileManipulationExercise {

    public static class FileResource {

        public String absolutePath;
        public String filename;

        public FileResource(String path) {
            this.filename = path; // "VariousExercises\\resources\\" + path;
            this.absolutePath = this.createAbsolutePath();
        }

        protected String createAbsolutePath()
        {
            URL fileURL = getClass().getResource(filename);
            if (fileURL != null) {
                System.out.println("File is found: " + fileURL.getPath());
                return fileURL.getPath();
            } else {
                System.err.println("Couldn't find file: " + filename);
                return null;
            }
        }
    }

    public static String read(String filename) {
        FileResource fileResource = new FileResource(filename);
        String absolutePath = fileResource.absolutePath;
        StringBuilder content = new StringBuilder();
        String contentString;
        BufferedReader reader = null;
        try {
            reader  = new BufferedReader(new FileReader(absolutePath));
            while ((contentString = reader.readLine()) != null)
                content.append(contentString);
            // FIXME: make it work
            content.append(System.getProperty("line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();

    }

    public static void write(String content, String filename) {
        FileResource fileResource = new FileResource(filename);
        String fileAbsolutePath = fileResource.absolutePath;
        BufferedWriter writer = null;
        try {
            // FIXME: Avoid writing to a root dir, write to the module dir
            // Consider Android context: https://stackoverflow.com/a/20891114
            // writer = new BufferedWriter(new FileWriter(fileAbsolutePath, true));
            writer = new BufferedWriter(new FileWriter(filename, true));
            writer.newLine();
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the three files " +
                "(e.g. 'file_1.txt', 'file_2.txt', 'file_3.txt'): ");
        String filename1 = scanner.next();
        String filename2 = scanner.next();
        String filename3 = scanner.next();

        /*
        String filename1 = "file_1.txt";
        String filename2 = "file_2.txt";
        String filename3 = "file_3.txt";
        */

        String content1 = read(filename1);
        System.out.printf("The content of '%s' is: \n%s\n",  filename1, content1);

        String content2 = read(filename2);
        System.out.printf("The content of '%s' is: \n%s\n",  filename2, content2);

        String content3 = read(filename3);
        System.out.printf("The content of '%s' is: \n%s\n",  filename3, content3);

        // REQ: Записать в первый файл содержимого второго файла,
        // а потом дописать в первый файл содержимое третьего файла
        write(content2, filename1);
        write(content3, filename1);

    }

}
