package com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String referenceNumber;
    @ManyToOne
    @JoinColumn(name="license")
    private DrivingLicense drivingLicense;
    private String chargeCode;
    private String date;
    private String time;

    @ManyToOne
    @JoinColumn(name="officer")
    private Users officer;
    private int status;
}
