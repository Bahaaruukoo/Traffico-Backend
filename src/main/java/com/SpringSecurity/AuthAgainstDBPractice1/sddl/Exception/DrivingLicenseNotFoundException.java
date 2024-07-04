package com.SpringSecurity.AuthAgainstDBPractice1.sddl.Exception;

public class DrivingLicenseNotFoundException extends RuntimeException{
    public DrivingLicenseNotFoundException(String message){
        super(message);
    }
}
