package com.SpringSecurity.AuthAgainstDBPractice1.sddl.services;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.LogDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.DrivingLicense;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Log;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.LogRepository;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils.FetchUserService;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils.LogToLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;
    @Autowired
    FetchUserService fetchUserService;
    @Autowired
    DrivingLicenseService drivingLicenseService;
    @Autowired
    Log log;

    public LogDto saveLog(LogDto logDto) throws Exception{
        String officerId = logDto.getOfficerId();
        String licNumber = logDto.getLicenseNumber();
        if( officerId.length() == 0 || licNumber.length() == 0){
            throw new RuntimeException("Invalid officer id and/or license number");
        }
        Users officer = fetchUserService.getUser(officerId);
        DrivingLicense drivingLicense = drivingLicenseService.getDrivingLicense(licNumber);
        Log log = LogToLogDto.getLog(logDto);
        log.setDrivingLicense(drivingLicense);
        log.setOfficer(officer);
        Log response = logRepository.save(log);
        //System.out.println(response.toString());

        return LogToLogDto.getLogDto(response);

    }
    public List<Log> teamLogs(List<Users> users){
        return logRepository.findByOfficerList(users);
    }
}
