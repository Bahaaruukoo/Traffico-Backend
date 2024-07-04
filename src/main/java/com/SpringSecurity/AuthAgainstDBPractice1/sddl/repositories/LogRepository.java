package com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByOfficer(Users users);
    @Query( "Select l from Log l where l.officer in (:users)")
    List<Log> findByOfficerList(List<Users> users);
}
