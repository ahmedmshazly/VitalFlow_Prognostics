package main.java.utils;

import main.java.user.UserRoles;

public class SecurityManager {
    public static boolean hasAccess(UserRoles roles) {
        return roles == UserRoles.ADMIN;
    }

    public static String hashPassword(String plainPassword){
        // to be implemented - implemented
        String hashedPassword = FileHandler.hashPassword(plainPassword);
        return hashedPassword;
    }

    // used during login to check if provided password is original password. hashed and checked with the stored hashed password
    public static boolean verifyPassword(String UUID, String plainPassword){
        String hashedPassword = FileHandler.hashPassword(plainPassword);
        String UUIDPassword = FileHandler.getPassword(UUID);

        return hashedPassword.equals(UUIDPassword);
    }
}