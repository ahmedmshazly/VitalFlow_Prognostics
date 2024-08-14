package main.java.user;

public abstract class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected UserRoles role;  // New attribute to store the user type


    public User(String firstName, String lastName, String email, String password, UserRoles role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role; // Initialize user type during construction
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    //getter and setter for roles

    // public void login() {
    //     System.out.println("User " + firstName + " has logged in.");
    // }

    // public void logout() {
    //     System.out.println("User " + firstName + " has logged out.");
    // }

    // public void updatePersonalInfo() {
    //     System.out.println("Updating personal info for " + firstName);
    // }

    // public abstract void viewPersonalInfo();
    // public abstract void accessSpecificData();

    // @Override
    // public String toString() {
    //     return "User{" +
    //             "userId=" + userId +
    //             ", firstName='" + firstName + '\'' +
    //             ", lastName='" + lastName + '\'' +
    //             ", email='" + email + '\'' +
    //             ", password='" + password + '\'' +
    //             ", userType='" + userType + '\'' + // Include userType in toString for debugging
    //             '}';
    // }

}