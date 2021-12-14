import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<Employee> gameStockEmployees = new ArrayList<>();

    public static void main(String[] args) {
        Login log = new Login();
        log.populateEmployees();
        log.login();
    }

    private void populateEmployees() {
        gameStockEmployees.add(new Employee("Oliver", "Jennings", "123ACB", "stogsheld", "pass123", false));

    }

    private void login() {
        System.out.println("Welcome to the Gamestock system! Please enter your username to begin.");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Please enter your password");
        String password = new Scanner(System.in).nextLine();
        for (Employee e : gameStockEmployees) {
            if (e.getUsername().equalsIgnoreCase(username) && e.getPassword().equals(password)) {
                if (e.isAdmin()) {
                    new MainMenu(gameStockEmployees, e);
                } else {
                    new MainMenu(new ArrayList<>(), e);
                }
            } else if (gameStockEmployees.indexOf(e) == gameStockEmployees.size()) {
                System.out.println("Invalid username and/or password, please try again.");
                login();
            }
        }
        System.exit(0);
    }
}


