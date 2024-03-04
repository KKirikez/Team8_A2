package model;

public class Puzzles extends Toy {
    private String puzzleType;

    public Puzzles(String serialNumber, String name, String brand, float price, int availableCount, String puzzleType) {
        super(serialNumber, name, brand, price, availableCount, availableCount);
        setPuzzleType(puzzleType);
    }

    public String getPuzzleType() {
        return puzzleType;
    }

    public void setPuzzleType(String puzzleType) {
        switch (puzzleType) {
            case "Mechanical":
            case "Cryptic":
            case "Logic":
            case "Trivia":
            case "Riddle":
                try {
                    this.puzzleType = puzzleType;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid puzzle type");
                }
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
}
