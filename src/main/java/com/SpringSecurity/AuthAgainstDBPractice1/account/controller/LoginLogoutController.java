package com.SpringSecurity.AuthAgainstDBPractice1.account.controller;

import com.SpringSecurity.AuthAgainstDBPractice1.account.dto.AuthRequestObject;
import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.RegisterService;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersToUsersDetails;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Profile;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginLogoutController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ProfileService profileService;

    @PostMapping("/register")
    public String register(@RequestBody Users users){
        return registerService.register(users);
    }
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<Profile> login( @RequestBody AuthRequestObject authRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {

            int phone = ((UsersToUsersDetails)authentication.getPrincipal()).getPhone();
            Profile profile = profileService.getUserProfile(phone);

            return new ResponseEntity<Profile>(profile, HttpStatusCode.valueOf(200));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
    @GetMapping("/home")
    public String home(){
        return "Welcome to open area!";
    }

    @GetMapping("/")
    public String see(){
        return "See you again area! from home";
    }

    @GetMapping("/work")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String inter(){
        return "Welcome to restricted working area!";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin(){
        return "Welcome to restricted Admin space area!";
    }
}
