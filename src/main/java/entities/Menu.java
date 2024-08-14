package main.java.entities;

import java.io.Console;
import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import main.java.utils.FileHandler;
import main.java.utils.SecurityHandler;
import main.java.utils.DataValidator;
import main.java.user.UserRoles;
import main.java.user.Admin;
import main.java.user.Patient;
import main.java.utils.CLI;

public class Menu {
    public static void startPage() {
        System.out.println("Welcome to the Life Prognosis & Management Tool");
        System.out.println("\nChoose an option:");
        System.out.println("1. Login");
        System.out.println("2. Complete Registration");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    public static Object[] loginPage(Scanner scanner) {
        System.out.println("Login");
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        Console console = System.console();
        char[] passwordArray = console.readPassword("Enter password: ");
        String passsword = new String(passwordArray);
        // if (!FileHandler.validateEmail(email)){
        //     System.out.println("email doesn't exist.");
        //     System.out.print("Register now?(y/n): ");
        //     String option = scanner.nextLine();
        //     if (option.equals("y")){
        //         registerationPage();
        //     }else if (option.equals("n")){
        //         return;
        //     }else{
        //         System.out.println("Invalid option");
        //         return;
        //     }
        // }
        // if (!SecurityManager.verifyPassword(email, passsword)){
        //     System.out.println("Invalid Password");
        //     return;
        // }
        // userRoles role = SecurityManager.getRole(email);
        // return role;
        if (FileHandler.validateEmail(email)){
            if (SecurityHandler.verifyPassword(email, passsword)){
                return new Object[]{SecurityHandler.getRole(email), email, passsword};
            }else{
                System.out.println("Invalid Password");
            }
        }else {
            // CLI.clearScreen();
            System.out.println("Account doesn't exist!");
            System.out.println("Contact an Administrator.");
            CLI.sleep(2);
            CLI.clearScreen();
            // System.out.print("Register now?(y/n): ");
            // String option = scanner.nextLine();
            // if (option.equals("y")){
            //     registerationPage(scanner);
            // }else if (option.equals("n")){
            // }else{
            //     System.out.println("Invalid option");
            // }
        }
        Object[] nullObject = new Object[]{null,null,null};
        return nullObject;
    }

    public static void registerationPage(Scanner scanner) {
        CLI.clearScreen();
        System.out.println("Complete Registration Page!");
        System.out.print("Enter UUID: ");
        String uuid = scanner.nextLine();
        if (DataValidator.validateUUID(uuid)){
            System.out.print("Enter FirstName: ");
            String firstName = scanner.nextLine();
            Boolean breaker = DataValidator.validateName(firstName);
            if (!breaker){
                System.out.println("Invalid name!");
                return;
            }
            System.out.print("Enter LastName: ");
            String lastName = scanner.nextLine();
            breaker = DataValidator.validateName(lastName);
            if (!breaker){
                System.out.println("Invalid name!");
                return;
            }
            Console console = System.console();
            char[] passwordArray = console.readPassword("Enter password: ");
            String passsword = new String(passwordArray);
            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String DOB = scanner.nextLine();
            breaker = DataValidator.validateDOB(DOB);
            if (!breaker){
                System.out.println("Invalid Date of Birth");
                return;
            }
            System.out.print("Enter ISO (Alpha-2) eg: Rwanda-RW: ");
            String ISO = scanner.nextLine();
            breaker = DataValidator.validateISO(ISO);
            if (!breaker) {
                System.out.println("Invalid ISO! Make sure it's in Alpha-2 code format");
                return;
            }
            System.out.print("Are you HIV positive? (y/n): ");
            String opt1 = scanner.nextLine();
            Boolean hivStatus;
            String diagnosisDate;
            Boolean isOnArt;
            String ArtStartDate;
            double isoExpectancy = getISOLifeExpectancy(ISO);
            if (opt1.equals("y")){
                hivStatus = true;
                System.out.print("Enter Diagnosis Date (YYYY-MM-DD): ");
                diagnosisDate = scanner.nextLine();
                breaker = DataValidator.validateHIVStatusAndDiagnosisDate(hivStatus, diagnosisDate);
                if (!breaker){
                    System.out.println("Invalid Diagnosis Date!");
                    return;
                }
                System.out.print("Are you on ART medications? (y/n): ");
                String opt2 = scanner.nextLine();
                if (opt2.equals("y")){
                    isOnArt = true;
                    System.out.print("Enter ART Start Date (YYYY-MM-DD): ");
                    ArtStartDate = scanner.nextLine();
                    breaker = DataValidator.validateIsOnARTandStartDate(isOnArt, ArtStartDate);
                    if (!breaker){
                        System.out.println("Invalid ART Start Date!");
                        return;
                    }
                } else if (opt2.equals("n")){
                    isOnArt = false;
                    ArtStartDate = null;
                }else{
                    System.out.println("Invalid option!");
                    return;
                }
            }else if (opt1.equals("n")){
                hivStatus = false;
                diagnosisDate = null;
                isOnArt = null;
                ArtStartDate = null;
                ISO = null;
            }else{
                System.out.println("Invalid option!");
                return;
            }
            int remainingYears = calculateRemainingYears(isoExpectancy, hivStatus, isOnArt, DOB, diagnosisDate, ArtStartDate);
            FileHandler.finalPatientRegister(uuid,firstName,lastName,DOB,hivStatus,diagnosisDate,isOnArt,ArtStartDate,ISO,passsword, remainingYears);
            System.out.println("Registration Complete");
            CLI.sleep(2);
            CLI.clearScreen();
        } else {
            System.out.println("User does not Exist!");
        }
    }

    public static void adminPage(Admin admin, Scanner scanner) {
        int choice;
        do{
            CLI.clearScreen();
            System.out.println("Welcome Admin!");
            System.out.println("\nChoose an option:");
            System.out.println("1. Register User");
            System.out.println("2. Export Data");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
            }else{
                scanner.nextLine();
                System.out.println("Please enter a valid number.");
                continue;
            }
            switch (choice) {
                case 1:
                    CLI.clearScreen();
                    adminPatientRegister(admin, scanner);
                    break;
                case 2:
                    CLI.clearScreen();
                    System.out.println("Export Data");
                    break;
                case 0:
                    CLI.clearScreen();
                    return;
                default:
                    CLI.clearScreen();
                    System.out.println("Invalid choice, please enter 0-2.");
            }
        }
        while(true);
    }

    public static void adminPatientRegister(Admin admin, Scanner scanner) {
        CLI.clearScreen();
        System.out.println("New User Registration");
        System.out.print("\nEnter New User email: ");
        String email = scanner.nextLine();
        admin.initialPatientRegister(email);
    }

    public static void patientPage(Patient patient, Scanner scanner) {
        String[] details = FileHandler.getPatientDetails(patient.getEmail());
        int choice;
        do { 
            CLI.clearScreen();
            System.out.println("Welcome " + details[4] + "!");
            System.out.println("\nChoose an option:");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. Export .ics File");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
            }else{
                scanner.nextLine();
                System.out.println("Please enter a valid number.");
                continue;
            }
            switch (choice) {
                case 1:
                    CLI.clearScreen();
                    displayPatientData(details, scanner);
                    break;
                case 2:
                    CLI.clearScreen();
                    updatePatientPage(details[0], scanner);
                    break;
                case 3:
                    CLI.clearScreen();
                    System.out.println("Export ICS...");
                    break;
                case 0:
                    CLI.clearScreen();
                    return;
                default:
                    CLI.clearScreen();
                    System.out.println("Invalid choice, please enter 0-2.");
            }
        } while (true);
    }

    public static double getISOLifeExpectancy(String ISO) {
        return FileHandler.getISOLifeExpectancy(ISO);
    }

    public static int calculateRemainingYears(double isoExpectancy, Boolean hivStatus, Boolean isOnArt, String dob, String diagnosisDate, String ArtStartDate) {
        LocalDate parsedDob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int age = Period.between(parsedDob, LocalDate.now()).getYears();

        if (!hivStatus) {
            return (int) isoExpectancy - age;
        }
        LocalDate parsedDiagnosisDate = LocalDate.parse(diagnosisDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (hivStatus && !isOnArt){
            return 5 + parsedDiagnosisDate.getYear() - age;
        }
        LocalDate parsedArtStartDate = LocalDate.parse(ArtStartDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int diagnosisToArtStartYears = Period.between(parsedDiagnosisDate, parsedArtStartDate).getYears();

        if (hivStatus && isOnArt) {
            double remainingYears = (isoExpectancy - age - diagnosisToArtStartYears) * 0.90;

            for (int i = 0; i < diagnosisToArtStartYears; i++) {
                remainingYears *= 0.90;
            }
            return (int) remainingYears;
        }
        return 0;
    }

    public static void displayPatientData(String[] data, Scanner scanner) {
        CLI.clearScreen();
        int choice;
        do{
            String format = "%-20s: %-30s%n";
            System.out.println("------------ Profile ------------");
            System.out.printf(format, "UUID", data[0]);
            System.out.printf(format, "Name", data[4] + " " + data[5]);
            System.out.printf(format, "Date of Birth", data[6]);
            System.out.printf(format, "Country", data[11]);
            System.out.printf(format, "HIV Positive", data[7].equals("true") ? "Yes" : "No");
            System.out.printf(format, "Diagnosis Date", data[8]);
            System.out.printf(format, "On ART Medication", data[9].equals("true") ? "Yes" : "No");
            System.out.printf(format, "Start ART Date", data[10]);
            System.out.printf(format, "Years to live", data[12]);
            System.out.println("0. Exit\t 1. Update Profile");
            System.out.print("Enter choice: ");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
            }else{
                scanner.nextLine();
                System.out.println("Please enter a valid number.");
                continue;
            }
            switch (choice) {
                case 1:
                    updatePatientPage(data[0], scanner);
                    break;
                case 0:
                    return;
                default:
                    CLI.clearScreen();
                    System.out.println("Invalid choice, please enter 0/1.");
            }
        }
        while(true);
    }

    public static void updatePatientPage(String uuid, Scanner scanner) {
        CLI.clearScreen();
        System.out.println("Updating User Details");
        System.out.print("Enter FirstName: ");
        String firstName = scanner.nextLine();
        Boolean breaker = DataValidator.validateName(firstName);
        if (!breaker){
            System.out.println("Invalid name!");
            return;
        }
        System.out.print("Enter LastName: ");
        String lastName = scanner.nextLine();
        breaker = DataValidator.validateName(lastName);
        if (!breaker){
            System.out.println("Invalid name!");
            return;
        }
        Console console = System.console();
        char[] passwordArray = console.readPassword("Enter password: ");
        String passsword = new String(passwordArray);
        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String DOB = scanner.nextLine();
        breaker = DataValidator.validateDOB(DOB);
        if (!breaker){
            System.out.println("Invalid Date of Birth");
            return;
        }
        System.out.print("Enter ISO (Alpha-2) eg: Rwanda-RW: ");
        String ISO = scanner.nextLine();
        breaker = DataValidator.validateISO(ISO);
        if (!breaker) {
            System.out.println("Invalid ISO! Make sure it's in Alpha-2 code format");
            return;
        }
        System.out.print("Are you HIV positive? (y/n): ");
        String opt1 = scanner.nextLine();
        Boolean hivStatus;
        String diagnosisDate;
        Boolean isOnArt;
        String ArtStartDate;
        double isoExpectancy = getISOLifeExpectancy(ISO);
        if (opt1.equals("y")){
            hivStatus = true;
            System.out.print("Enter Diagnosis Date (YYYY-MM-DD): ");
            diagnosisDate = scanner.nextLine();
            breaker = DataValidator.validateHIVStatusAndDiagnosisDate(hivStatus, diagnosisDate);
            if (!breaker){
                System.out.println("Invalid Diagnosis Date!");
                return;
            }
            System.out.print("Are you on ART medications? (y/n): ");
            String opt2 = scanner.nextLine();
            if (opt2.equals("y")){
                isOnArt = true;
                System.out.print("Enter ART Start Date (YYYY-MM-DD): ");
                ArtStartDate = scanner.nextLine();
                breaker = DataValidator.validateIsOnARTandStartDate(isOnArt, ArtStartDate);
                if (!breaker){
                    System.out.println("Invalid ART Start Date!");
                    return;
                }
            } else if (opt2.equals("n")){
                isOnArt = false;
                ArtStartDate = null;
            }else{
                System.out.println("Invalid option!");
                return;
            }
        }else if (opt1.equals("n")){
            hivStatus = false;
            diagnosisDate = null;
            isOnArt = null;
            ArtStartDate = null;
            ISO = null;
        }else{
            System.out.println("Invalid option!");
            return;
        }
        int remainingYears = calculateRemainingYears(isoExpectancy, hivStatus, isOnArt, DOB, diagnosisDate, ArtStartDate);
        System.out.println(remainingYears);
        FileHandler.UpdatePatientDetails(uuid,firstName,lastName,DOB,hivStatus,diagnosisDate,isOnArt,ArtStartDate,ISO,passsword, remainingYears);
        System.out.println("Update Complete!");
        CLI.sleep(2);
        CLI.clearScreen();
    }
}