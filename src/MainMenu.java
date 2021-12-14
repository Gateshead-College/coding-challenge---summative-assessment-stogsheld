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
        System.out.println("2 - Add Stock");
        System.out.println("3 - Exit");
        int choice = Integer.parseInt(scn.nextLine());

        switch (choice) {
            case 1 -> displayGames();
            case 2 -> addStock();
            case 3 -> System.exit(0);
        }
    }



    private void addStock() {
        System.out.println("Please enter the ID of the game you would like to add:");
        int addID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Please enter the game's manufacturer:");
        String addManu = new Scanner(System.in).nextLine();
        System.out.println("What's the name of the game? (No ABBA games allowed)");
        String addGame = new Scanner(System.in).nextLine();
        System.out.println("What's the price?");
        double addPrice = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println("And how many do we have in stock?");
        int addQty = Integer.parseInt(new Scanner(System.in).nextLine());
        games.add(new Game(addID, addManu, addGame, addPrice, addQty));
        System.out.println("Your game has now been added. Would you like to add another?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            addStock();
        } else {
            startup();
        }
    }

    private void displayGames() {
        if (!games.isEmpty()) {
            int y = 1;
            System.out.println("Select the game you would like to view.");
            for (Game i : games) {
                System.out.println(y + " -> ID: " + i.getID() + " - Manufacturer: " + i.getGameManufacturer() + " - Name: " + i.getGameName() + " - Price: £" + i.getGamePrice() + " - Stock: " + i.getQuantity());
                y++;
            }
            System.out.println(y + " -> Return to main menu");
            int choice = Integer.parseInt(new Scanner(System.in).nextLine());
            if (choice <= games.size()) {
                gamesEditMenu(choice);
            }
        }
        startup();
    }

    private void gamesEditMenu(int choice) {
        Game i = games.get(choice - 1);
        System.out.println("You are now viewing " + i.getGameName());
        System.out.println("Please select an option from below:");
        System.out.println("1 - Edit Game Details");
        System.out.println("2 - Delete Game Details");
        System.out.println("3 - Go back");
        editGamesChoice(i, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void editGamesChoice(Game i, int gamesChoice) {
        switch (gamesChoice) {
            case 1 -> editDetails(i);
            case 2 -> deleteDetails(i);
            case 3 -> displayGames();
            default -> System.out.println("Invalid option, please try again");
        }
    }


    private void deleteDetails(Game i) {
        System.out.println("Are you sure you want to delete the details for " + i.getGameName() + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Please enter the game's ID to confirm:");
            int checkID = Integer.parseInt(scn.nextLine());
            if (checkID == i.getID()) {
                System.out.println("Deleting record now...");
                games.remove(i);
            } else {
                System.out.println("Invalid ID, please try again");
            }
        } else {
            System.out.println("Cancelling now");
            displayGames();
        }
    }

    private void editDetails(Game i) {
        System.out.println("Which detail would you like to change?");
        System.out.println("1 - Game ID");
        System.out.println("2 - Manufacturer");
        System.out.println("3 - Game Name");
        System.out.println("4 - Game Price");
        System.out.println("5 - Game Stock (Qty)");
        newValue(i, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void newValue(Game i, int x) {
        switch (x) {
            case 1 -> updateGameID(i);
            case 2 -> updateManufacturer(i);
            case 3 -> updateGameName(i);
            case 4 -> updateGamePrice(i);
            case 5 -> updateGameQty(i);
            default -> System.out.println("Invalid option, please try again.");
        }
    }

    private void updateGameQty(Game i) {
        System.out.println("The current value is " + i.getQuantity());
        System.out.println("Please enter the new value.");
        String newQty = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + i.getQuantity() + " with " + newQty + "? Please enter the game's ID to confirm.");
        int checkID = Integer.parseInt(scn.nextLine());
        if (checkID == i.getID()) {
            i.setQuantity(Integer.parseInt(newQty));
        }
        System.out.println("Quantity available has now been updated to " + newQty);
        System.out.println("Would you like to edit more game details?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editDetails(i);
        } else {
            System.out.println("Returning you to the stock menu");
            displayGames();
        }
    }

    private void updateGamePrice(Game i) {
        System.out.println("The current value is " + i.getGamePrice());
        System.out.println("Please enter the new value.");
        String newPrice = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + i.getGamePrice() + "with " + newPrice + "? Please enter the game's ID to confirm.");
        int checkID = Integer.parseInt(scn.nextLine());
        if (checkID == i.getID()) {
            i.setGamePrice(Integer.parseInt(newPrice));
        }
        System.out.println("Price has now been updated to " + newPrice);
        System.out.println("Would you like to edit more game details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editDetails(i);
        } else {
            System.out.println("Returning you to the stock menu");
            displayGames();
        }
    }

    private void updateGameName(Game i) {
        System.out.println("The current value is " + i.getGameName());
        System.out.println("Please enter the new value.");
        String newName = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + i.getGameName() + "with " + newName + "?");
        int checkID = Integer.parseInt(scn.nextLine());
        if (checkID == i.getID()) {
            i.setGameName(newName);
        }
        System.out.println("Name has now been updated to " + newName);
        System.out.println("Would you like to edit more game details?");
        System.out.println("Would you like to edit more game details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editDetails(i);
        } else {
            System.out.println("Returning you to the stock menu");
            displayGames();
        }
    }

    private void updateManufacturer(Game i) {
        System.out.println("The current value is " + i.getGameManufacturer());
        System.out.println("Please enter the new value.");
        String newManu = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + i.getGameManufacturer() + " with " + newManu + "? Please enter the game's ID to confirm.");
        int checkID = Integer.parseInt(scn.nextLine());
        if (checkID == i.getID()) {
            i.setGameManufacturer(newManu);
        }
        System.out.println("Manufacturer has now been updated to " + newManu);
        System.out.println("Would you like to edit more game details?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editDetails(i);
        } else {
            System.out.println("Returning you to the stock menu");
            displayGames();
        }
    }

    private void updateGameID(Game i) {
        System.out.println("The current value is " + i.getID());
        System.out.println("Please enter the new value.");
        String newID = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + i.getID() + " with " + newID + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            i.setID(Integer.parseInt(newID));
        }
        System.out.println("Game ID has now been updated to " + newID);
        System.out.println("Would you like to edit more game details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editDetails(i);
        } else {
            System.out.println("Returning you to the stock menu");
            displayGames();
        }
    }
}