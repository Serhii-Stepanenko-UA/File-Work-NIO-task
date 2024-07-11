package app._02.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadService {
    public String readFromFile(String strPath) {
        try {
            return Files.readString(Path.of(strPath));
        } catch (IOException ex) {
            return "Something wrong " + ex.getMessage();
        }
    }
}