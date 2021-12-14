import com.sun.tools.javac.Main;

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
        games.add(new Game("Halo"));
        games.add(new Game("Minecraft"));
        games.add(new Game("League of Legends1"));
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
                    System.out.println("Game: " + i.gameName);
                }
                break;
            case 2:
                break;
        }
    }
}