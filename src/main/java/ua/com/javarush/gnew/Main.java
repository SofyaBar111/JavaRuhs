package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.crypto.FrequencyAnalysis;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        RunOptions runOptions = new RunOptions(Command.BRUTEFORCE, 1, Path.of("data", "input.txt"), Path.of("data", "output.txt"));
        FileManager fileManager = new FileManager();
        Cypher cypher = new Cypher();
        FrequencyAnalysis frequencyAnalysis = new FrequencyAnalysis();

        try {
            performFrequencyAnalysis(fileManager, cypher, frequencyAnalysis, runOptions);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error occurred during frequency analysis", e);
        }
    }

    public static void performFrequencyAnalysis(FileManager fileManager, Cypher cypher, FrequencyAnalysis frequencyAnalysis, RunOptions runOptions) throws IOException {
        Path inputFilePath = runOptions.getFilePath();
        Path staticFilePath = runOptions.getFilePathForStaticAnalysis();

        if (Files.notExists(inputFilePath)) {
            LOGGER.log(Level.SEVERE, "Input file does not exist: " + inputFilePath.toString());
            throw new IOException("File does not exist: " + inputFilePath);
        }

        if (staticFilePath != null && Files.notExists(staticFilePath)) {
            LOGGER.log(Level.SEVERE, "Static file for analysis does not exist: " + staticFilePath.toString());
            throw new IOException("File does not exist: " + staticFilePath);
        }

        if (staticFilePath != null) {
            String staticContent = fileManager.read(staticFilePath);
            List<Character> alphabet = cypher.determineAlphabet(staticContent);

            int key = frequencyAnalysis.performFrequencyAnalysis(staticContent, alphabet);
            String decryptedContent = cypher.decrypt(staticContent, key);

            Path newFilePath = Path.of(createNewFileName(inputFilePath, "DECRYPTED_KEY_" + key));
            fileManager.write(newFilePath, decryptedContent);
        }
    }

    private static String createNewFileName(Path filePath, String suffix) {
        String fileName = filePath.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(0, dotIndex) + " [" + suffix + "].txt";
        } else {
            return fileName + " [" + suffix + "].txt";
        }
    }
}
