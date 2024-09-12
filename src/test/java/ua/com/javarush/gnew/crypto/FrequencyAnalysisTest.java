package ua.com.javarush.gnew.crypto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencyAnalysisTest {

    private final FrequencyAnalysis frequencyAnalysis = new FrequencyAnalysis();

    @Test
    public void testPerformFrequencyAnalysis() {
        String content = "eeeellll";
        List<Character> alphabet = List.of('e', 'l');
        int key = frequencyAnalysis.performFrequencyAnalysis(content, alphabet);
        assertEquals(101 - 101, key);  // 'e' ASCII 101, 'l' ASCII 108
    }
}

