package com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Long> {
    Optional<DrivingLicense> findByLicenceNumber(String licenseId);
    List<DrivingLicense>  findAll();
}
