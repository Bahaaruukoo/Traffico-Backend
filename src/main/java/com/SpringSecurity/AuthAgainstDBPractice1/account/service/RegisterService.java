package com.SpringSecurity.AuthAgainstDBPractice1.account.service;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountRepository accountRepository;
    public String register(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Users users =accountRepository.save(user);
        return "/" + users.getId();//"Account created with " + user.getPhone(); //user.getEmail();
    }
}
