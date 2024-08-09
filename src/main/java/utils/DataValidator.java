package main.java.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class DataValidator {
    private static final Set<String> VALID_ISO_CODES = new HashSet<>();
    
    static {
        // Add ISO 3166-1 alpha-2 country codes
        String[] codes = {
            "AD", "AE", "AF", "AG", "AI", "AL", "AM", "AO", "AR", "AS", "AT", "AU", "AW", "AX", "AZ",
            "BA", "BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", "BQ", "BR",
            "BS", "BT", "BV", "BW", "BY", "BZ", "CA", "CC", "CD", "CF", "CG", "CH", "CI", "CK", "CL",
            "CM", "CN", "CO", "CR", "CU", "CV", "CW", "CX", "CY", "CZ", "DE", "DJ", "DK", "DM", "DO",
            "DZ", "EC", "EE", "EG", "EH", "ER", "ES", "ET", "FI", "FJ", "FM", "FO", "FR", "GA", "GB",
            "GD", "GE", "GF", "GG", "GH", "GI", "GL", "GM", "GN", "GP", "GQ", "GR", "GT", "GU", "GW",
            "GY", "HK", "HM", "HN", "HR", "HT", "HU", "ID", "IE", "IL", "IM", "IN", "IO", "IQ", "IR",
            "IS", "IT", "JE", "JM", "JO", "JP", "KE", "KG", "KH", "KI", "KM", "KN", "KP", "KR", "KW",
            "KY", "KZ", "LA", "LB", "LC", "LI", "LK", "LR", "LS", "LT", "LU", "LV", "LY", "MA", "MC",
            "MD", "ME", "MF", "MG", "MH", "MK", "ML", "MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MT",
            "MU", "MV", "MW", "MX", "MY", "MZ", "NA", "NC", "NE", "NF", "NG", "NI", "NL", "NO", "NP",
            "NR", "NU", "NZ", "OM", "PA", "PE", "PF", "PG", "PH", "PK", "PL", "PM", "PN", "PR", "PT",
            "PW", "PY", "QA", "RE", "RO", "RS", "RU", "RW", "SA", "SB", "SC", "SD", "SE", "SG", "SH",
            "SI", "SJ", "SK", "SL", "SM", "SN", "SO", "SR", "SS", "ST", "SV", "SX", "SY", "SZ", "TC",
            "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TR", "TT", "TV", "TZ", "UA",
            "UG", "UM", "US", "UY", "UZ", "VA", "VC", "VE", "VG", "VI", "VN", "VU", "WF", "WS", "YE",
            "YT", "ZA", "ZM", "ZW"
        };
        for (String code : codes) {
            VALID_ISO_CODES.add(code);
        }
    }

    public static boolean validateFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            return false;
        }
        return firstName.matches("[A-Za-z]{2,}");
    }

    public static boolean validateLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            return false;
        }
        return lastName.matches("[A-Za-z]{2,}");
    }

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

        if (!password.matches(SPECIAL_CHAR_REGEX)) {
            return false;
        }

        return true; 
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
            if (dateOfBirth.isBefore(minDateOfBirth)) {
                return false;
            }

            return true;

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
                if (diagnosisDateParsed.isBefore(minDiagnosisDate)) {
                    return false;
                }

                return true;

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
                if (startDateParsed.isBefore(minstartDate)) {
                    return false;
                }

                return true;

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

        if (VALID_ISO_CODES.contains(ISO)){
            return true;
        }else{
            return false;
        }
    }

}
