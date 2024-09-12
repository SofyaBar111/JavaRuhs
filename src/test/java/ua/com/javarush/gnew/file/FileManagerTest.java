package ua.com.javarush.gnew.file;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {

    private final FileManager fileManager = new FileManager();
    private final Path testFile = Path.of("test.txt");

    @Test
    public void testReadAndWrite() throws IOException {
        String content = "test content";
        fileManager.write(testFile, content);
        String readContent = fileManager.read(testFile);
        assertEquals(content, readContent);
        Files.deleteIfExists(testFile);
    }
}

