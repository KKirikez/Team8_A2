package controller;

import java.util.Scanner;
import view.ToyStoreMenu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coordinator {
    private static final String FILE_PATH = "res/toys.txt";
    private static List<String> toys = new ArrayList<>();

    public static void mainMenu() {
        loadToysFromFile();
        ToyStoreMenu.drawMainMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("One"); //debug
                break;
            case 2:
                System.out.println("Two");//debug
                break;
            case 3:
                System.out.println("Three");//debug
                break;
            case 4:
                System.out.println("Four");//debug
                break;
            case 5:
                System.out.println("Thank you for using our app!"); //or something else just as corny
                saveToysToFile();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                mainMenu();
        }
        scanner.close();
    }

    private static void loadToysFromFile() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String toy = scanner.nextLine();
                toys.add(toy);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Failed to load toys from file: " + e.getMessage());
        }
    }

    private static void saveToysToFile() {
        try {
            File file = new File(FILE_PATH);
            FileWriter writer = new FileWriter(file);
            for (String toy : toys) {
                writer.write(toy + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to save toys to file: " + e.getMessage());
        }
    }
}
