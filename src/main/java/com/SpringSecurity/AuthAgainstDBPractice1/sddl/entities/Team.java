package com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="owner")
    private Users owner;
    private String teamName;
    private String description;
    private Date date;
    private String operationArea;

    //@JsonIgnore
    @OneToMany(mappedBy = "team")
    private List<TeamMember> teamMember;
    public Users getOwner() {
        return owner;
    }
    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getOperationArea() {
        return operationArea;
    }

    @JsonManagedReference
    public List<TeamMember> getTeamMember() {
        return teamMember;
    }
}
