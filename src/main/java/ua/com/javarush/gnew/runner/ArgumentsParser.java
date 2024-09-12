package ua.com.javarush.gnew.runner;

import java.nio.file.Path;

public class ArgumentsParser {
    public RunOptions parse(String[] args) {
        Command command = null;
        Integer key = null;
        Path filePath = null;
        Path filePathForStaticAnalysis = null;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-e":
                    command = Command.ENCRYPT;
                    break;
                case "-d":
                    command = Command.DECRYPT;
                    break;
                case "-bf":
                    command = Command.BRUTEFORCE;
                    break;
                case "-k":
                    if (i + 1 < args.length) {
                        key = Integer.parseInt(args[++i]);
                    } else {
                        throw new IllegalArgumentException("Missing value for key");
                    }
                    break;
                case "-f":
                    if (i + 1 < args.length) {
                        filePath = Path.of(args[++i]);
                    } else {
                        throw new IllegalArgumentException("Missing value for file");
                    }
                    break;
                case "-sf":
                    if (i + 1 < args.length) {
                        filePathForStaticAnalysis = Path.of(args[++i]);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown argument: " + arg);
            }
        }

        if (command == null) {
            throw new IllegalArgumentException("Command (-e, -d, or -bf) is required");
        }

        if ((command == Command.ENCRYPT || command == Command.DECRYPT) && key == null) {
            throw new IllegalArgumentException("Key is required for encrypt or decrypt mode");
        }

        if (filePath == null && (command == Command.ENCRYPT || command == Command.DECRYPT)) {
            throw new IllegalArgumentException("File path is required for encrypt or decrypt mode");
        }

        return new RunOptions(command, key, filePath, filePathForStaticAnalysis);
    }
}
