public class Game {

    public int ID;
    public int quantity;
    private String gameManufacturer;
    private String gameName;
    private double gamePrice;


    public Game(int ID, String gameManufacturer, String gameName, double gamePrice, int quantity) {
        this.ID = ID;
        this.gameManufacturer = gameManufacturer;
        this.gameName = gameName;
        this.gamePrice = gamePrice;
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGameManufacturer() {
        return gameManufacturer;
    }

    public void setGameManufacturer(String gameManufacturer) {
        this.gameManufacturer = gameManufacturer;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
