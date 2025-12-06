// src/main/java/com/smartclinic/model/Appointment.java
package com.smartclinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many appointments can belong to one patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Many appointments can belong to one doctor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    // Appointment date and time must be in the future
    @Future
    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    // Status examples: Pending, Completed, Cancelled
    @Column(nullable = false)
    private String status;
}
