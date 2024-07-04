package com.SpringSecurity.AuthAgainstDBPractice1.sddl.services;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.Exception.DrivingLicenseNotFoundException;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.DrivingLicense;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.DrivingLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrivingLicenseService {

    @Autowired
    DrivingLicenseRepository drivingLicensesRepository;

    public DrivingLicense getDrivingLicense(String licenseNumber){

        //return drivingLicensesRepository.findByLicenceNumber(licenseNumber).orElseThrow(() -> new DrivingLicenseNotFoundException("No driving license found"));
        Optional<DrivingLicense> dl = drivingLicensesRepository.findByLicenceNumber(licenseNumber);
        if(dl.isEmpty()){
            return null;
        }
        return dl.get();
    }
}
