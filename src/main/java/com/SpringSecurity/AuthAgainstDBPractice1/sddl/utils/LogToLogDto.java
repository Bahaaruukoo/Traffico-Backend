package com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.LogDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.DrivingLicense;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Log;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.DrivingLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class LogToLogDto {


    public static Log getLog(LogDto logDto){

        Log log = new Log();

        log.setLogCode(logDto.getLogCode());
        log.setDate(logDto.getLogDate());
        log.setTime(logDto.getLogTime());
        log.setLatitude(logDto.getLatitude());
        log.setLongitude(logDto.getLongitude());

        return log;
    }
    public static LogDto getLogDto(Log log){
        LogDto logDto = new LogDto();
        logDto.setLogCode(log.getLogCode());
        logDto.setOfficerId(String.valueOf(log.getOfficer().getPhone()));
        logDto.setLogDate(log.getDate());
        logDto.setLogTime(log.getTime());
        logDto.setLicenseNumber(log.getDrivingLicense().getLicenceNumber());

        return logDto;
    }
}
