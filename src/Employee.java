public class Employee {

    private String forename;
    private String surname;
    private String userID;
    private String username;
    private String password;
    private boolean admin;

    public Employee(String forename, String surname, String userID, String username, String password, boolean admin) {
        this.forename = forename;
        this.surname = surname;
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
