package ua.com.javarush.gnew.file;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileManagerTest {

    private final FileManager fileManager = new FileManager();
    private final Path testFilePath = Path.of("test.txt");

    @Test
    public void testRead() throws IOException {
        Files.writeString(testFilePath, "Test content");
        String content = fileManager.read(testFilePath);
        assertEquals("Test content", content);
    }

    @Test
    public void testWrite() throws IOException {
        fileManager.write(testFilePath, "New content");
        String content = Files.readString(testFilePath);
        assertEquals("New content", content);
    }

    @Test
    public void testReadFileNotFound() {
        assertThrows(IOException.class, () -> fileManager.read(Path.of("nonexistent.txt")));
    }
}


