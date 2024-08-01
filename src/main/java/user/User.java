package main.java.user;

public interface User {

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getEmail();
    void setEmail(String email);

    String getPassword();
    void setPassword(String password);

    boolean login(String email, String password);

    void updateProfile(String firstName, String lastName, String email, String password);
}
