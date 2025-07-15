package com.learnwithke.prescriptionApp.controller;

import java.time.LocalDate;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithke.prescriptionApp.model.Prescription;
import com.learnwithke.prescriptionApp.model.User;
import com.learnwithke.prescriptionApp.service.PrescriptionService;
import com.learnwithke.prescriptionApp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('DOCTOR')")
    public Prescription createPrescription(@RequestParam Long patientId, @RequestParam String medicationName, @RequestParam String dosage, Authentication authentication){
        // getting doctor mail id and logging in
        String doctorEmail =  authentication.getName();
        User doctor = userService.findByEmail(doctorEmail).orElseThrow(() -> new RuntimeException("Doctor not found!"));
        
        // finding patient
        User patient = userService.findById(patientId).orElseThrow(() -> new RuntimeException("No patient found!"));

        // creating prescription
        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setMedicationName(medicationName);
        prescription.setDosage(dosage);
        prescription.setPrescribedDate(LocalDate.now());
        return prescriptionService.savePrescription(prescription);
    }
}
