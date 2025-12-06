package com.smartclinic.service;

import com.smartclinic.dto.PrescriptionRequest;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

    public void savePrescription(PrescriptionRequest request) {
        // In real project you save to DB
        System.out.println("Saving prescription: " + request.getPrescriptionNotes());
    }
}
