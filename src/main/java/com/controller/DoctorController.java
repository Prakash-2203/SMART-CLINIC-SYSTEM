// src/main/java/com/smartclinic/controller/DoctorController.java
package com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.model.AvailabilityResponse;
import com.smartclinic.service.DoctorService;
import com.smartclinic.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final TokenService tokenService;

    public DoctorController(DoctorService doctorService, TokenService tokenService) {
        this.doctorService = doctorService;
        this.tokenService = tokenService;
    }

    /**
     * Get all doctors
     */
    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    /**
     * Search doctors by speciality and optional time
     */
    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> search(
            @RequestParam String speciality,
            @RequestParam(required = false) String time) {

        return ResponseEntity.ok(doctorService.searchBySpecialityAndTime(speciality, time));
    }

    /**
     * Create a doctor record
     */
    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.save(doctor));
    }

    /**
     * REQUIRED ENDPOINT: Get doctor availability based on:
     * - doctorId
     * - date
     * - user role
     * - token validation
     *
     * Example request:
     * GET /api/doctors/availability?doctorId=3&date=2025-10-30&role=patient&token=abc123
     */
    @GetMapping("/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @RequestParam Long doctorId,
            @RequestParam String date,
            @RequestParam String role,
            @RequestParam String token) {

        // 1. Validate token
        if (!tokenService.isValidToken(token)) {
            return ResponseEntity.status(401).body("Invalid token.");
        }

        // 2. Validate role access
        if (!role.equalsIgnoreCase("patient") &&
            !role.equalsIgnoreCase("doctor") &&
            !role.equalsIgnoreCase("admin")) {
            return ResponseEntity.status(403).body("Access denied: Invalid role.");
        }

        // 3. Convert date
        LocalDate requestedDate = LocalDate.parse(date);

        // 4. Get availability
        AvailabilityResponse availability =
                doctorService.getDoctorAvailability(doctorId, requestedDate);

        return ResponseEntity.ok(availability);
    }
}

