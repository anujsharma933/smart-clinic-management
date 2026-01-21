package com.smartclinic.service;

import com.smartclinic.entity.Appointment;
import com.smartclinic.entity.Doctor;
import com.smartclinic.entity.Patient;
import com.smartclinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Book a new appointment and save it to the database
     */
    public Appointment bookAppointment(
            Doctor doctor,
            Patient patient,
            LocalDateTime appointmentTime
    ) {
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(appointmentTime);

        return appointmentRepository.save(appointment);
    }

    /**
     * Fetch appointments by doctor and date
     */
    public List<Appointment> getAppointmentsByDoctorAndDate(
            Long doctorId,
            LocalDate date
    ) {
        return appointmentRepository
                .findByDoctorIdAndAppointmentDate(doctorId, date);
    }
}
