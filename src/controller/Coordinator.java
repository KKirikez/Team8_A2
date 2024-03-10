package controller;

import java.util.Scanner;
import view.ToyStoreMenu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;

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
                // ↓ AI GENERATED CODE, DOUBLE CHECK ↓
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
                // ↑ AI GENERATED CODE, DOUBLE CHECK ↑

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
                writer.write(toy + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to save toys to file: " + e.getMessage());
        }
    }
    
    //Serial Number ; Title ; Brand ; Price ; 9 ; 6 ; 2-6 ; Barney Lugo,Yu Zimmerman
    
    private static void searchToys() {
    	
    }
    
    private static void addToy() {
    	
    }
    
    private static void removeToy() {
    	
    }
    
    private static void giftSuggestion() {
    	
    }
    
    private static Boolean compareToys(Object target, String perameterTarget, String perameterType) {
    	switch (perameterType) {
    	case "Serial":
    		System.out.println(); //debug
    		break;
    	case "Name":
    		System.out.println(); //debug
    		break;
    	case "Type":
    		
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