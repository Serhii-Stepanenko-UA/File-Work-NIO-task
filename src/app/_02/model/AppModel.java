package app._02.model;

import app._02.service.FileReadService;
import app._02.service.FileWriteService;
import app._02.utils.Constants;

import java.nio.file.Paths;

public class AppModel {

    public String writeFile(String[] data) {

        String content = data[0];
        String fileName = data[1];

        FileWriteService fws = new FileWriteService();
        String path = Constants.BASE_PATH_REL + fileName + ".txt";
        fws.createFile(path);
        fws.writeToFile(Paths.get(path), content);
        return "Success!";
    }

    public String readFromFile(String fileName) {
        FileReadService frs = new FileReadService();
        String strPath = Constants.BASE_PATH_REL + fileName + ".txt";
        return ("CONTENT: " + frs.readFromFile(strPath));
    }
}