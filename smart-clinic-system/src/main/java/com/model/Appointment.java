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

    private Long patientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDateTime appointmentTime;

    private String status; // e.g., Pending, Completed, Cancelled
}
