package main.java.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileHandler{
    private static final String storePath = "./user-store.txt";
    private static final String expectancyPath = "./life-expectancy.csv";

    private static String executeCommand(String[] command) {
        StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line)/*.append("\n")*/;
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }
    // to be used when admin is registering a patient where the UUID is generated and stored in the user-store.txt file
    public static void initialPatientRegister(String UUID, String email){
        String[] cmd = {
            "bash",
            "main/resources/initialPatientRegister.sh",
            UUID, email, storePath
        };

        executeCommand(cmd);
    }

    public static String getUUIDEmail(String UUID) {
        // boolean exists = validateUUID(UUID);
        String[] cmd = {
            "bash",
            "main/resources/getUUIDEmail.sh",
            UUID, storePath
        };

        String email = executeCommand(cmd);
        return email;
    }

    public static String getPassword(String email) {
        String[] cmd = {
            "bash",
            "main/resources/getPassword.sh",
            email, storePath
        };

        String password = executeCommand(cmd);
        return password;
    }

    public static double getISOLifeExpectancy(String ISO) {
        String[] cmd = {
            "bash",
            "main/resources/getISOLifeExpectancy.sh",
            ISO, expectancyPath
        };
        String expectancyString = executeCommand(cmd);
        return Double.parseDouble(expectancyString);
    }

    public static String getUserRole(String email) {
        String[] cmd = {
            "bash",
            "main/resources/getUserRole.sh",
            email, storePath
        };

        String role = executeCommand(cmd);
        return role;
    }

    // to be used during the patients registeration. this informations are stored in the user-store.txt file check if the email matches first
    public static void finalPatientRegister(String UUID, String firstName, String lastName, String DOB, Boolean HIVStatus, String diagnosisDate, Boolean isOnART, String ARTStartDate, String ISO, String password, int remainingYears) {
        String hashedPassword = hashPassword(password);
        String[] cmd = {
            "bash",
            "main/resources/completePatientReg.sh",
            UUID, firstName, lastName, DOB, String.valueOf(HIVStatus), diagnosisDate, String.valueOf(isOnART), ARTStartDate, ISO, hashedPassword, String.valueOf(remainingYears), storePath
        };

        executeCommand(cmd);
    }

    public static void UpdatePatientDetails(String UUID, String firstName, String lastName, String DOB, Boolean HIVStatus, String diagnosisDate, Boolean isOnART, String ARTStartDate, String ISO, String password, int remainingYears) {
        String hashedPassword = hashPassword(password);
        String[] cmd = {
            "bash",
            "main/resources/updatePatientInfo.sh",
            UUID, firstName, lastName, DOB, String.valueOf(HIVStatus), diagnosisDate, String.valueOf(isOnART), ARTStartDate, ISO, hashedPassword, String.valueOf(remainingYears), storePath
        };

        executeCommand(cmd);
    }

    //will return less than total number of strings if details not complete eg: for admin
    public static String[] getPatientDetails(String email) {
        if (validateEmail(email)) {
            String[] cmd = {
                "bash",
                "main/resources/getPatientDetails.sh",
                email, storePath
            };
            String output = executeCommand(cmd);
            return output.split(",");
        }
        return new String[0];
    }

    public static boolean validateUUID(String UUID) {
        String[] cmd = {
            "bash",
            "main/resources/checkUUID.sh",
            UUID, storePath
        };

        String output = executeCommand(cmd);
        return Boolean.parseBoolean(output);
    }

    public static boolean validateEmail(String email) {
        String[] cmd = {
            "bash",
            "main/resources/checkEmail.sh",
            email, storePath
        };

        String output = executeCommand(cmd);
        return Boolean.parseBoolean(output);
    }
    
    public static String hashPassword(String plainPassword) {
        String[] cmd = {
            "bash",
            "main/resources/passwordHasher.sh",
            plainPassword
        };

        String hashedPassword = executeCommand(cmd);
        return hashedPassword;
    }

    public static void initialAdmin() {
        String[] cmd = {
            "bash",
            "main/resources/initialAdmin.sh",
            storePath
        };
        executeCommand(cmd);
    }

    public static void main(String[] args) {
    //     // initialAdmin();
        String email = args[0];
    //     // String first = args[1];
    //     // String last = args[2];
    //     // String DOB = args[3];
    //     // String stat = args[4];
    //     // String diagDate = args[5];
    //     // String isOnArt = args[6];
    //     // String ArtStart = args[7];
    //     // String iso = args[8];
    //     // String password = args[9];
    //     // String email = args[10];
    String role = getUserRole(email);
    //     // finalPatientRegister(UUID, first, last, DOB, Boolean.parseBoolean(stat), diagDate, Boolean.parseBoolean(isOnArt), ArtStart, iso, password);
    //     String[] output = getPatientDetails(UUID);
    //     if (output.length != 0){
    //         for(String element : output) {
    //             System.out.println(element);
    //         }
    //     }
    System.out.println(role);
    }
}
