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
    
}
