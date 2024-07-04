package com.SpringSecurity.AuthAgainstDBPractice1.sddl.services;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersService;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersToUsersDetails;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Team;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.TeamMember;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.TeamDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.TeamRepository;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils.GetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    UsersService usersService;

    public void createTeam(TeamDto teamDto){
        Users users;
        Date date = new Date();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            //String currentUserName = auth.getName();
            UsersToUsersDetails usersDetails = (UsersToUsersDetails) auth.getPrincipal();
            users = usersService.getUser(String.valueOf(usersDetails.getPhone()));
            //System.out.println(users);
            //return teamRepository.findByOwner(users);
        } else {
            throw new RuntimeException("User not logged in");
        }
        Team team = new Team();
        team.setOwner(users);
        team.setDate(date);
        team.setTeamName(teamDto.getTeamName());
        team.setDescription(teamDto.getDescription());
        team.setOperationArea(teamDto.getOperationArea());

        teamRepository.save(team);
    }
    public List<Team>getTeams(){
        GetUser getUser = new GetUser();
        //get logg
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            //String currentUserName = auth.getName();
            UsersToUsersDetails usersDetails = (UsersToUsersDetails) auth.getPrincipal();
            Users users = usersService.getUser(String.valueOf(usersDetails.getPhone()));
            //System.out.println(users);
            return teamRepository.findByOwner(users);
        }
        System.out.println("No user logged in");
        return null;
    }
    public List<Users>getOfficersListInTeam(){
        //GetUser getUser = new GetUser();
        //get logg
        Users users;
        List<Team> teams;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            //String currentUserName = auth.getName();
            UsersToUsersDetails usersDetails = (UsersToUsersDetails) auth.getPrincipal();
            users = usersService.getUser(String.valueOf(usersDetails.getPhone()));
            //System.out.println(users);
            teams = teamRepository.findByOwner(users);
        }else {
            System.out.println("User not logged in");
            throw new RuntimeException("User not logged in");
        }
        List<Users> officers = new ArrayList<Users>();
        for(Team team: teams){
            for (TeamMember teamMember: team.getTeamMember()) {
                officers.add(teamMember.getMember());
            }

        }
        //System.out.println(officers.size());
        return officers;
    }

}
