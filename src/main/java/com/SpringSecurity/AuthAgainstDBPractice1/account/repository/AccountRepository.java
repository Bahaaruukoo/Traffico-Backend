package com.SpringSecurity.AuthAgainstDBPractice1.account.repository;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByPhone(int phone);


}
