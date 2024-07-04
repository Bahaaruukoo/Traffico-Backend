package com.SpringSecurity.AuthAgainstDBPractice1.sddl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.PerformanceService;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Log;

import java.util.List;
import java.util.Map;

@RestController
public class PerformanceController {
    @Autowired
    PerformanceService performanceService;
    @GetMapping("/performance/{id}")
    @PreAuthorize("hasRole('ROLE_OFFICER')")
    public ResponseEntity<Map<String, Integer>> getPerformacne(@PathVariable Long id){
        return new ResponseEntity<Map<String, Integer>>(performanceService.getPerformance(id), HttpStatus.OK);
    }

    @GetMapping("/teamperformance")
    @PreAuthorize("hasRole('ROLE_OFFICER')")
    public ResponseEntity<Map<String, Integer>> teamperformance(){
        return new ResponseEntity<Map<String, Integer>>(performanceService.getTeamPerformance(), HttpStatus.OK);
    }
}
