package main.java.entities;

public class Patient extends User {
    private String dateOfBirth;
    private boolean isHivPos;
    private String diagnosisDate;
    private boolean isOnArt;
    private String artStartDate;
    private String countryIsoCode;

    // Primary constructor with all parameters
    public Patient(int userId, String firstName, String lastName, String email, String password,
                   String dateOfBirth, boolean isHivPos, String diagnosisDate, boolean isOnArt,
                   String artStartDate, String countryIsoCode) {
        super(userId, firstName, lastName, email, password, "Patient");
        this.dateOfBirth = dateOfBirth;
        this.isHivPos = isHivPos;
        this.diagnosisDate = diagnosisDate;
        this.isOnArt = isOnArt;
        this.artStartDate = artStartDate;
        this.countryIsoCode = countryIsoCode;
    }

    // Overloaded constructor with default values for health-related parameters
    public Patient(int userId, String firstName, String lastName, String email, String password) {
        this(userId, firstName, lastName, email, password, "N/A", false, "N/A", false, "N/A", "N/A");
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
    // Setters
    public void setDOB(String dob) {
        this.dateOfBirth = dob;
    }

    public void setHivStatus(boolean hivStatus) {
        this.isHivPos = hivStatus;
    }


    public void setOnART(boolean onART) {
        this.isOnArt = onART;
    }

    public void setARTStartDate(String artStartDate) {
        this.artStartDate = artStartDate;
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