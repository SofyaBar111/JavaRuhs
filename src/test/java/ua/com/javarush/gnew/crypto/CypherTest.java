package ua.com.javarush.gnew.crypto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CypherTest {

    private final Cypher cypher = new Cypher();

    @Test
    public void testDetermineAlphabet() {
        String content = "hello";
        List<Character> alphabet = cypher.determineAlphabet(content);
        assertEquals(List.of('h', 'e', 'l', 'o'), alphabet);
    }

    @Test
    public void testDecrypt() {
        String encryptedContent = "ifmmp";
        String decryptedContent = cypher.decrypt(encryptedContent, 1);
        assertEquals("hello", decryptedContent);
    }
}

