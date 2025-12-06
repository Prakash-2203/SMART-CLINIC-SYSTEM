// src/main/java/com/smartclinic/service/DoctorService.java
package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    // In-memory list for demo. Replace with JPA repository in real system.
    private final List<Doctor> doctors = new ArrayList<>();

    // -------------------------
    // BASIC CRUD
    // -------------------------
    public List<Doctor> findAll() {
        return doctors;
    }

    public Doctor save(Doctor d) {
        if (d.getId() == null) {
            d.setId((long) (doctors.size() + 1));
        }
        doctors.removeIf(existing -> existing.getId().equals(d.getId()));
        doctors.add(d);
        return d;
    }

    // -------------------------
    // SEARCH DOCTORS
    // -------------------------
    public List<Doctor> searchBySpecialityAndTime(String speciality, String time) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.getSpeciality() != null &&
                    d.getSpeciality().equalsIgnoreCase(speciality)) {

                // Time matching stub – replace with real logic
                result.add(d);
            }
        }
        return result;
    }

    // -------------------------
    // REQUIRED FUNCTIONALITY #1
    // DOCTOR AVAILABILITY
    // -------------------------
    public List<String> getDoctorAvailability(Long doctorId, LocalDate date) {
        List<String> availability = new ArrayList<>();

        // simple demonstration logic
        for (Doctor d : doctors) {
            if (d.getId().equals(doctorId)) {

                // Stub schedule: 9 AM–5 PM every hour
                for (int hour = 9; hour <= 17; hour++) {
                    availability.add(date + " " + hour + ":00");
                }
                return availability;
            }
        }
        return availability;
    }

    // -------------------------
    // REQUIRED FUNCTIONALITY #2
    // DOCTOR LOGIN VALIDATION
    // -------------------------
    public Doctor validateCredentials(String email, String password) {
        for (Doctor d : doctors) {
            if (d.getEmail() != null &&
                    d.getPassword() != null &&
                    d.getEmail().equalsIgnoreCase(email) &&
                    d.getPassword().equals(password)) {

                return d;   // login success
            }
        }
        return null; // login failed
    }
}
