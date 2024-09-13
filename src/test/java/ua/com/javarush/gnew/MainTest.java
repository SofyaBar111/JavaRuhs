package ua.com.javarush.gnew;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import ua.com.javarush.gnew.crypto.CaesarCypher;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.UniversalFileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final String TEST_TEXT = "Hello, World!";
    private static final int KEY = 5;

    @TempDir
    Path tempDir;

    private Path inputFilePath;
    private Path outputFilePath;
    private UniversalFileManager fileManager;
    private Cypher<Integer> cypher;

    @BeforeEach
    void setUp() throws IOException {
        fileManager = new UniversalFileManager();
        cypher = new CaesarCypher();

        inputFilePath = tempDir.resolve("input.txt");
        outputFilePath = tempDir.resolve("output.txt");

        Files.writeString(inputFilePath, TEST_TEXT);
    }

    @Test
    void testEncryption() throws IOException {
        String encryptedText = cypher.encrypt(TEST_TEXT, KEY);
        fileManager.writeFile(outputFilePath, encryptedText);

        String result = Files.readString(outputFilePath);
        assertEquals(cypher.encrypt(TEST_TEXT, KEY), result);
    }

    @Test
    void testDecryption() throws IOException {
        String encryptedText = cypher.encrypt(TEST_TEXT, KEY);
        fileManager.writeFile(outputFilePath, encryptedText);

        String decryptedText = cypher.decrypt(encryptedText, KEY);
        fileManager.writeFile(outputFilePath, decryptedText);

        String result = Files.readString(outputFilePath);
        assertEquals(TEST_TEXT, result);
    }

    @Test
    void testArgumentsParser() {
        String[] args = {"-e", "-k", String.valueOf(KEY), "-f", inputFilePath.toString()};
        ArgumentsParser parser = new ArgumentsParser();
        RunOptions options = parser.parse(args);

        assertEquals(Command.ENCRYPT, options.getCommand());
        assertEquals(KEY, options.getKey());
        assertEquals(inputFilePath, options.getFilePath());
    }

    @Test
    void testFileHandling() throws IOException {
        String content = "Testing file handling.";
        fileManager.writeFile(inputFilePath, content);

        String result = fileManager.readFile(inputFilePath);
        assertEquals(content, result);
    }

    @Test
    void testInvalidArguments() {
        String[] args = {"-x"};

        ArgumentsParser parser = new ArgumentsParser();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse(args);
        });

        assertTrue(exception.getMessage().contains("Unknown argument: -x"));
    }
}

