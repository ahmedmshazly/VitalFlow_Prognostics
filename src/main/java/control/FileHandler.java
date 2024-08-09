package main.java.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

public class FileHandler {
    private static String storePath = "scripts/user-store.txt"; // Adjust as necessary for your setup

    // Method to execute a Bash script
    private static String executeCommand(String[] command) {
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

    // Retrieve email from UUID
    public static String getEmailFromUUID(String uuid) {
        String[] command = {"C:\\Windows\\System32\\bash.exe", "scripts/get_email_from_uuid.sh", uuid};
        String output = executeCommand(command);
        return output.trim(); // Assuming the script prints only the email
    }

    // Hashes a password
    public static String passwordHash(String plainText) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(plainText.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Method to initiate a patient account
    public static String initiatePatientAccount(String email) {
        String uuid = UUID.randomUUID().toString();
        String[] command = {
                "C:\\Windows\\System32\\bash.exe",
                "src/scripts/storeInitialUserData.bash",
                email,
                uuid
        };
        String result = executeCommand(command);
        System.out.println(result);
        return uuid;
    }
}
