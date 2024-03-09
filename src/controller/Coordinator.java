package controller;

import java.util.Scanner;
import view.ToyStoreMenu;

public class Coordinator {
	public static void mainMenu() {
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
              	break;
              default:
                  System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                  mainMenu();
          }
         scanner.close();
	}
}
