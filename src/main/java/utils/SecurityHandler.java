package main.java.utils;

import main.java.user.UserRoles;

public class SecurityHandler {
    // if issues arise maybe add -n option to echo to omit nextline character
    public static UserRoles getRole(String email) {
        if (FileHandler.getUserRole(email).equals("Admin")){
            return UserRoles.ADMIN;
        }
        return UserRoles.PATIENT;
    }

    public static String hashPassword(String plainPassword){
        // to be implemented - implemented
        String hashedPassword = FileHandler.hashPassword(plainPassword);
        return hashedPassword;
    }

    // used during login to check if provided password is original password. hashed and checked with the stored hashed password
    public static boolean verifyPassword(String email, String plainPassword){
        String hashedPassword = FileHandler.hashPassword(plainPassword);
        String UUIDPassword = FileHandler.getPassword(email);

        return hashedPassword.equals(UUIDPassword);
    }
}