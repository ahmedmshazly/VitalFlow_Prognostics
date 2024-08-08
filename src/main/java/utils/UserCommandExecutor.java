package main.java.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserCommandExecutor {

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

    public void writeInitialData(String email, String uuid) {
        String[] cmd = {
                "C:\\Windows\\System32\\bash.exe",
                "/mnt/s/CR_2024CMU_ECE/GRP_CR_202407_SIP/CR_202407_CP/CR_202407_CP_ASS/Assn1_UC_AD_CD_UM/VitalFlow_Prognostics/scripts/storeInitialUserData.bash",
                email, uuid
        };

        executeCommand(cmd);
    }

    public void addFullDetails(String uuid, String email, String firstName, String lastName, String dob, String hivStatus, String diagnosisDate, String onART, String artStartDate, String country, String hashedPassword) {
        String[] cmd = {
                "C:\\Windows\\System32\\bash.exe",
                "/mnt/s/CR_2024CMU_ECE/GRP_CR_202407_SIP/CR_202407_CP/CR_202407_CP_ASS/Assn1_UC_AD_CD_UM/VitalFlow_Prognostics/scripts/registerFullUser.bash",
                uuid, email, firstName, lastName, dob, hivStatus, diagnosisDate, onART, artStartDate, country, hashedPassword
        };
        executeCommand(cmd);
    }

    public String hashPassword(String password) {
        return password;
    }

    public boolean validateLogin(String uuid, String password) {
        String storedHashedPassword = getPasswordForUUID(uuid);
        String hashedInputPassword = hashPassword(password);
        return storedHashedPassword.equals(hashedInputPassword);
    }

    private String getPasswordForUUID(String uuid) {
        return "stored password";
    }
}
