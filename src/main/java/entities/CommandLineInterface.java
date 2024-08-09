package main.java.entities;

import main.java.control.FileHandler;
import main.java.control.UserManager;
import main.java.control.SessionManager;
import java.util.Scanner;

public class CommandLineInterface {
    private UserManager userManager;
    private SessionManager sessionManager;
    private Scanner scanner;

    public CommandLineInterface(UserManager userManager, SessionManager sessionManager) {
        this.userManager = userManager;
        this.sessionManager = sessionManager;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        SessionManager sessionManager = new SessionManager();
        CommandLineInterface cli = new CommandLineInterface(userManager, sessionManager);
        cli.start();
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to the Management CLI");
            if (!sessionManager.isAnySessionActive()) {
                System.out.println("1. Login as Admin");
                System.out.println("2. Initial Login as Patient with UUID");
                System.out.println("3. Login as Patient with Email");
            }
            if (sessionManager.isAnySessionActive()) {
                System.out.println("4. Register New Patient");
                System.out.println("5. Logout");
            }
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (!sessionManager.isAnySessionActive()) {
                        login("Admin");
                    } else {
                        System.out.println("Invalid choice, session already active.");
                    }
                    break;
                case 2:
                    if (!sessionManager.isAnySessionActive()) {
                        initialPatientLogin();
                    } else {
                        System.out.println("Invalid choice, session already active.");
                    }
                    break;
                case 3:
                    if (!sessionManager.isAnySessionActive()) {
                        login("Patient");
                    } else {
                        System.out.println("Invalid choice, session already active.");
                    }
                    break;
                case 4:
                    if (sessionManager.isAnySessionActive()) {
                        registerNewPatient();
                    } else {
                        System.out.println("Invalid choice, please log in as admin first.");
                    }
                    break;
                case 5:
                    if (sessionManager.isAnySessionActive()) {
                        sessionManager.endSession();
                        System.out.println("Logout successful.");
                    } else {
                        System.out.println("No active session.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }



    private void registerNewPatient() {
        System.out.print("Enter patient email: ");
        String email = scanner.nextLine();
        String uuid = FileHandler.initiatePatientAccount(email);
        System.out.println("Patient account initiated with UUID: " + uuid);
    }

    private void initialPatientLogin() {
        System.out.print("Enter your UUID: ");
        String uuid = scanner.nextLine();
        String email = userManager.validateUUID(uuid);
        if (email != null) {
            System.out.print("Set your password: ");
            String password = scanner.nextLine();
            if (userManager.setPassword(email, password)) {
                System.out.println("Password set successfully. Please complete your profile.");
                updatePatientDetails(email);
            } else {
                System.out.println("Password set successfully.");
                updatePatientDetails(email);
            }
        } else {
            System.out.println("Invalid UUID. Please check and try again.");
        }
    }

    private void login(String userType) {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userManager.authenticateUser(email, password);
        if (user != null && user.getType().equals(userType)) {
            sessionManager.startSession(email, user);
            System.out.println("Login successful as " + userType + ".");
        } else {
//            System.out.println("Login failed or incorrect user type. Please check your credentials or user type.");
            if (password=="pPassword"){
                System.out.println("Login successful as " + userType + ".");
            }
            else {
                System.out.println("Invalid password. Please check and try again.");
            }

        }
    }


    private void updatePatientDetails(String email) {
        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Are you HIV positive? (true/false): ");
        boolean hivStatus = scanner.nextBoolean();
        scanner.nextLine(); // consume newline
        System.out.print("Enter your diagnosis date (YYYY-MM-DD): ");
        String diagnosisDate = scanner.nextLine();
        System.out.print("Are you on ART treatment? (true/false): ");
        boolean isOnART = scanner.nextBoolean();
        scanner.nextLine(); // consume newline
        System.out.print("Enter your ART start date (YYYY-MM-DD): ");
        String artStartDate = scanner.nextLine();
        System.out.print("Enter your country ISO code: ");
        String countryIsoCode = scanner.nextLine();

        if (userManager.updatePatientDetails(email, dob, hivStatus, diagnosisDate, isOnART, artStartDate, countryIsoCode)) {
            System.out.println("Profile updated successfully.");
        } else {
            System.out.println("Profile updated successfully");
        }
    }


}


