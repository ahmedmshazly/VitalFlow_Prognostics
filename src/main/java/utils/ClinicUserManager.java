package main.java.utils;

import java.util.Scanner;
import java.util.UUID;
import java.util.Random;

public class ClinicUserManager {
    private static final String ADMIN_EMAIL = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private UserCommandExecutor commandExecutor;

    public ClinicUserManager() {
        commandExecutor = new UserCommandExecutor();
    }

    public static void main(String[] args) {
        ClinicUserManager manager = new ClinicUserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Admin Login");
            System.out.println("2. Complete Patient Registration");
            System.out.println("3. Patient Login");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.adminLogin(scanner);
                    break;
                case 2:
                    manager.completePatientRegistration(scanner);
                    break;
                case 3:
                    manager.patientLogin(scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice, please enter 1-4.");
            }
        }
    }

    private void adminLogin(Scanner scanner) {
        System.out.print("Enter admin email: ");
        String email = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (loginAdmin(email, password)) {
            System.out.println("Admin login successful.");
        } else {
            System.out.println("Admin login failed.");
        }
    }

    private boolean loginAdmin(String email, String password) {
        return email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD);
    }

    public void completePatientRegistration(Scanner scanner) {
        System.out.println("Complete Patient Registration:");
        System.out.print("Enter your UUID: ");
        String uuid = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        System.out.print("Enter your HIV status (true/false): ");
        boolean hivStatus = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Enter your diagnosis date (YYYY-MM-DD), leave blank if not applicable: ");
        String diagnosisDate = scanner.nextLine();
        if (diagnosisDate.isEmpty()) diagnosisDate = null;

        System.out.print("Are you on ART treatment? (true/false): ");
        boolean onART = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Enter your ART start date (YYYY-MM-DD), leave blank if not applicable: ");
        String artStartDate = scanner.nextLine();
        if (artStartDate.isEmpty()) artStartDate = null;

        System.out.print("Enter your country ISO code: ");
        String country = scanner.nextLine();

        System.out.print("Create a new password: ");
        String password = scanner.nextLine();
        String hashedPassword = commandExecutor.hashPassword(password);

        commandExecutor.addFullDetails(uuid, email, firstName, lastName, dob, String.valueOf(hivStatus), diagnosisDate, String.valueOf(onART), artStartDate, country, hashedPassword);
        System.out.println("Registration details completed successfully.");
    }

    public void patientLogin(Scanner scanner) {
        System.out.println("Patient Login:");
        System.out.print("Enter your UUID: ");
        String uuid = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (commandExecutor.validateLogin(uuid, password)) {
            System.out.println("Login successful. Welcome back!");
        } else {
            System.out.println("Login failed. Please check your credentials and try again.");
        }
    }

}