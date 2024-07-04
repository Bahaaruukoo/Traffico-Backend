package com.SpringSecurity.AuthAgainstDBPractice1.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestObject {

    private String username ;
    private String password;
}
