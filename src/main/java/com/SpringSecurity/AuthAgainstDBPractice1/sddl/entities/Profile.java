package com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;
    private double height;
    private double weight;
    private String badgeNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Users userId;
    private String rank;
    private String picture;

    private String country = "Ethiopia";
    //@Enumerated(EnumType.STRING) StatesEnum
    private String state;
    private String zone;
    private String woreda;
    private String streetAddress;
    private String zipCode;
}
