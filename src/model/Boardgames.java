package model;

public class Boardgames extends Toy {
    private int minPlayers;
    private int maxPlayers;
    private String designers;

    public Boardgames(String serialNumber, String name, String brand, float price, int availableCount, int minPlayers, int maxPlayers, String designers) {
        super(serialNumber, name, brand, price, availableCount, maxPlayers);
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.designers = designers;
        this.setType("Board Game");
    }


    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getDesigners() {
        return designers;
    }

    public void setDesigners(String designers) {
        this.designers = designers;
    }

    public boolean isSerialNumberValid(String serialNumber) {
        return serialNumber.startsWith("7") || serialNumber.startsWith("8") || serialNumber.startsWith("9");
    }

    @Override
    public String toString() {
        return "Boardgames{" +
            "serialNumber='" + getSerialNumber() + '\'' +
            ", name='" + getName() + '\'' +
            ", brand='" + getBrand() + '\'' +
            ", price=" + getPrice() +
            ", availableCount=" + getAvailableCount() +
            ", minPlayers=" + minPlayers +
            ", maxPlayers=" + maxPlayers +
            ", designers='" + designers + '\'' +
        '}';
    }
    
    public String toDatabase() {
   	 return getSerialNumber() + ";" +
   	            getName() + ";" +
   	            getBrand() + ";" +
   	            getPrice() + ";" +
   	            getAvailableCount() + ";" +
   	            getAgeAppropriate() + ";" +
   	            getDesigners();
   }
    
}
