package main.java.main;

import java.util.Scanner;
import main.java.entities.Menu;
import main.java.utils.CLI;
import main.java.user.UserRoles;
import main.java.user.Admin;
import main.java.user.Patient;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) { 
            // CLI.clearScreen();
            Menu.startPage();
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
            }else{
                scanner.nextLine();
                CLI.clearScreen();
                System.out.println("Please enter a valid number.");
                continue;
            }
            switch (choice) {
                case 1:
                    CLI.clearScreen();
                    login(scanner);
                    break;
                case 2:
                    CLI.clearScreen();
                    completeReg(scanner);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    CLI.clearScreen();
                    System.out.println("Invalid choice, please enter 0-2.");
            }
        }
    }

    public static void login(Scanner scanner) {
        Object[] returnedObject = Menu.loginPage(scanner);
        UserRoles role = (UserRoles) returnedObject[0];
        String email = (String) returnedObject[1];
        String password = (String) returnedObject[2];
        if (returnedObject[0] == null){
            // System.out.println("");
        } else if (role.equals(UserRoles.ADMIN)){
            Admin admin = new Admin(email, password);
            Menu.adminPage(admin, scanner);
        }else if (role.equals(UserRoles.PATIENT)){
            Patient patient = new Patient(email, password);
            Menu.patientPage(patient, scanner);
        }
    }

    public static void completeReg(Scanner scanner){
        Menu.registerationPage(scanner);
    }
}