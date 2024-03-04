package model;

public class Animals extends Toy {
    private String material;
    private String size;

    public Animals(String serialNumber, String name, String brand, float price, int availableCount, int ageAppropriate, String material, String size) {
        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
        this.material = material;
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        switch (size.toLowerCase()) {
            case "small":
            case "medium":
            case "large":
                this.size = size;
                break;
            default:
                throw new IllegalArgumentException("Invalid size. Size must be small, medium, or large.");
        }
    }
}
