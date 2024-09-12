package ua.com.javarush.gnew.runner;

import java.nio.file.Path;

public class RunOptions {
    private final Command command;
    private final Integer key;
    private final Path filePath;
    private final Path filePathForStaticAnalysis;

    public RunOptions(Command command, Integer key, Path filePath, Path filePathForStaticAnalysis) {
        this.command = command;
        this.key = key;
        this.filePath = filePath;
        this.filePathForStaticAnalysis = filePathForStaticAnalysis;
    }

    public Command getCommand() {
        return command;
    }

    public Integer getKey() {
        return key;
    }

    public Path getFilePath() {
        return filePath;
    }

    public Path getFilePathForStaticAnalysis() {
        return filePathForStaticAnalysis;
    }

    @Override
    public String toString() {
        return "RunOptions{" +
                "command=" + command +
                ", key=" + key +
                ", filePath=" + filePath +
                ", filePathForStaticAnalysis=" + filePathForStaticAnalysis +
                '}';
    }
}