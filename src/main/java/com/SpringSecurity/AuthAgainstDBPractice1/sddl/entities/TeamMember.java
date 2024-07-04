package com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="team")
    private Team team;

    @ManyToOne
    @JoinColumn(name="member")
    private Users member;
    private Date joindDate;
    @JsonBackReference
    public Team getTeam() {
        return team;
    }

    public Users getMember() {
        return member;
    }

    public Date getJoindDate() {
        return joindDate;
    }
}
