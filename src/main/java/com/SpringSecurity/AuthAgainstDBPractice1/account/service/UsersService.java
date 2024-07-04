package com.SpringSecurity.AuthAgainstDBPractice1.account.service;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.repository.AccountRepository;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.Exception.OfficerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    AccountRepository accountRepository;
    public Users getUser(String phone){
        Users user =  accountRepository.findByPhone(Integer.parseInt(phone)).get();
        //System.out.println(user);
        return user;
    }
    public Users getUserById(Long id){
        Users user =  accountRepository.findById(id).get();
        //System.out.println(user);
        return user;
    }
}
