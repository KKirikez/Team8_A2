package model;

public class Figures extends Toy {
    private String classification;

    public Figures(String serialNumber, String name, String brand, float price, int availableCount, int ageAppropriate, String classification) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.classification = classification;
    }

    public String validateSerialNumberFigure(String serialNumber) {
        try {
            if (serialNumber != null && (serialNumber.charAt(0) == '0' || serialNumber.charAt(0) == '1')) {
                return serialNumber;
            } else {
                throw new IllegalArgumentException("Serial number must start with 0 or 1");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }
}
