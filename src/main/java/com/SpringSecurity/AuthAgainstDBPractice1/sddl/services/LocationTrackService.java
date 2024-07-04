package com.SpringSecurity.AuthAgainstDBPractice1.sddl.services;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersService;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.LocationDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.LocationData;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LocationTrackService {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UsersService usersService;
    public void saveLocation(LocationDto locationDto){
        LocationData locationData = new   LocationData ();
        locationData.setLatitude(locationDto.getLatitude());
        locationData.setLongitude(locationDto.getLatitude());
        locationData.setDate(locationDto.getDate());
        locationData.setOfficer(usersService.getUser(String.valueOf(locationDto.getOfficerId())));
        System.out.println(locationData.toString());
        locationRepository.save(locationData);
    }
}
