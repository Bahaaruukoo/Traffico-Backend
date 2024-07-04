package com.SpringSecurity.AuthAgainstDBPractice1.sddl.controllers;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.TicketDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.TicketConfirmDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Ticket;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.services.TicketsService;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersService;
import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TicketController {
    @Autowired
    TicketsService ticketsService;

    @PostMapping("/ticket")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<TicketDto> acceptTicket(@RequestBody TicketDto ticket){
        //System.out.println(ticket.toString());
        return new ResponseEntity<>(ticketsService.saveTicket(ticket), HttpStatus.OK);
    }
    @GetMapping("/allticket")
    @CrossOrigin
    public ResponseEntity<List<Ticket>> getAllTeickets(){
        return new ResponseEntity<>(ticketsService.getAllTickets(), HttpStatus.OK);
    }

    /*
    @GetMapping("/ticketCount/{id}")
    @PreAuthorize("hasRole('ROLE_OFFICER')")
    public ResponseEntity<Map<String, Long>> getTicketCount(@PathVariable Long id){
        Map<String, Long> count = new HashMap<>();
        Long cnt = ticketsService.getTicketCount(id);
        count.put("ticket", cnt);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    */
}
