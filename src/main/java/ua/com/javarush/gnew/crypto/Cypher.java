package ua.com.javarush.gnew.crypto;

import java.util.ArrayList;
import java.util.List;

public class Cypher {

    public List<Character> determineAlphabet(String content) {
        List<Character> alphabet = new ArrayList<>();
        for (char c : content.toCharArray()) {
            if (!alphabet.contains(c)) {
                alphabet.add(c);
            }
        }
        return alphabet;
    }

    public String decrypt(String content, int key) {
        StringBuilder decryptedContent = new StringBuilder();
        for (char c : content.toCharArray()) {
            decryptedContent.append((char) (c - key));
        }
        return decryptedContent.toString();
    }
}

