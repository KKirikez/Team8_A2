package view;

import java.util.Scanner;

public class ToyStoreMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("************************************");
            System.out.println("*    Welcome to Toy Store Company  *");
            System.out.println("************************************");
            System.out.println("How may we help you?");
            System.out.println("1. Search Inventory and Purchase Toy");
            System.out.println("2. Add a New Toy");
            System.out.println("3. Remove a Toy");
            System.out.println("4. Save and Exit");


            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}