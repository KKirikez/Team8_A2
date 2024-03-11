package model;

public class Puzzles extends Toy {
    private String puzzleType;

    public Puzzles(String serialNumber, String name, String brand, float price, int availableCount, int ageAppropriate, String puzzleType) {
        super(serialNumber, name, brand, price, availableCount, availableCount);
        setPuzzleType(puzzleType);
        this.setType("Puzzle");
        this.setAgeAppropriate(ageAppropriate);
    }

    public String getPuzzleType() {
        return puzzleType;
    }

    public void setPuzzleType(String puzzleType) {
        switch (puzzleType) {
            case "M":
            	this.puzzleType = "Mechanical";
            	break;
            case "C":
            	this.puzzleType = "Cryptic";
            	break;
            case "L":
            	this.puzzleType = "Logic";
            	break;
            case "T":
            	this.puzzleType = "Trivia";
            	break;
            case "R":
            	this.puzzleType = "Riddle";
            	break;
            default:
            	System.out.println("Error in Puzzle");
            	this.puzzleType = null;
            	break;
        }
    }

    @Override
    public String toString() {
        return "Puzzles{" +
            "serialNumber='" + getSerialNumber() + '\'' +
            ", name='" + getName() + '\'' +
            ", brand='" + getBrand() + '\'' +
            ", price=" + getPrice() +
            ", availableCount=" + getAvailableCount() +
            ", ageAppropriate=" + getAgeAppropriate() +
            ", puzzleType='" + puzzleType + '\'' +
        '}';
    }
    
    public String toDatabase() {
    	 return getSerialNumber() + ";" +
    	            getName() + ";" +
    	            getBrand() + ";" +
    	            getPrice() + ";" +
    	            getAvailableCount() + ";" +
    	            getAgeAppropriate() + ";" +
    	            getPuzzleType().charAt(0);
    }

    public boolean isSerialNumberValid(String serialNumber) {
        return serialNumber.startsWith("4") || serialNumber.startsWith("5") || serialNumber.startsWith("6");
    }
}
