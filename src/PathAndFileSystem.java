import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class PathAndFileSystem {
    public static void createFile(String filePath) throws IOException {

        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    public static void writeToFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    }

    public static void readFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        System.out.println("Reading from: " + path);

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println(line);
            }

    }

    public static void copyFile(String sourcePath, String destinationPath) throws IOException {
        Path from = Paths.get(sourcePath);
        Path to = Paths.get(destinationPath);
//        Java ENUM
//        StandardCopyOption.REPLACE_EXISTING
//          = If the target file already exists, it will be replaced
//        StandardCopyOption.COPY_ATTRIBUTES
//          =
//        StandardCopyOption.ATOMIC_MOVE
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied from " + sourcePath + " to " + destinationPath);
    }

    public static void createDirectory(String dirPath) throws IOException {
            Files.createDirectories(Paths.get(dirPath));
            System.out.println("Directory created: " + dirPath);
    }

    public static void moveFile(String sourcePath, String destinationPath) throws IOException {
        Path from = Paths.get(sourcePath);
        Path to = Paths.get(destinationPath);
        Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved from " + sourcePath + " to " + destinationPath);
    }

    public static void main(String[] args) throws IOException {
        String filePath = "./text.txt";
        String copyPath = "./copy.txt";
        String dirPath = "./newdir";
        String moveTarget = "./newdir/text.txt";
        String content = "This is content of the text file";
        String copyTarget = "./copy.txt";
        createFile(filePath);

        writeToFile(filePath, content);

        readFromFile(filePath);

        copyFile(filePath, copyPath);

        createDirectory(dirPath);
        
        moveFile(copyTarget, moveTarget);
    }
}

