package com.SpringSecurity.AuthAgainstDBPractice1.sddl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Log;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.TicketsService;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Ticket;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.LogRepository;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.TicketRepository;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersService;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.TeamService;

import java.util.*;

@Service
public class PerformanceService {
    //fetch all tickets by this individual;
    //fetch or get count of logs
    //
    @Autowired
    UsersService usersService;
    @Autowired
    TeamService teamService;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    LogRepository logRepository;
    @Autowired
    LogService logService;

    public Map<String, Integer> getPerformance(Long id){
        //Map<Long, Long> LicenseToOfficerMap = new HashMap<>();
        Set<Long> chargedLicenses = new HashSet<>();
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Overdue", 0);
        counts.put("Overpoint", 0);
        counts.put("Routine", 0);
        counts.put("Ticket", 0);
        counts.put("Neglected", 0);

        Users user = usersService.getUserById(id);
       // List<Log> logs = logService.getLogByOfficer(user);
        List<Log> logs = logRepository.findByOfficer(user);
        //Integer tickets = ticketRepository.findTicketCountByOfficer(user);
        List<Ticket>  tickets= ticketRepository.findByOfficer(user);
        //System.out.println(tickets);
        for(Ticket ticket: tickets){
            //LicenseToOfficerMap.put(ticket.getDrivingLicense().getId(), ticket.getOfficer().getId());
            chargedLicenses.add(ticket.getDrivingLicense().getId());
        }
        //System.out.println(LicenseToOfficerMap);
        for (Log log: logs) {
            if(log.getLogCode().equals("Overdue ticket on card")){
                Long driverId = log.getDrivingLicense().getId();
                if(!chargedLicenses.contains(driverId)){
                    counts.put("Neglected", counts.get("Neglected") + 1);
                }
                counts.put("Overdue", counts.get("Overdue")+1);
            }else if(log.getLogCode().equals("Penalty point passed maximum limit")){
                counts.put("Overpoint", counts.get("Overpoint")+1);
            }else if(log.getLogCode().equals("routine check up")){
                counts.put("Routine", counts.get("Routine")+1);
            }
        }
        counts.put("Ticket", tickets.size() );
        //System.out.println(counts);
        return counts;
    }

    public Map<String, Integer> getTeamPerformance(){
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Overdue", 0);
        counts.put("Overpoint", 0);
        counts.put("Routine", 0);
        counts.put("Neglected", 0);
        counts.put("Ticket", 0);
        //Users user = usersService.getUserById(id);
        List<Users> officers = teamService.getOfficersListInTeam();
        List<Log> logs = logRepository.findByOfficerList(officers);
        Integer tickets = ticketRepository.findByOfficerList(officers);
        for (Log log: logs) {
            if(log.getLogCode().equals("Overdue thicket on charge ticket")){
                counts.put("Overdue", counts.get("Overdue")+1);
            }else if(log.getLogCode().equals("Penalty point passed maximum limit")){
                counts.put("Overpoint", counts.get("Overpoint")+1);
            }else if(log.getLogCode().equals("routine check up")){
                counts.put("Routine", counts.get("Routine")+1);
            }
        }

        counts.put("Ticket", tickets );

        //System.out.println(counts);
        return counts;
    }


}
