import javax.xml.xpath.XPath;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class PathAndFileSystem {
    String content =
            "Sigma-sigma boy, sigma boy, sigma boy\n" +
            "Каждая девчонка хочет танцевать с тобой\n" +
            "Sigma-sigma boy, sigma boy, sigma boy\n" +
            "Я такая вся, что добиваться будешь год\n" +
            "Sigma-sigma boy, sigma boy, sigma boy\n" +
            "Каждая девчонка хочет танцевать с тобой\n" +
            "Sigma-sigma boy, sigma boy, sigma boy\n" +
            "Я такая вся, что добиваться будешь год\n" +
            "Sigma-sigma boy, sigma boy, sigma boy\n" +
            "Каждая девчонка хочет танцевать с тобой\n" +
            "Sigma-sigma boy, sigma boy, sigma boy\n" +
            "Я такая вся, что добиваться будешь год";

    public static void createFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.createFile(path);
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
//        StandardCopyOption.REPLACE_EXISTING
//        StandardCopyOption.COPY_ATTRIBUTES
//        StandardCopyOption.ATOMIC_MOVE
        Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved from " + sourcePath + " to " + destinationPath);
    }

    public static void main(String[] args) throws IOException {
        String filePath = "./text.txt";
        String copyPath = "./copy.txt";
        String dirPath = "./newdir";
        String moveTarget = "./newdir/text.txt";

        createFile(filePath);
        readFromFile(filePath);
        copyFile(filePath, copyPath);
        createDirectory(dirPath);
        moveFile(filePath, moveTarget);
    }
}

