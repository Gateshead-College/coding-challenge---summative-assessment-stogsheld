import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    ArrayList<Game> games = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.populateStock();
        menu.startup();

    }

    private void populateStock() {
        games.add(new Game(121, "Bungie", "Halo Reach", 49.99, 10));
        games.add(new Game(124, "Mojang", "Minecraft", 20.00, 3));
        games.add(new Game(687, "Riot Games", "League of Legends", 0, 100));

    }

    private void startup() {
        System.out.println("Welcome to GameStock's Stock System!");
        System.out.println("Please select your option from the choices below.");
        System.out.println("1 - View stock");
        System.out.println("2 - Exit");
        byte choice = Byte.parseByte(scn.nextLine());

        switch(choice) {
            case 1:
                for(Game i : games) {
                    System.out.println("ID: " + i.getID() +  " - Manufacturer: " + i.getGameManufacturer() + " - Name: " + i.getGameName() + " - Price: " + i.getGamePrice() + " - Stock: " + i.getQuantity());
                }
                break;
            case 2:
                break;
        }
    }
}