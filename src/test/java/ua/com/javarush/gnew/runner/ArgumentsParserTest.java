package ua.com.javarush.gnew.runner;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ArgumentsParserTest {

    @Test
    public void testParse() {
        ArgumentsParser parser = new ArgumentsParser();
        String[] args = {"-e", "-k", "123", "-f", "input.txt"};
        RunOptions runOptions = parser.parse(args);

        assertEquals(Command.ENCRYPT, runOptions.getCommand());
        assertEquals(Integer.valueOf(123), runOptions.getKey());
        assertEquals(Path.of("input.txt"), runOptions.getFilePath());
        assertNull(runOptions.getFilePathForStaticAnalysis());
    }

    @Test
    public void testParseWithStaticFilePath() {
        ArgumentsParser parser = new ArgumentsParser();
        String[] args = {"-bf", "-sf", "static.txt", "-f", "input.txt"};
        RunOptions runOptions = parser.parse(args);

        assertEquals(Command.BRUTEFORCE, runOptions.getCommand());
        assertNull(runOptions.getKey());
        assertEquals(Path.of("input.txt"), runOptions.getFilePath());
        assertEquals(Path.of("static.txt"), runOptions.getFilePathForStaticAnalysis());
    }

    @Test
    public void testParseInvalidArguments() {
        ArgumentsParser parser = new ArgumentsParser();
        String[] args = {"-e", "-f"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            parser.parse(args);
        });
        assertEquals("Missing value for file", exception.getMessage());
    }
}

