package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.CaesarCypher;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;
import ua.com.javarush.gnew.runner.ArgumentsParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide arguments.");
            return;
        }

        ArgumentsParser argumentsParser = new ArgumentsParser();
        RunOptions runOptions = null;

        try {
            runOptions = argumentsParser.parse(args);
        } catch (IllegalArgumentException e) {
            System.err.println("Error parsing arguments: " + e.getMessage());
            return;
        }

        Cypher<Integer> cypher = new CaesarCypher();

        try {
            Path inputPath = runOptions.getFilePath();
            Path outputPath = Path.of("output.txt"); // Предполагается, что output.txt в текущем каталоге

            if (Files.notExists(inputPath)) {
                System.err.println("Input file does not exist.");
                return;
            }

            String inputText = Files.readString(inputPath);

            switch (runOptions.getCommand()) {
                case ENCRYPT:
                    String encryptedText = cypher.encrypt(inputText, runOptions.getKey());
                    Files.writeString(outputPath, encryptedText, StandardOpenOption.CREATE);
                    System.out.println("Encryption complete.");
                    break;

                case DECRYPT:
                    String decryptedText = cypher.decrypt(inputText, runOptions.getKey());
                    Files.writeString(outputPath, decryptedText, StandardOpenOption.CREATE);
                    System.out.println("Decryption complete.");
                    break;

                case BRUTEFORCE:
                    String bruteForcedText = cypher.bruteForce(inputText);
                    Files.writeString(outputPath, bruteForcedText, StandardOpenOption.CREATE);
                    System.out.println("Brute-force attempt complete.");
                    break;

                default:
                    System.out.println("Unknown command.");
                    break;
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
