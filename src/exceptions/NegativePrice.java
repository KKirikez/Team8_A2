package exceptions;

public class NegativePrice extends Exception {
    
    public NegativePrice() {
        System.out.println("Whoops! A negative price was entered. Please try again.");
    }
}
