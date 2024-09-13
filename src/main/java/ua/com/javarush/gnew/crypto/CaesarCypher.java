package ua.com.javarush.gnew.crypto;

public class CaesarCypher implements Cypher<Integer> {

    @Override
    public String encrypt(String input, Integer key) {
        return shift(input, key);
    }

    @Override
    public String decrypt(String input, Integer key) {
        return shift(input, -key);
    }

    @Override
    public String bruteForce(String input) {
        for (int key = 1; key <= 25; key++) {
            String decrypted = decrypt(input, key);
            if (isValid(decrypted)) {
                return decrypted;
            }
        }
        return null;
    }

    private String shift(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (char i : input.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                result.append((char) ((i - base + key + 26) % 26 + base));
            } else {
                result.append(i);
            }
        }
        return result.toString();
    }

    private boolean isValid(String text) {
        return !text.trim().isEmpty();
    }
}
