package com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;
import java.util.List;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.TeamMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeamDto {
    private Long id;
    private Users owner;
    private String teamName;
    private String description;
    private Date date;
    private String operationArea;
    private List<TeamMember> teamMember;
}
