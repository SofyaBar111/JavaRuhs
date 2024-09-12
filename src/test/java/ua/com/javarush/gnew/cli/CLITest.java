package ua.com.javarush.gnew.cli;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CLITest {

    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testStartCLI() {
        String simulatedInput = "-E\ninput.txt\n123\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        CLI cli = new CLI();
        RunOptions runOptions = cli.startCLI();

        assertEquals(Command.ENCRYPT, runOptions.getCommand());
        assertEquals(Integer.valueOf(123), runOptions.getKey());
        assertEquals(Path.of("input.txt"), runOptions.getFilePath());
        assertNull(runOptions.getFilePathForStaticAnalysis());
    }

    @Test
    public void testStartCLIWithBruteForce() {
        String simulatedInput = "-BF\ninput.txt\nstatic.txt\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        CLI cli = new CLI();
        RunOptions runOptions = cli.startCLI();

        assertEquals(Command.BRUTEFORCE, runOptions.getCommand());
        assertNull(runOptions.getKey());
        assertEquals(Path.of("input.txt"), runOptions.getFilePath());
        assertEquals(Path.of("static.txt"), runOptions.getFilePathForStaticAnalysis());
    }
}
