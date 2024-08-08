package java.prognosis;

// Make the class abstract
public abstract class User {
    // Attributes
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Constructor
    public User(int userId, String firstName, String lastName, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    // Concrete methods
    public void login() {
        System.out.println("User " + firstName + " has logged in.");
    }

    public void logout() {
        System.out.println("User " + firstName + " has logged out.");
    }

    public void passwordManager() {
        System.out.println("Password management for " + firstName);
    }

    // Abstract methods
    public abstract void viewPersonalInfo();

    public abstract void accessSpecificData();

    public void updatePersonalInfo() {
        System.out.println("Updating personal info for " + firstName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
