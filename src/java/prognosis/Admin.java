package java.prognosis;

import java.util.UUID;

public class Admin extends User {
    // Constructor
    public Admin(int userId, String firstName, String lastName, String email, String password) {
        super(userId, firstName, lastName, email, password);
    }

    // Method to generate a UUID
    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    // Method to send a UUID (this just returns a new UUID in this example)
    public UUID sendUUID() {
        UUID uuid = generateUUID();
        System.out.println("Sending UUID: " + uuid);
        return uuid;
    }

    // Method to export user data to a CSV file
    public void exportUserDataCSV() {
        System.out.println("Exporting user data to CSV...");
        // Implement CSV export logic here
    }

    // Method to export analytics data to a CSV file
    public void exportAnalyticsCSV() {
        System.out.println("Exporting analytics data to CSV...");
        // Implement CSV export logic here
    }

    // Method to access settings
    public void accessSettings() {
        System.out.println("Accessing settings...");
        // Implement settings access logic here
    }

    // Method to manage tools
    public void manageTools() {
        System.out.println("Managing tools...");
        // Implement tool management logic here
    }

    // Method to initiate secure data export
    public void initiateSecureDataExport() {
        System.out.println("Initiating secure data export...");
        // Implement secure data export logic here
    }

    // Implement abstract methods from User class
    @Override
    public void viewPersonalInfo() {
        System.out.println("Viewing personal info for " + getFirstName());
    }

    @Override
    public void accessSpecificData() {
        System.out.println("Accessing specific data for " + getFirstName());
    }
}
