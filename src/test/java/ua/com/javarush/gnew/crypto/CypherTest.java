package ua.com.javarush.gnew.crypto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CypherTest {

    @Test
    public void testDetermineAlphabet() {
        Cypher cypher = new Cypher();
        String content = "hello";
        List<Character> alphabet = cypher.determineAlphabet(content);
        assertEquals(List.of('h', 'e', 'l', 'o'), alphabet);
    }

    @Test
    public void testDecrypt() {
        Cypher cypher = new Cypher();
        String content = "ifmmp";
        String decrypted = cypher.decrypt(content, 1);
        assertEquals("hello", decrypted);
    }
}

