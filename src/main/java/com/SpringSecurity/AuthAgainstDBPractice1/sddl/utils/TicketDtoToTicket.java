package com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.dto.TicketDto;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Ticket;

public class TicketDtoToTicket {
    public static Ticket getTicket(TicketDto ticketDto){
        Ticket tk = new Ticket();
        tk.setReferenceNumber(ticketDto.getReferenceNumber());
        tk.setChargeCode( ticketDto.getChargeCode());
        tk.setDate(ticketDto.getChargeDate());
        tk.setTime(ticketDto.getChargeTime());
        tk.setStatus(0);

        return tk;
    }
    public static TicketDto getTickeDto(Ticket ticket){
        TicketDto tdo = new TicketDto();
        tdo.setReferenceNumber(ticket.getReferenceNumber());
        tdo.setChargeCode(ticket.getChargeCode());
        tdo.setChargeDate(ticket.getDate());
        tdo.setChargeTime(ticket.getTime());

        return tdo;
    }
}
