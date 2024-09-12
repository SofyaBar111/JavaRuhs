package ua.com.javarush.gnew.crypto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyAnalysis {

    public int performFrequencyAnalysis(String content, List<Character> alphabet) {
        if (content == null || alphabet == null || alphabet.isEmpty()) {
            throw new IllegalArgumentException("Content or alphabet cannot be null or empty");
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : content.toCharArray()) {
            if (alphabet.contains(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        char mostFrequentChar = findMostFrequentCharacter(frequencyMap);

        char expectedChar = 'e';
        return mostFrequentChar - expectedChar;
    }

    private char findMostFrequentCharacter(Map<Character, Integer> frequencyMap) {
        return frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("Frequency map is empty"));
    }
}
