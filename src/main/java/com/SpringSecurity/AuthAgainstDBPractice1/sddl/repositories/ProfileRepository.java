package com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByUserId(Users users);
}
