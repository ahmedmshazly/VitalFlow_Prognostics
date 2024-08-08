package java.prognosis;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    // Map to store users with username as the key and User object as the value
    private Map<String, User> users = new HashMap<>();

    // Enum for user types
    public enum UserType {
        ADMIN,
        PATIENT
    }

    // Method to create a user
    public void createUser(String userName, String password, UserType type, String firstName, String lastName,
                           String email, String dateOfBirth, boolean isHivPos, String diagnosisDate,
                           boolean isOnArt, String artStartDate, String countryIsoCode) {
        User user = null;
        switch (type) {
            case ADMIN:
                user = new Admin(1, firstName, lastName, email, password); // ID would typically be generated
                break;
            case PATIENT:
                user = new Patient(1, firstName, lastName, email, password, dateOfBirth, isHivPos, diagnosisDate,
                        isOnArt, artStartDate, countryIsoCode); // ID would typically be generated
                break;
            default:
                handleExceptionsAndErrors();
                return;
        }
        users.put(userName, user);
    }

    // Method to validate user type
    public boolean validateUserType(UserType type) {
        return type == UserType.ADMIN || type == UserType.PATIENT;
    }

    // Method to authenticate a user
    public User userAuthentication(String userName, String password) {
        User user = users.get(userName);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            handleExceptionsAndErrors();
            return null;
        }
    }

    // Method to handle exceptions and errors
    public void handleExceptionsAndErrors() {
        System.out.println("An error occurred. Please check the input and try again.");
    }
}
