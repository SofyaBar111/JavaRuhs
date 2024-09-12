package ua.com.javarush.gnew.runner;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunOptionsTest {

    @Test
    public void testRunOptionsConstructorAndGetters() {
        Command command = Command.ENCRYPT;
        Integer key = 5;
        Path filePath = Path.of("test.txt");
        Path staticFilePath = Path.of("static.txt");

        RunOptions runOptions = new RunOptions(command, key, filePath, staticFilePath);

        assertEquals(command, runOptions.getCommand());
        assertEquals(key, runOptions.getKey());
        assertEquals(filePath, runOptions.getFilePath());
        assertEquals(staticFilePath, runOptions.getFilePathForStaticAnalysis());
    }
}
