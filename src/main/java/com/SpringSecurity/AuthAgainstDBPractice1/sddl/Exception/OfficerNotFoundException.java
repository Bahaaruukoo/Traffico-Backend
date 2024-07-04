package com.SpringSecurity.AuthAgainstDBPractice1.sddl.Exception;

public class OfficerNotFoundException extends RuntimeException{
    public OfficerNotFoundException(String message){
        super(message);
    }

}
