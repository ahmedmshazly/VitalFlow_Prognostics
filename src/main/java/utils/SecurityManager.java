package main.java.utils;

import main.java.user.UserRoles;

public class SecurityManager {
    public static boolean hasAccess(UserRoles roles) {
        if (role == UserRoles.ADMIN){
            return true;
        }else {
            return false;
        }
    }

    public static String hashPassword(String plainPassword){
        // to be implemented
        String hashedPassword = plainPassword;
        return hashedPassword;
    }

    // used during login to check if provided password is original password. hashed and checked with the stored hashed password
    public static boolean verifyPassword(String plainPassword){}

    public static void logEvent(String event){
        // to be implemented
        System.out.println(event);
    }
}