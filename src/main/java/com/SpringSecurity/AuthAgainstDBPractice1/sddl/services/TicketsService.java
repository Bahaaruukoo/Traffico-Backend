package com.SpringSecurity.AuthAgainstDBPractice1.sddl.services;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.Exception.OfficerNotFoundException;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.TicketDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.DrivingLicense;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Ticket;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories.TicketRepository;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils.FetchUserService;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils.TicketDtoToTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersService;
import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;

@Service
public class TicketsService {

    @Autowired
    DrivingLicenseService drivingLicenseService;
    @Autowired
    FetchUserService fetchUserService;
    @Autowired
    TicketRepository ticketRepo;
    @Autowired
    UsersService usersService;
    public Integer getTicketCount(Long id){
        Users users = usersService.getUserById(id);
        return ticketRepo.findTicketCountByOfficer(users);
    }
    public TicketDto saveTicket(TicketDto ticketDto){
        Ticket tk = TicketDtoToTicket.getTicket(ticketDto);
        Users officer = fetchUserService.getUser(ticketDto.getOfficerId());
        if (officer == null){
            throw new OfficerNotFoundException("Officer not found");
        }
        tk.setOfficer(officer);
        DrivingLicense drivingLicense = drivingLicenseService.getDrivingLicense( ticketDto.getLicenseNumber());
        tk.setDrivingLicense(drivingLicense);

        Ticket response = ticketRepo.save(tk);
        TicketDto dto = TicketDtoToTicket.getTickeDto(response);
        dto.setOfficerId(String.valueOf(officer.getPhone()));
        dto.setLicenseNumber(drivingLicense.getLicenceNumber());
        return dto;
    }


    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }
}
