package ua.com.javarush.gnew.runner;

import java.nio.file.Path;
import ua.com.javarush.gnew.file.UniversalFileManager;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.crypto.CaesarCypher;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.RunOptions;
import ua.com.javarush.gnew.runner.Command;

public class ApplicationLoader {

    public static void main(String[] args) {
        try {
            // Создаем экземпляр ArgumentsParser и парсим аргументы
            ArgumentsParser argumentsParser = new ArgumentsParser();
            RunOptions runOptions = argumentsParser.parse(args);

            // Создаем экземпляр UniversalFileManager для работы с файлами
            UniversalFileManager fileManager = new UniversalFileManager();

            // Получаем команду из RunOptions
            Command command = runOptions.getCommand();
            Integer key = runOptions.getKey();
            Path filePath = runOptions.getFilePath();

            // Пример использования универсального менеджера файлов
            String fileContent = fileManager.readFile(filePath);

            // Создаем и используем экземпляр шифратора
            Cypher<Integer> cypher = new CaesarCypher(); // Убедитесь, что CaesarCypher реализует Cypher<Integer>

            switch (command) {
                case ENCRYPT:
                    String encrypted = cypher.encrypt(fileContent, key);
                    fileManager.writeFile(filePath, encrypted);
                    break;

                case DECRYPT:
                    String decrypted = cypher.decrypt(fileContent, key);
                    fileManager.writeFile(filePath, decrypted);
                    break;

                case BRUTEFORCE:
                    String bruteForced = cypher.bruteForce(fileContent);
                    fileManager.writeFile(filePath, bruteForced);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
