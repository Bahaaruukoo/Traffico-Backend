package com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true)
    private String email;
    @Column(nullable = false, length = 10, unique = true)
    private int phone;
    private String password;
    private String roles;

    private String firstName;
    private String middleName;
    private String lastName;
    private String rank;
}
