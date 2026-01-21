package com.smartclinic.service;

import com.smartclinic.entity.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /**
     * Retrieve available time slots for a doctor on a given date
     */
    public List<LocalTime> getAvailableSlots(Long doctorId, LocalDate date) {

        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);

        if (doctorOptional.isEmpty()) {
            return List.of();
        }

        Doctor doctor = doctorOptional.get();

        // In a real system, date-based filtering would occur here
        return doctor.getAvailableTimes();
    }

    /**
     * Doctor login validation
     */
    public ResponseEntity<Map<String, String>> login(String email, String password) {

        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(email);
        Map<String, String> response = new HashMap<>();

        if (doctorOptional.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Doctor not found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // Simplified password check (for assignment purpose)
        if (!"password123".equals(password)) {
            response.put("status", "error");
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        response.put("status", "success");
        response.put("message", "Login successful");

        return ResponseEntity.ok(response);
    }
}
