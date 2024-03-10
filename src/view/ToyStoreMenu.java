package view;

import java.util.Scanner;

public class ToyStoreMenu {
    public static void drawMainMenu() {
            System.out.println("************************************");
            System.out.println("*    Welcome to Toy Store Company  *");
            System.out.println("************************************");
            System.out.println("How may we help you?");
            System.out.println("1. Search Inventory and Purchase Toy");
            System.out.println("2. Add a New Toy");
            System.out.println("3. Remove a Toy");
            System.out.println("4. Make a Recommendation");
            System.out.println("5. Save and Exit");
    }
    
    public static void drawSearchMenu() {
    	System.out.println("Find toys with: \n");
    	System.out.println("(1) Serial Number");
    	System.out.println("(2) Toy Name");
    	System.out.println("(3) Type");
    	System.out.println("(4) Back to Main Menu");
    }
    
    public static void drawResults() {
    	
    }
    
}