package model;

public abstract class Toy {

    private String serialNumber;
    private String name;
    private String brand;
    private float price;
    private int availableCount;
    private int ageAppropriate;

    public Toy(String serialNumber, String name, String brand, float price, int availableCount, int ageAppropriate) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.availableCount = availableCount;
        this.ageAppropriate = ageAppropriate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getAgeAppropriate() {
        return ageAppropriate;
    }

    public void setAgeAppropriate(int ageAppropriate) {
        this.ageAppropriate = ageAppropriate;
    }
}
