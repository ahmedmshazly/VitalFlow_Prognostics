package main.java.user;

import java.util.Date;

public class Patient implements User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Date dateOfBirth;
    private boolean isHIVPositive;
    private Date diagnosisDate;
    private boolean isOnART;
    private Date ARTStartDate;
    private String countryISOCode;

    public Patient(String firstName, String lastName, String email, String password,
                   Date dateOfBirth, boolean isHIVPositive, Date diagnosisDate,
                   boolean isOnART, Date ARTStartDate, String countryISOCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.isHIVPositive = isHIVPositive;
        this.diagnosisDate = diagnosisDate;
        this.isOnART = isOnART;
        this.ARTStartDate = ARTStartDate;
        this.countryISOCode = countryISOCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void updateProfile(String firstName, String lastName, String email, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }

}
