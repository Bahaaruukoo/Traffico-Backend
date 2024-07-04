package com.SpringSecurity.AuthAgainstDBPractice1.account.service;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Optional< Users> users = accountRepository.findByEmail(username);
        Optional< Users> users = accountRepository.findByPhone(Integer.parseInt(username));
        return users.map(UsersToUsersDetails::new).orElseThrow(()-> new RuntimeException("Authentication was not successful"));
    }
}
