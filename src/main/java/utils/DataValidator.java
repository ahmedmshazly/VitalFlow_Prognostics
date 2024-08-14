package main.java.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DataValidator {
    
    private static final String[] ISOs = {
        "AF", "AL", "DZ", "AS", "AD", "AO", "AI", "AG", "AR", "AM",
        "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY", "BE",
        "BZ", "BJ", "BM", "BT", "BO", "BQ", "BA", "BW", "BR", "VG",
        "BN", "BG", "BF", "BI", "KH", "CM", "CA", "CV", "KY", "CF",
        "TD", "CL", "CN", "CO", "KM", "CG", "CK", "CR", "CI", "HR",
        "CU", "CW", "CY", "CZ", "CD", "DK", "DJ", "DM", "DO", "TL",
        "EC", "EG", "SV", "GQ", "ER", "EE", "SZ", "ET", "FK", "FO",
        "FJ", "FI", "FR", "GF", "PF", "GA", "GM", "GE", "DE", "GH",
        "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GG", "GN", "GW",
        "GY", "HT", "HN", "HK", "HU", "IS", "IN", "ID", "IR", "IQ",
        "IE", "IM", "IL", "IT", "JM", "JP", "JE", "JO", "KZ", "KE",
        "KI", "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI",
        "LT", "LU", "MO", "MG", "MW", "MY", "MV", "ML", "MT", "MH",
        "MQ", "MR", "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME",
        "MS", "MA", "MZ", "MM", "NA", "NR", "NP", "NL", "NC", "NZ",
        "NI", "NE", "NG", "NU", "KP", "MK", "MP", "NO", "OM", "PK",
        "PW", "PS", "PA", "PG", "PY", "PE", "PH", "PL", "PT", "PR",
        "QA", "RE", "RO", "RU", "RW", "BL", "SH", "KN", "LC", "MF",
        "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL",
        "SG", "SX", "SK", "SI", "SB", "SO", "ZA", "KR", "SS", "ES",
        "LK", "SD", "SR", "SE", "CH", "SY", "TW", "TJ", "TZ", "TH",
        "TG", "TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV", "UG",
        "UA", "AE", "GB", "US", "VI", "UY", "UZ", "VU", "VE", "VN",
        "WF", "EH", "YE", "ZM", "ZW"
    };

    public static boolean validateName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return name.matches("[A-Za-z]{2,}");
    }

    // public static boolean validateLastName(String lastName) {
    //     if (lastName == null || lastName.isEmpty()) {
    //         return false;
    //     }
    //     return lastName.matches("[A-Za-z]{2,}");
    // }

    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static boolean validatePasswordStrength(String password) {
        final int MIN_LENGTH = 8;
        final String LOWERCASE_REGEX = "(.*a-z.*)";
        final String UPPERCASE_REGEX = "(.*A-Z.*)";
        final String DIGIT_REGEX = "(.*0-9.*)";
        final String SPECIAL_CHAR_REGEX = "(.*[@#$%^&+=!].*)";

        if (password == null) {
        return false;
        }
        if (password.length() < MIN_LENGTH) {
            return false;
        }

        if (!password.matches(LOWERCASE_REGEX)) {
            return false;
        }

        if (!password.matches(UPPERCASE_REGEX)) {
            return false;
        }

        if (!password.matches(DIGIT_REGEX)) {
            return false;
        }

        return password.matches(SPECIAL_CHAR_REGEX); 
    }

    public static boolean validateDOB(String dob) {
        if (dob == null || dob.isEmpty()) {
            return false;
        }

        try {
            // Parse the date in the format yyyy-MM-dd
            LocalDate dateOfBirth = LocalDate.parse(dob);

            // Check if the date is in the future
            if (dateOfBirth.isAfter(LocalDate.now())) {
                return false;
            }

            LocalDate minDateOfBirth = LocalDate.of(1900, 1, 1); // Minimum valid date
            return !dateOfBirth.isBefore(minDateOfBirth);

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validateHIVStatusAndDiagnosisDate(boolean isHIVPOS, String diagnosisDate){
        if (isHIVPOS){
            if (diagnosisDate == null || diagnosisDate.isEmpty()){
                return false;
            }
            try {
                // Parse the date in the format yyyy-MM-dd
                LocalDate diagnosisDateParsed = LocalDate.parse(diagnosisDate);

                // Check if the date is in the future
                if (diagnosisDateParsed.isAfter(LocalDate.now())) {
                    return false;
                }

                LocalDate minDiagnosisDate = LocalDate.of(1900, 1, 1); // Minimum valid date
                return !diagnosisDateParsed.isBefore(minDiagnosisDate);

            } catch (DateTimeParseException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateIsOnARTandStartDate(boolean isOnART, String startDate){
        if (isOnART){
            if (startDate == null || startDate.isEmpty()){
                return false;
            }
            try {
                // Parse the date in the format yyyy-MM-dd
                LocalDate startDateParsed = LocalDate.parse(startDate);

                // Check if the date is in the future
                if (startDateParsed.isAfter(LocalDate.now())) {
                    return false;
                }

                LocalDate minstartDate = LocalDate.of(1900, 1, 1); // Minimum valid date
                return !startDateParsed.isBefore(minstartDate);

            } catch (DateTimeParseException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateISO(String ISO) {
        if (ISO == null || ISO.isEmpty()){
            return false;
        }
        // System.out.println(ISO);
        // System.out.println(Arrays.asList(ISOs).contains(ISO));
        // System.out.println(ISO);

        return Arrays.asList(ISOs).contains(ISO);
    }

    /*to be used to check if user already has a UUID and then go ahead with registering*/
    public static boolean validateUUID(String UUID){
        return FileHandler.validateUUID(UUID);
    }

    public static boolean validateUUIDEmail(String UUID, String email) {
        if (validateUUID(UUID)){
            String _email = FileHandler.getUUIDEmail(UUID);
            return _email.equals(email);
        }
        return  false;
    }

}
