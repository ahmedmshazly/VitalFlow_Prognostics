package main.java.user;
import main.java.utils.UserCommandExecutor;
import java.util.UUID;

public class Admin implements User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserCommandExecutor userCommandExecutor;

    public Admin(String firstName, String lastName, String email, String password, UserCommandExecutor userCommandExecutor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userCommandExecutor = userCommandExecutor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void updateProfile(String firstName, String lastName, String email, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }

    public void exportData(String fileName) {
        try {
//            userCommandExecutor.generateCSV(fileName);
        } catch (Exception e) {
            System.err.println("Failed to export data: " + e.getMessage());
        }
    }

    public void downloadCSVFiles() {
        exportData("users.csv");
        exportData("analytics.csv");
    }
}
