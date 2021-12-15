import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainMenu {

    private ArrayList<Employee> emps;
    private Employee emp;
    ArrayList<Game> games = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public MainMenu(ArrayList<Employee> emps, Employee emp) {
        this.emps = emps;
        this.emp = emp;
        populateStock();
        if (emps.isEmpty()) {
            mainMenu();
        } else {
            adminMenu();
        }
    }

    private void adminMenu() {
        System.out.println("Welcome to GameStock's Stock System, admin " + emp.getForename() + ".");
        System.out.println("Please select your option from the choices below.");
        System.out.println("1 - View stock");
        System.out.println("2 - Add Stock");
        System.out.println("3 - Load previous stock data (NOT WORKING)");
        System.out.println("4 - Save current stock data (NOT WORKING)");
        System.out.println("5 - Account Settings");
        System.out.println("6 - Exit");
        int choice = Integer.parseInt(scn.nextLine());

        switch (choice) {
            case 1 -> displayGames();
            case 2 -> addStock();
            case 3 -> readData();           //These don't work yet - couldn't figure out how to read/write
            case 4 -> writeData();          //These don't work yet - couldn't figure out how to read/write
            case 5 -> adminSettings();
            case 6 -> System.exit(0);
            default -> System.out.println("Please select a valid option.");
        }
        //Add admin options when task requires it
    }

    private void populateStock() {
        games.add(new Game(121, "Bungie", "Halo Reach", 49.99, 10));
        games.add(new Game(124, "Mojang", "Minecraft", 20.00, 3));
        games.add(new Game(687, "Riot Games", "League of Legends", 0, 100));

    }

    private void mainMenu() {
        System.out.println("Welcome to GameStock's Stock System, " + emp.getForename() + ".");
        System.out.println("Please select your option from the choices below.");
        System.out.println("1 - View stock");
        System.out.println("2 - Add Stock");
        System.out.println("3 - Load previous stock data (NOT WORKING)");
        System.out.println("4 - Save current stock data (NOT WORKING)");
        System.out.println("5 - Account Settings");
        System.out.println("6 - Exit");
        int choice = Integer.parseInt(scn.nextLine());

        switch (choice) {
            case 1 -> displayGames();
            case 2 -> addStock();
            case 3 -> readData();           //These don't work yet - couldn't figure out how to read/write
            case 4 -> writeData();          //These don't work yet - couldn't figure out how to read/write
            case 5 -> userSettings();
            case 6 -> System.exit(0);
            default -> System.out.println("Please select a valid option.");
        }
        mainMenu();
    }


    //This is the beginning of the 'View Stock' option
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
        mainMenu();
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
        newStockValue(i, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void newStockValue(Game i, int x) {
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
    //This is the end of the 'View Stock' option


    //This is the beginning of the 'Add Stock' option
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
            mainMenu();
        }
    }


    //Reading and writing data - these don't work yet
    private void readData() {
        System.exit(0);
    }

    private void writeData() {
        System.exit(0);
    }


    //Admin Settings menu
    private void adminSettings() {
        System.out.println("Welcome to admin settings. Please select an option below:");
        System.out.println("1 - Change Password");
        System.out.println("2 - View users");
        System.out.println("3 - Main Menu");
        int choice = Integer.parseInt(scn.nextLine());
        switch (choice) {
            case 1 -> changePassword();
            case 2 -> viewUsers();
            case 3 -> mainMenu();
            default -> {
                System.out.println("Invalid option, please try again");
                adminSettings();
            }
        }
    }


    //User settings menu
    private void userSettings() {
        System.out.println("Welcome to user settings. Please select an option below:");
        System.out.println("1 - Change Password");
        System.out.println("2 - Main Menu");
        int choice = Integer.parseInt(scn.nextLine());
        switch (choice) {
            case 1 -> changePassword();
            case 2 -> mainMenu();
            default -> {
                System.out.println("Invalid option, please try again");
                userSettings();
            }
        }
    }


    private void changePassword() {
        System.out.println("Please enter your new password.");
        String newPass = new Scanner(System.in).nextLine();
        System.out.println("Please re-enter your new password.");
        String newPassConfirm = new Scanner(System.in).nextLine();
        if (Objects.equals(newPass, newPassConfirm)) {
            emp.setPassword(newPass);
            System.out.println("Your password has now been updated.");
            if (emp.isAdmin()) {
                adminSettings();
            } else userSettings();
        } else {
            System.out.println("Passwords do not match; try again.");
            changePassword();
        }
    }


    private void viewUsers() {
        if (!emps.isEmpty()) {
            int y = 1;
            System.out.println("Select the employee you would like to view.");
            for (Employee e : emps) {
                System.out.println(y + " -> Name: " + e.getForename());
                y++;
            }
            System.out.println(y + " -> Return to main menu");
            int choice = Integer.parseInt(new Scanner(System.in).nextLine());
            if (choice <= emps.size()) {
                empsEditMenu(choice);
            }
        }
        mainMenu();
    }

    private void empsEditMenu(int choice) {
        Employee e = emps.get(choice - 1);
        System.out.println("You are now viewing " + e.getForename() + " " + e.getSurname());
        System.out.println("Please select an option from below:");
        System.out.println("1 - Edit User Details");
        System.out.println("2 - Go back");
        handleChoice(e, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void handleChoice(Employee e, int choice) {
        switch (choice) {
            case 1 -> editUserDetails(e);
            case 2 -> adminSettings();
            default -> System.out.println("Invalid option provided, please try again");
        }
    }


    private void editUserDetails(Employee e) {
        System.out.println("Which field would you like to amend?");
        System.out.println("1 - Forename");
        System.out.println("2 - Surname");
        System.out.println("3 - Password");
        System.out.println("4 - Department");
        System.out.println("5 - Service");
        newUserValue(e, Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void newUserValue(Employee e, int x) {
        switch (x) {
            case 1 -> updateUserForename(e);
            case 2 -> updateUserSurname(e);
            case 3 -> updateUserID(e);
            case 4 -> updateUserUsername(e);
            case 5 -> updateUserPass(e);
            default -> System.out.println("Invalid option, please try again.");
        }
    }

    private void updateUserForename(Employee e) {
        System.out.println("The current value is " + e.getForename());
        System.out.println("Please enter the new value.");
        String newUserF = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + e.getForename() + " with " + newUserF + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            e.setForename(newUserF);
        }
        System.out.println("Forename has now been updated to " + newUserF);
        System.out.println("Would you like to edit more user details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editUserDetails(e);
        } else {
            System.out.println("Returning you to the user menu");
            viewUsers();
        }
    }

    private void updateUserSurname(Employee e) {
        System.out.println("The current value is " + e.getSurname());
        System.out.println("Please enter the new value.");
        String newUserS = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + e.getSurname() + " with " + newUserS + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            e.setSurname(newUserS);
        }
        System.out.println("Surname has now been updated to " + newUserS);
        System.out.println("Would you like to edit more user details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editUserDetails(e);
        } else {
            System.out.println("Returning you to the user menu");
            viewUsers();
        }
    }

    private void updateUserID(Employee e) {
        System.out.println("The current value is " + e.getUserID());
        System.out.println("Please enter the new value.");
        String newUserID = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + e.getUserID() + " with " + newUserID + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            e.setUserID(newUserID);
        }
        System.out.println("User ID has now been updated to " + newUserID);
        System.out.println("Would you like to edit more user details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editUserDetails(e);
        } else {
            System.out.println("Returning you to the user menu");
            viewUsers();
        }
    }

    private void updateUserUsername(Employee e) {
        System.out.println("The current value is " + e.getUsername());
        System.out.println("Please enter the new value.");
        String newUserU = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + e.getUsername() + " with " + newUserU + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            e.setUsername(newUserU);
        }
        System.out.println("Username has now been updated to " + newUserU);
        System.out.println("Would you like to edit more user details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editUserDetails(e);
        } else {
            System.out.println("Returning you to the user menu");
            viewUsers();
        }
    }

    private void updateUserPass(Employee e) {
        System.out.println("The current value is " + e.getPassword());
        System.out.println("Please enter the new value.");
        String newUserP = new Scanner(System.in).nextLine();
        System.out.println("Are you sure you want to replace " + e.getUsername() + " with " + newUserP + "?");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            e.setPassword(newUserP);
        }
        System.out.println("Username has now been updated to " + newUserP);
        System.out.println("Would you like to edit more user details? (yes/no)");
        if (new Scanner(System.in).nextLine().equalsIgnoreCase("yes")) {
            editUserDetails(e);
        } else {
            System.out.println("Returning you to the user menu");
            viewUsers();
        }
    }
}