package controller;

import java.util.Scanner;

import exceptions.MinimumOverMax;
import exceptions.NegativePrice;
import view.ToyStoreMenu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;

/**
 * The Coordinator class is responsible for managing the main menu and coordinating the different functionalities of the toy store application.
 * It loads toys from a file, displays the main menu options, and performs actions based on the user's choice.
 * It also provides methods for saving toys to a file, searching for toys, adding a new toy, removing a toy, and suggesting gifts.
 */
public class Coordinator {
    private static final String FILE_PATH = "res/toys.txt";
    private static List<Toy> toys = new ArrayList<>();

    public static void mainMenu() {
        loadToysFromFile();
        ToyStoreMenu.drawMainMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
               searchToys();
                break;
            case 2:
                addToy();
                break;
            case 3:
                removeToy();
                break;
            case 4:
                //recommendToy();
                break;
            case 5:
                System.out.println("Thank you for using our app!"); //or something else just as corny
                saveToysToFile();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.\n");
                mainMenu();
        }
        scanner.close();
    }

    private static void loadToysFromFile() {
        try {
            File file = new File(FILE_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String toyString = scanner.nextLine();
                String type = getType(toyString);
                String[] toyArray = toyString.split(";");
                Toy toy = null;
                switch (type) {
                    case "Figure":
                        //0113513686;Toy soldier;Gamen;14.06;2;5;A
                        //String serialNumber, String name, String brand, float price, int availableCount, int ageAppropriate, String classification
                        toy = new Figures(toyArray[0], toyArray[1], toyArray[2], Float.parseFloat(toyArray[3]), Integer.parseInt(toyArray[4]),
                                Integer.parseInt(toyArray[5]), toyArray[6]);
                        break;

                    case "Animal":
                        //3015547049;Dove;Game Zombie;24.55;2;9;Wooden;S
                        //String serialNumber, String name, String brand, float price, int availableCount, int ageAppropriate, String material, String size
                        toy = new Animals(toyArray[0], toyArray[1], toyArray[2], Float.parseFloat(toyArray[3]), Integer.parseInt(toyArray[4]),
                                Integer.parseInt(toyArray[5]), toyArray[6], toyArray[7]);
                        break;

                    case "Puzzle":
                        //5239019250;Nob Yoshigahara Puzzle Design Competition;Game Zombie;67.20;5;3;M
                        //String serialNumber, String name, String brand, float price, int availableCount, String puzzleType
                        toy = new Puzzles(toyArray[0], toyArray[1], toyArray[2], Float.parseFloat(toyArray[3]), Integer.parseInt(toyArray[4]),
                                toyArray[5]);
                        break;

                    case "Board Game":
                        //7734720369;Doom: The Boardgame;Gamefluent;174.24;10;7;2-5;Miller Knights
                        //String serialNumber, String name, String brand, float price, int availableCount, int minPlayers, int maxPlayers, String designers
                        toy = new Boardgames(toyArray[0], toyArray[1], toyArray[2], Float.parseFloat(toyArray[3]), Integer.parseInt(toyArray[4]),
                                Integer.parseInt(toyArray[6].substring(0, 1)), Integer.parseInt(toyArray[6].substring(2, 3)), toyArray[7]);
                        break;
                }

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
            for (Toy toy : toys) {
                writer.write(toy.toDatabase() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to save toys to file: " + e.getMessage());
        }
    }
    
    private static void searchToys() {
        ToyStoreMenu.drawSearchMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter the serial number: ");
                String serial = scanner.nextLine();
                compareToys(serial, "Serial", "Serial");
                purchaseToy(serial, "Serial", scanner);
                break;
            case 2:
                System.out.println("Enter the name of the toy: ");
                String name = scanner.nextLine();
                compareToys(name.toLowerCase(), "Name", "Name");
                purchaseToy(name.toLowerCase(), "Name", scanner);
                break;
            case 3:
                System.out.println("Enter the type of toy: ");
                String type = scanner.nextLine();
                compareToys(type, "Type", "Type");
                purchaseToy(type, "Type", scanner); 
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.\n");
                searchToys();
            }
        scanner.close();
    }

private static void addToy() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Adding a new Toy!");

    System.out.print("Enter Serial Number: ");
    String serialNumber = scanner.nextLine();

    
    while (!isSerialNumberUnique(serialNumber)) {
        System.out.println("Serial number already exists. Please enter a unique serial number.");
        System.out.print("Enter Serial Number: ");
        serialNumber = scanner.nextLine();
    }

    System.out.print("Enter Toy Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Toy Brand: ");
    String brand = scanner.nextLine();

    float price;
    System.out.print("Enter Toy Price: ");
    price = Float.parseFloat(scanner.nextLine());
    if (price < 0) {
        throw new NegativePrice(); 
    }

    System.out.print("Enter Available Counts: ");
    int availableCount = scanner.nextInt();

    System.out.print("Enter Appropriate Age: ");
    int ageAppropriate = scanner.nextInt();

       int minPlayers, maxPlayers;
    System.out.print("Enter Minimum Number of Players: ");
    minPlayers = scanner.nextInt();
    System.out.print("Enter Maximum Number of Players: ");
    maxPlayers = scanner.nextInt();
    if (minPlayers > maxPlayers) {
        throw new MinimumOverMax();
    }
    scanner.nextLine();

    System.out.print("Enter Designer Names (Use, to separate the names if there is more than one name): ");
    String designers = scanner.nextLine();

    toys.add(new BoardGame(serialNumber, name, brand, price, availableCount, ageAppropriate, minPlayers, maxPlayers, designers));

    System.out.println("New Toy Added!");
    System.out.println("Press Enter to Continue...");
    scanner.nextLine(); 

    
    drawSearchMenu();
}

private static void removeToy() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Removing a Toy!");

    System.out.print("Enter Serial Number: ");
    String serialNumber = scanner.nextLine();

    
    Toy toyToRemove = null;
    for (Toy toy : toys) {
        if (toy.getSerialNumber().equalsIgnoreCase(serialNumber)) {
            toyToRemove = toy;
            break;
        }
    }

    if (toyToRemove != null) {
        System.out.println("This Item Found:");
        System.out.println(toyToRemove);
        System.out.print("Do you want to remove it (Y/N)? ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {
            toys.remove(toyToRemove);
            System.out.println("Item Removed!"); 
    } else {
        System.out.println("Toy with serial number " + serialNumber + " not found.");
    }

    System.out.println("Press Enter to Continue...");
    scanner.nextLine(); 

    
    drawSearchMenu();
}



    private static void purchaseToy(String target, String parameterType, Scanner scanner) {
        Toy toyToPurchase = null;
        for (Toy toy : toys) {
            if (compare(toy, target, parameterType)) {
                toyToPurchase = toy;
                break;
            }
        }

        if (toyToPurchase != null) {
            System.out.println("The Transaction Successfully Terminated!");
            System.out.println(toyToPurchase.toString());
            toys.remove(toyToPurchase);
            toyToPurchase.setAvailableCount(toyToPurchase.getAvailableCount() - 1);
        } else {
            System.out.println("Toy not found. Please enter a valid input.");
            searchToys(); // Reprompting the user, is this necessary?
        }
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        searchToys();
    }

    private static boolean compare(Toy toy, String target, String parameterType) {
        switch (parameterType) {
            case "Serial":
                return toy.getSerialNumber().equals(target);
            case "Name":
                return toy.getName().equalsIgnoreCase(target);
            case "Type":
                return toy.getType().equalsIgnoreCase(target);
            default:
                return false;
        }
    }
    
    private static void giftSuggestion() {
    	
    }
    
    private static Boolean compareToys(Object target, String parameterTarget, String parameterType) {
        switch (parameterType) {
            case "Serial":
                System.out.println("Here are the search results:");
                for (Toy toy : toys) {
                    if (toy.getSerialNumber().equals(target)) {
                        System.out.println(toy.toString());
                    }
                }
                break;
            case "Name":
                System.out.println("Here are the search results:");
                for (Toy toy : toys) {
                    if (toy.getName().equalsIgnoreCase((String) target)) {
                        System.out.println(toy.toString());
                    }
                }
                break;
            case "Type":
                System.out.println("Here are the search results:");
                for (Toy toy : toys) {
                    if (toy.getType().equalsIgnoreCase((String) target)) {
                        System.out.println(toy.toString());
                    }
                }
                break;
            default:
                break;
        }
        return true;
    }
    
    
    private static String getType(String input) {
    	char firstChar = input.charAt(0);

    	switch (firstChar) {
    	    case '0':
    	    case '1':
    	        return "Figure";
    	    case '2':
    	    case '3':
    	        return "Animal";
    	    case '4':
    	    case '5':
    	    case '6':
    	        return "Puzzle";
    	    case '7':
    	    case '8':
    	    case '9':
    	        return "Board Game";
    	    default:
    	        return "Error";
    	}
    }
}
