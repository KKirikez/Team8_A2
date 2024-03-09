package exceptions;

public class MinimumOverMax extends Exception {
   
    public MinimumOverMax() {
        System.out.println("The minimum number of players is greater than the maximum");
    }
}