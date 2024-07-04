package com.SpringSecurity.AuthAgainstDBPractice1.sddl.services;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.repository.AccountRepository;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersService;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersToUsersDetails;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Profile;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UsersService usersService;
    public Profile addUserProfile(Profile profile, Long id) {
        Users user = accountRepository.findById(id).get();
        profile.setUserId(user);
        return profileRepository.save(profile);
    }

    public Profile getUserProfile(int phone) {

        Users users = usersService.getUser(String.valueOf(phone));
        return profileRepository.findByUserId(users);

    }
}
