package main.java.control;

import main.java.entities.Admin;
import main.java.entities.Patient;
import main.java.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users = new HashMap<>();
    private FileHandler fileHandler;


    public UserManager() {
        // Initialize with a fixed admin account for simplicity in this setup
        this.fileHandler = new FileHandler();
        users.put("admin@example.com", new Admin(1, "Admin", "User", "admin@example.com", "password123"));
//        users.put("patient@example.com", new Patient(1, "Patient", "User", "patient@example.com", "password123"));

    }

    // Validates UUID and returns associated email if valid
    public String validateUUID(String uuid) {
        // Here we should integrate with FileHandler to check if the UUID exists in the user-store.txt
        String email = fileHandler.getEmailFromUUID(uuid);
        if (email != null) {
            return email;
        }
        return null;
    }


    // Sets the password for a patient identified by email
    public boolean setPassword(String email, String password) {
        User user = users.get(email);
        if (user != null && user instanceof Patient) {
            user.setPassword(fileHandler.passwordHash(password)); // Assuming passwordHash hashes the password.
            return true;  // Indicate success
        }
        return false;  // Indicate failure
    }

    // Updates patient's health details
    public boolean updatePatientDetails(String email, String dob, boolean hivStatus, String diagnosisDate, boolean isOnART, String artStartDate, String countryIsoCode) {
        User user = users.get(email);
        if (user != null) {
            Patient patient = (Patient) user;
            // Assuming setters for all these properties exist in the Patient class
            patient.setDOB(dob);
            patient.setHivStatus(hivStatus);
            patient.setDiagnosisDate(diagnosisDate);
            patient.setOnART(isOnART);
            patient.setARTStartDate(artStartDate);
            patient.setCountryIsoCode(countryIsoCode);
            patient.viewPersonalInfo();
            return true;  // Indicate success
        }
        return false;  // Indicate failure
    }

    public User createUser(String userName, String password, String firstName, String lastName, String email) {
        if (!users.containsKey(email)) {
            User newUser = new Admin(users.size() + 1, firstName, lastName, email, password);
            users.put(email, newUser);
            return newUser;
        } else {
            return null;
        }
    }

    public User authenticateUser(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            user.login();
            return user;
        } else {
            System.out.println("Authentication failed for user: " + email);
            return null;
        }
    }
}
