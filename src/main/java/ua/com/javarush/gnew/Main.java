package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.crypto.FrequencyAnalysis;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        RunOptions runOptions = new RunOptions(Command.BRUTEFORCE, null, Paths.get("input.txt"), Paths.get("output.txt"));
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
        if (runOptions.getFilePathForStaticAnalysis() != null) {
            String staticContent = fileManager.read(runOptions.getFilePathForStaticAnalysis());
            List<Character> alphabet = cypher.determineAlphabet(staticContent);

            int key = frequencyAnalysis.performFrequencyAnalysis(staticContent, alphabet);
            String decryptedContent = cypher.decrypt(staticContent, key);

            Path newFilePath = Paths.get(createNewFileName(runOptions.getFilePath(), "DECRYPTED_KEY_" + key));
            fileManager.write(newFilePath, decryptedContent);
        }
    }

    protected static String createNewFileName(Path filePath, String suffix) { // Изменено с private на protected
        String fileName = filePath.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(0, dotIndex) + " [" + suffix + "].txt";
        } else {
            return fileName + " [" + suffix + "].txt";
        }
    }
}
