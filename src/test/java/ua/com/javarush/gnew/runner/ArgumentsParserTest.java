package ua.com.javarush.gnew.runner;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArgumentsParserTest {

    private final ArgumentsParser parser = new ArgumentsParser();

    @Test
    public void testParseValidArguments() {
        String[] args = {"-e", "-f", "input.txt", "-k", "5"};
        RunOptions options = parser.parse(args);
        assertEquals(Command.ENCRYPT, options.getCommand());
        assertEquals(5, options.getKey());
        assertEquals(Path.of("input.txt"), options.getFilePath());
    }

    @Test
    public void testParseInvalidArguments() {
        String[] args = {"-invalid"};
        assertThrows(IllegalArgumentException.class, () -> parser.parse(args));
    }
}
