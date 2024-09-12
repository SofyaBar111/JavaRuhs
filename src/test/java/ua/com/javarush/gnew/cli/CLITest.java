package ua.com.javarush.gnew.cli;

import org.junit.jupiter.api.Test;
import ua.com.javarush.gnew.runner.Command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CLITest {

    @Test
    public void testParseCommandValidInputs() {
        CLI cli = new CLI();

        assertEquals(Command.ENCRYPT, cli.parseCommand("-E"));
        assertEquals(Command.DECRYPT, cli.parseCommand("-D"));
        assertEquals(Command.BRUTEFORCE, cli.parseCommand("-BF"));
    }

    @Test
    public void testParseCommandInvalidInput() {
        CLI cli = new CLI();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            cli.parseCommand("-INVALID");
        });

        assertEquals("Invalid command: -INVALID", exception.getMessage());
    }
}
