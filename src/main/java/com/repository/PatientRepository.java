// src/main/java/com/smartclinic/repository/PatientRepository.java
package main.java.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartclinic.model.Appointment; // optional

@Repository
public interface PatientRepository /*extends JpaRepository<Patient, Long>*/ {
    // In a full app implement JpaRepository<Patient, Long> with Patient entity.
}
