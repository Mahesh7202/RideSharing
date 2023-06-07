package com.example.geektrust.interfaces;

import java.io.IOException;

public interface CommandReader {
    String readNextCommand() throws IOException;

    void close() throws IOException;

    void setFilePath(String filePath) throws IOException;
}
