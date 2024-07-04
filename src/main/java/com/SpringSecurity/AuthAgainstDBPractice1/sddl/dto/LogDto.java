package com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogDto {
    private String officerId;
    private String licenseNumber;
    private String logDate;
    private String logTime;
    private String logCode;
    private double longitude;
    private double latitude;
}
