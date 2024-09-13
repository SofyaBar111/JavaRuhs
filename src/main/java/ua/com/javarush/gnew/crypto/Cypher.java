package ua.com.javarush.gnew.crypto;

public interface Cypher<T> {
    String encrypt(String input, T key);

    String decrypt(String input, T key);

    String bruteForce(String input);
}
