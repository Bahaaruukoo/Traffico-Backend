package com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import lombok.Data;

import java.util.Date;

@Data
public class LocationDto {

    private double longitude;
    private double latitude;
    private Date date;
    private int officerId; //phone
}
