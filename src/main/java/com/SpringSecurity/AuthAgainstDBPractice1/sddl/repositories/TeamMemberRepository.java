package com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.Team;
import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    List<TeamMember> findByTeam(Team tema);
}
