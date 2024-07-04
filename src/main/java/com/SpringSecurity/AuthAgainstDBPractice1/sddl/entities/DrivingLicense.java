package com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String licenceNumber;
    private String firstName;
    private String middleName;
    private String lastName;

    //@Enumerated(EnumType.STRING) DrivingLicenseTypes
    private String type;
    private String phone;
    private String email;
    private String picture;
    private String country = "Ethiopia";

    //@Enumerated(EnumType.STRING) StatesEnum
    private String state;
    private String zone;
    private String woreda;
    private String streetAddress;
    private String zipCode;
    private String issuer;

    //@OneToMany(mappedBy = "drivingLicense")
    //private List<Log> log;
   // @OneToMany(mappedBy = "drivingLicense")
    //private List<Ticket> ticket;
}
