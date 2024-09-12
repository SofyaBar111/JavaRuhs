package ua.com.javarush.gnew.runner;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class RunOptionsTest {

    @Test
    public void testRunOptions() {
        RunOptions runOptions = new RunOptions(Command.BRUTEFORCE, 42, Path.of("input.txt"), Path.of("static.txt"));

        assertEquals(Command.BRUTEFORCE, runOptions.getCommand());
        assertEquals(Integer.valueOf(42), runOptions.getKey());
        assertEquals(Path.of("input.txt"), runOptions.getFilePath());
        assertEquals(Path.of("static.txt"), runOptions.getFilePathForStaticAnalysis());
    }

    @Test
    public void testToString() {
        RunOptions runOptions = new RunOptions(Command.DECRYPT, 7, Path.of("input.txt"), null);

        String expected = "RunOptions{command=DECRYPT, key=7, filePath=input.txt, filePathForStaticAnalysis=null}";
        assertEquals(expected, runOptions.toString());
    }
}

