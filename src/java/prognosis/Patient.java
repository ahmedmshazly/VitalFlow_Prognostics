package java.prognosis;

public class Patient extends User {
    // Additional attributes specific to Patient
    private String dateOfBirth;
    private boolean isHivPos;
    private String diagnosisDate;
    private boolean isOnArt;
    private String artStartDate;
    private String countryIsoCode;

    // Constructor
    public Patient(int userId, String firstName, String lastName, String email, String password,
                   String dateOfBirth, boolean isHivPos, String diagnosisDate, boolean isOnArt,
                   String artStartDate, String countryIsoCode) {
        super(userId, firstName, lastName, email, password);
        this.dateOfBirth = dateOfBirth;
        this.isHivPos = isHivPos;
        this.diagnosisDate = diagnosisDate;
        this.isOnArt = isOnArt;
        this.artStartDate = artStartDate;
        this.countryIsoCode = countryIsoCode;
    }

    // Getters and Setters for the additional attributes
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHivPos() {
        return isHivPos;
    }

    public void setHivPos(boolean hivPos) {
        isHivPos = hivPos;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public boolean isOnArt() {
        return isOnArt;
    }

    public void setOnArt(boolean onArt) {
        isOnArt = onArt;
    }

    public String getArtStartDate() {
        return artStartDate;
    }

    public void setArtStartDate(String artStartDate) {
        this.artStartDate = artStartDate;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    @Override
    public void viewPersonalInfo() {
        System.out.println("Patient Info: " + getFirstName() + " " + getLastName() +
                ", DOB: " + dateOfBirth + ", HIV Positive: " + isHivPos +
                ", Diagnosis Date: " + diagnosisDate + ", On ART: " + isOnArt +
                ", ART Start Date: " + artStartDate + ", Country: " + countryIsoCode);
    }

    @Override
    public void accessSpecificData() {
        System.out.println("Accessing specific data for patient " + getFirstName());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "userId=" + getUserId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", isHivPos=" + isHivPos +
                ", diagnosisDate='" + diagnosisDate + '\'' +
                ", isOnArt=" + isOnArt +
                ", artStartDate='" + artStartDate + '\'' +
                ", countryIsoCode='" + countryIsoCode + '\'' +
                '}';
    }
}
