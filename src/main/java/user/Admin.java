package main.java.user;

import java.util.UUID;
import main.java.user.UserRoles;
import main.java.utils.FileHandler;
import main.java.utils.CLI;

public class Admin extends User {

    public Admin(String email, String password) {
        super(null, null, email, password,UserRoles.ADMIN); // Specify user type as "Admin"
    }

    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void initialPatientRegister(String email) {
        UUID patientUuid = generateUUID();
        if (patientUuid != null) {
            System.out.println("Patient UUID: " + patientUuid.toString());
            FileHandler.initialPatientRegister(patientUuid.toString(), email);
            CLI.sleep(10);
        }
    }

    // public void sendUUID() {
    //     UUID uuid = generateUUID();
    //     System.out.println("Sending UUID: " + uuid);
    // }

    public void exportUserDataCSV() {
        System.out.println("Exporting user data to CSV...");
    }

    public void exportAnalyticsCSV() {
        System.out.println("Exporting analytics data to CSV...");
    }

    // public void accessSettings() {
    //     System.out.println("Accessing settings...");
    // }

    // public void manageTools() {
    //     System.out.println("Managing tools...");
    // }

    // public void initiateSecureDataExport() {
    //     System.out.println("Initiating secure data export...");
    // }

    // @Override
    // public void viewPersonalInfo() {
    //     System.out.println("Viewing personal info for " + getFirstName());
    // }

    // @Override
    // public void accessSpecificData() {
    //     System.out.println("Accessing specific data for " + getFirstName());
    // }
}