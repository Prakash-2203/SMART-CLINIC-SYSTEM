// src/main/java/com/smartclinic/controller/PrescriptionController.java
package com.smartclinic.controller;

import com.smartclinic.dto.PrescriptionRequest;
import com.smartclinic.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    /**
     * Creates a prescription for a specific appointment.
     *
     * @param token   The authentication token provided by the user.
     * @param request The validated prescription payload.
     * @return A success message with saved prescription information.
     */
    @PostMapping("/{token}")
    public ResponseEntity<String> createPrescription(
            @PathVariable String token,
            @Valid @RequestBody PrescriptionRequest request) {

        // Token validation would normally occur here
        // For example: authService.validateToken(token);

        prescriptionService.savePrescription(request);

        return ResponseEntity.ok("Prescription saved successfully");
    }
}
