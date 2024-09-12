package ua.com.javarush.gnew.cli;

import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;
import java.util.Scanner;

public class CLI {

    public RunOptions startCLI() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter command (-e for encrypt, -d for decrypt, -bf for brute force):");
        String commandInput = scanner.next().trim().toUpperCase(); // Преобразуем команду в верхний регистр
        Command command = parseCommand(commandInput);

        System.out.println("Enter file path:");
        Path filePath = Path.of(scanner.next().trim());

        Integer key = null;
        Path staticFilePath = null;

        if (command == Command.ENCRYPT || command == Command.DECRYPT) {
            System.out.println("Enter key:");
            key = scanner.nextInt();
        } else if (command == Command.BRUTEFORCE) {
            System.out.println("Enter file path for static analysis (optional):");
            String pathInput = scanner.next().trim();
            if (!pathInput.isEmpty()) {
                staticFilePath = Path.of(pathInput);
            }
        }

        return new RunOptions(
                command,
                key,
                filePath,
                staticFilePath
        );
    }

    private Command parseCommand(String input) {
        switch (input) {
            case "-E":
                return Command.ENCRYPT;
            case "-D":
                return Command.DECRYPT;
            case "-BF":
                return Command.BRUTEFORCE;
            default:
                throw new IllegalArgumentException("Invalid command: " + input);
        }
    }
}
