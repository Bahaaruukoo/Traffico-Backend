package com.SpringSecurity.AuthAgainstDBPractice1.sddl.controllers;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.LogDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Log;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.LogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @Autowired
    public Log log;
    @Autowired
    public LogService logService;
    @PostMapping("/logs")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<LogDto>log( @RequestBody LogDto logDto)  {
        //System.out.println(logDto.toString());
        try {
            return new ResponseEntity<LogDto> (logService.saveLog(logDto), HttpStatus.OK);
        }catch (Exception e){
            //
        }
        return new ResponseEntity<LogDto> (new LogDto(), HttpStatus.BAD_REQUEST);
    }
}
