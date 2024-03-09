package model;

public class Figures extends Toy {
    private String classification;

    public Figures(String serialNumber, String name, String brand, float price, int availableCount, int ageAppropriate, String classification) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.classification = classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }

    public boolean isSerialNumberValid(String serialNumber) {
        return serialNumber.startsWith("0") || serialNumber.startsWith("1");
    }
}
