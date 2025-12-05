// src/main/java/com/smartclinic/service/DoctorService.java
package main.java.com.service;

import com.smartclinic.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    // NOTE: For minimal runnable example we use in-memory list.
    // Replace with JPA repository in a real project.
    private final List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> findAll() {
        return doctors;
    }

    public Doctor save(Doctor d) {
        if (d.getId() == null) d.setId((long) (doctors.size() + 1));
        doctors.removeIf(existing -> existing.getId().equals(d.getId()));
        doctors.add(d);
        return d;
    }

    public List<Doctor> searchBySpecialityAndTime(String speciality, String time) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.getSpeciality() != null && d.getSpeciality().equalsIgnoreCase(speciality)) {
                // time filter is naive for the stub
                result.add(d);
            }
        }
        return result;
    }
}
