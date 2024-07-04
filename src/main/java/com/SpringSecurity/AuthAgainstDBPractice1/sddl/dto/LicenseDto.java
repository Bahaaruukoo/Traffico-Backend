package com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.enums.DrivingLicenseTypes;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.enums.StatesEnum;

public class LicenseDto {
    private String licenceNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private DrivingLicenseTypes type;
    private String phone;
    private String email;
    private String picture;
    private String country;

    private StatesEnum state;
    private String zone;
    private String woreda;
    private String streetAddress;
    private String zipCode;
    private String issuer;

}
