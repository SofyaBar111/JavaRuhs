package ua.com.javarush.gnew.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UniversalFileManager {

    // Метод для чтения файла
    public String readFile(Path filePath) throws IOException {
        if (Files.notExists(filePath)) {
            throw new IOException("File not found: " + filePath.toString());
        }
        return Files.readString(filePath);
    }

    // Метод для записи в файл
    public void writeFile(Path filePath, String content) throws IOException {
        Files.writeString(filePath, content);
    }
}
