package com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT COUNT(*) FROM Ticket t WHERE t.officer = ?1")
    Integer findTicketCountByOfficer(Users users);

    List<Ticket> findByOfficer(Users user);
    @Query( "SELECT COUNT(*) from Ticket t where t.officer in (:users)")
    Integer findByOfficerList(List<Users> users);
}
