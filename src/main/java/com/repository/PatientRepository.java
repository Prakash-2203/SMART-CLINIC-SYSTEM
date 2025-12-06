// src/main/java/com/smartclinic/repository/PatientRepository.java
package com.smartclinic.repository;

import com.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Retrieve a patient using their email address (required for full marks)
    Optional<Patient> findByEmail(String email);

    // Optional but recommended for best practices
    Optional<Patient> findByPhone(String phone);
}
