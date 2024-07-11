package app;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        String newfileName;
        String content;
        String message = "Make your choice: 1 or 2 or Exit";
        System.out.println("Please make your choice:");
        System.out.println("1 - Create and save a file");
        System.out.println("2 - Read this file");
        System.out.println("Exit - For exiting");
        while (true) {
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                choice = Integer.parseInt(input);
                if (choice == 1 ^ choice == 2) {
                    switch (choice) {
                        case 1:
                            FileWriteService fws = new FileWriteService();
                            System.out.println("Input file Name:");
                            newfileName = scan.nextLine();
                            System.out.println("Input content:");
                            content = scan.nextLine();
                            String path = FilePath.getBasePath() + newfileName + ".txt";
                            getOutput(fws.createFile(path));
                            getOutput(fws.writeToFile(Paths.get(path), content));
                            getOutput(message);
                            break;
                        case 2:
                            FileReadService frs = new FileReadService();
                            System.out.println("Input file Name:");
                            newfileName = scan.nextLine();
                            String pathr = FilePath.getBasePath() + newfileName + ".txt";
                            getOutput("CONTENT: " + frs.readFromFile(pathr));
                            getOutput(message);
                            break;
                    }
                } else {
                    System.out.println("A number other than 1 or 2 is entered.");
                    getOutput(message);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error! Not a number entered!");
                getOutput(message);
            }
        }
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}