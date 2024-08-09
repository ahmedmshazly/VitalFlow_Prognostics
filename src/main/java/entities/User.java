package main.java.entities;

public abstract class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userType;  // New attribute to store the user type


    public User(int userId, String firstName, String lastName, String email, String password, String userType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = userType; // Initialize user type during construction
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void login() {
        System.out.println("User " + firstName + " has logged in.");
    }

    public void logout() {
        System.out.println("User " + firstName + " has logged out.");
    }

    public void updatePersonalInfo() {
        System.out.println("Updating personal info for " + firstName);
    }

    public abstract void viewPersonalInfo();
    public abstract void accessSpecificData();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' + // Include userType in toString for debugging
                '}';
    }

    // New method to get the user type
    public Object getType() {
        return userType;
    }
}
