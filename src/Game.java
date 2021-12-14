public class Game {

    private int ID;
    private String gameManufacturer;
    private String gameName;
    private double gamePrice;
    private int quantity;

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

    public String getGameManufacturer() {
        return gameManufacturer;
    }

    public String getGameName() {
        return gameName;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
