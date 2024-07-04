package com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchUserService {
    @Autowired
    AccountRepository accountRepository;

    public Users getUser(String phone){
        Optional<Users> users = accountRepository.findByPhone(Integer.parseInt(phone));

        if (users.isEmpty()){
            return null;
        }
        return users.get();
    }
}
