// src/main/java/com/smartclinic/controller/PrescriptionController.java
package main.java.com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @PostMapping
    public ResponseEntity<String> createPrescription(@RequestBody String payload) {
        // stub - in real app you'd parse payload and save
        return ResponseEntity.ok("prescription saved (stub)");
    }
}
