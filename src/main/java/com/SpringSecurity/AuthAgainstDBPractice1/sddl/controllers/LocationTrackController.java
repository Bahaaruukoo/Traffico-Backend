package com.SpringSecurity.AuthAgainstDBPractice1.sddl.controllers;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.LocationDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.LocationData;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.LocationTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationTrackController {

    @Autowired
    LocationTrackService trackService;
    @PostMapping("/track")
    public void locationtrack(@RequestBody LocationDto locationDto){

        System.out.println(locationDto.toString());
        trackService.saveLocation( locationDto );
    }
}
