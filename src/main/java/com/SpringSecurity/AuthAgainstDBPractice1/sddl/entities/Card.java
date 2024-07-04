package com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long uid;

    private Date ragistrationDate;
    private Date issuidDate;
    private DrivingLicense drivingLicense;
    private String status;
}
