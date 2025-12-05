// src/main/java/com/smartclinic/service/AppointmentService.java
package main.java.com.service;

import com.smartclinic.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>();

    public List<Appointment> findByPatientId(Long patientId) {
        List<Appointment> out = new ArrayList<>();
        for (Appointment a : appointments) if (a.getPatientId().equals(patientId)) out.add(a);
        return out;
    }

    // Add helper to add sample data for testing
    public Appointment add(Appointment a) {
        if (a.getId() == null) a.setId((long) (appointments.size() + 1));
        appointments.add(a);
        return a;
    }
}
