package ua.com.javarush.gnew;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testCreateNewFileName() {
        Path filePath = Paths.get("testfile.txt");
        String suffix = "DECRYPTED_KEY_5";

        String expectedFileName = "testfile [DECRYPTED_KEY_5].txt";
        String actualFileName = Main.createNewFileName(filePath, suffix);

        assertEquals(expectedFileName, actualFileName);
    }
}
