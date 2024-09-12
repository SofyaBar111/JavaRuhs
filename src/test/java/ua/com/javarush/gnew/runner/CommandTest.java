package ua.com.javarush.gnew.runner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    @Test
    public void testCommandValues() {
        assertEquals(Command.ENCRYPT, Command.valueOf("ENCRYPT"));
        assertEquals(Command.DECRYPT, Command.valueOf("DECRYPT"));
        assertEquals(Command.BRUTEFORCE, Command.valueOf("BRUTEFORCE"));
    }
}
