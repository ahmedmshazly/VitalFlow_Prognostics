package main.java.utils;


public class FileHandler{
    // to be used when admin is registering a patient where the UUID is generated and stored in the user-store.txt file
    public static void storeUUID(String UUID){}

    // to be used during the patients registeration. this informations are stored in the user-store.txt file
    public static boolean registerUser(/*String UUID,*/ String firstName, String lastName, String email, String DOB, bool HIVStatus, String diagnosisDate, bool isOnART, String ARTStartDate, String ISO) {}

    public static Object[] getPatientDetails(String UUID) {
        return new Object[]{UUID, "firstname", "lastname", "email", "DOB", "etc"};
    }

    public static validateUUID(/*to be used to check if user already has a UUID and then go ahead with registering*/)

    public static String getPassword(String email) {
        return "password"; //get from bash
    }

    public static void exportAnalytics() {
        //logic to export the anayltics to a csv file should call a function on bash
    }
}
