package com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Getter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="officer", nullable = false)
    private Users officer;

    @ManyToOne
    @JoinColumn(name="drivingLicense", nullable = false)
    private DrivingLicense drivingLicense;
    private String date;
    private String time;
    private String logCode;
    private double longitude;
    private double latitude;

}