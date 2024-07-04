package com.SpringSecurity.AuthAgainstDBPractice1.sddl.repositories;

import com.SpringSecurity.AuthAgainstDBPractice1.sddl.entities.LocationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationData, Long> {

}
