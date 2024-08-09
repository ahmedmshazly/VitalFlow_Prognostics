package main.java.entities;

import java.util.UUID;

public class Admin extends User {

    public Admin(int userId, String firstName, String lastName, String email, String password) {
        super(userId, firstName, lastName, email, password, "Admin"); // Specify user type as "Admin"
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void sendUUID() {
        UUID uuid = generateUUID();
        System.out.println("Sending UUID: " + uuid);
    }

    public void exportUserDataCSV() {
        System.out.println("Exporting user data to CSV...");
    }

    public void exportAnalyticsCSV() {
        System.out.println("Exporting analytics data to CSV...");
    }

    public void accessSettings() {
        System.out.println("Accessing settings...");
    }

    public void manageTools() {
        System.out.println("Managing tools...");
    }

    public void initiateSecureDataExport() {
        System.out.println("Initiating secure data export...");
    }

    @Override
    public void viewPersonalInfo() {
        System.out.println("Viewing personal info for " + getFirstName());
    }

    @Override
    public void accessSpecificData() {
        System.out.println("Accessing specific data for " + getFirstName());
    }
}
