package main.java.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileHandler{
    private static String storePath = "../../../../scripts/user-store.txt";

    private String executeCommand(String[] command) {
        StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }
    // to be used when admin is registering a patient where the UUID is generated and stored in the user-store.txt file
    public static void initialPatientRegister(String UUID, String email){

    }

    // to be used during the patients registeration. this informations are stored in the user-store.txt file
    public static boolean finalPatientRegister(/*String UUID,*/ String firstName, String lastName, /*String email*/ String DOB, bool HIVStatus, String diagnosisDate, bool isOnART, String ARTStartDate, String ISO) {}

    public static Object[] getPatientDetails(String UUID) {
        return new Object[]{UUID, "firstname", "lastname", "email", "DOB", "etc"};
    }

    public static validateUUID(/*to be used to check if user already has a UUID and then go ahead with registering*/)

    public static String getPassword(String email) {
        return "password"; //get from bash
    }

    public static String passwordHash(String plainText)
}
