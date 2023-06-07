package com.example.geektrust.io;

import com.example.geektrust.interfaces.CommandReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCommandReader implements CommandReader {
    private String filePath;
    private BufferedReader reader;

    public FileCommandReader(String filePath) throws IOException {
        setFilePath(filePath);
    }

    public String readNextCommand() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
    }

    public void setFilePath(String filePath) throws IOException {
        if (!isValidFilePath(filePath)) {
            throw new IOException("Invalid file path: " + filePath);
        }

        this.filePath = filePath;
        openFileReader();
    }

    public String getFilePath() {
        return filePath;
    }

    private boolean isValidFilePath(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && !Files.isDirectory(path);
    }

    private void openFileReader() throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
    }
}
