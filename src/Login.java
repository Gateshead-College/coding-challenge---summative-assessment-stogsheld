import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<Employee> emps = new ArrayList<>();

    public static void main(String[] args) {
        Login log = new Login();
        log.populateEmployees();
        log.login();
    }

    public void populateEmployees() {
        emps.add(new Employee("Oliver", "Jennings", "123ACB", "stogsheld", "pass123", true));
        emps.add(new Employee("Lionel", "Messi", "FCB", "messi9", "ball", false));
        emps.add(new Employee("Alex", "Turner", "AM", "tranq", "base", false));

    }

    private void login() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("    (:            Welcome to the Gamestock system!            :)    ");
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
        System.out.println("Please enter your username to begin.");
        String username = new Scanner(System.in).nextLine();
        System.out.println();
        System.out.println("Please enter your password");
        String password = new Scanner(System.in).nextLine();
        for (Employee e : emps) {
            if (e.getUsername().equalsIgnoreCase(username) && e.getPassword().equals(password)) {
                if (e.isAdmin()) {
                    System.out.println("Logging you into the admin menu now, " + e.getForename() + "!");
                    new MainMenu(emps, e);
                } else {
                    System.out.println("Logging you into the main menu now, " + e.getForename() + "!");
                    new MainMenu(new ArrayList<>(), e);
                }
            } else if (emps.indexOf(e) == emps.size()) {
                System.out.println("Invalid username and/or password, please try again.");
                login();
            }
        }
        System.exit(0);
    }
}


