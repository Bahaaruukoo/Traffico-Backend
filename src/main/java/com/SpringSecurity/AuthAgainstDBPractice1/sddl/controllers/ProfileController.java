package com.SpringSecurity.AuthAgainstDBPractice1.sddl.controllers;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Profile;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @PostMapping("/profile/{id}")
    public ResponseEntity<Profile> addProfileWithId(@RequestBody Profile profile, @PathVariable Long id){
        return new ResponseEntity<>(profileService.addUserProfile(profile, id), HttpStatus.OK);
    }
    @GetMapping("/profile")
    public ResponseEntity<Profile> getProfileWithId(){
        return new ResponseEntity<>(profileService.getUserProfile(123), HttpStatus.OK);
    }
}
