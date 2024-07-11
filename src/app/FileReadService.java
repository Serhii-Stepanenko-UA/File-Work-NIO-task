package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadService {
    public String readFromFile(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
    }
}