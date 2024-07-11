package app._02.service;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriteService {
    public String createFile(String path) {
        Path newFile;
        try {
            newFile = Files.createFile(Path.of(path));
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something wrong " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException ex) {
            return ex.getMessage();
        }
        return "Recorded in " + path;
    }
}