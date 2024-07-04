package com.SpringSecurity.AuthAgainstDBPractice1.sddl.controllers;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Team;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.TeamDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.TeamService;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @Autowired
    LogService logService;

    @PostMapping("/teams")
    @PreAuthorize("hasRole('ROLE_OFFICER')")
    public void createTeam(@RequestBody TeamDto teamDto){
        teamService.createTeam(teamDto);
    }
    @GetMapping("/teams")
    @PreAuthorize("hasRole('ROLE_OFFICER')")
    public ResponseEntity<List<TeamDto>> getTeams(){
        List<TeamDto> teamDtos = new ArrayList<TeamDto>();
        for( Team team: teamService.getTeams()){
            TeamDto teamDto = new TeamDto();
            teamDto.setId(team.getId());
            teamDto.setOwner(team.getOwner());
            teamDto.setTeamName(team.getTeamName());
            teamDto.setDescription(team.getDescription());
            teamDto.setDate (team.getDate());
            teamDto.setOperationArea( team.getOperationArea());
            teamDto.setTeamMember(team.getTeamMember());

            teamDtos.add(teamDto);
        }
        return new ResponseEntity<>(teamDtos, HttpStatus.OK);
    }
/*
    @GetMapping("/teamperformance")
    @PreAuthorize("hasRole('ROLE_OFFICER')")
    public void officerList(){
        //System.out.println( teamService.getOfficersListInTeam());
        System.out.println(logService.teamLogs(teamService.getOfficersListInTeam()));
    }
    */
}
