package com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByOwner(Users user);
}
