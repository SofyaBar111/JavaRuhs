package ua.com.javarush.gnew.crypto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FrequencyAnalysisTest {

    @Test
    public void testPerformFrequencyAnalysis() {
        FrequencyAnalysis frequencyAnalysis = new FrequencyAnalysis();
        String content = "hello";
        List<Character> alphabet = List.of('h', 'e', 'l', 'o');
        int key = frequencyAnalysis.performFrequencyAnalysis(content, alphabet);
        assertEquals('l' - 'e', key);
    }
}

