package com.learnwithke.prescriptionApp.service;

import com.learnwithke.prescriptionApp.model.Prescription;
import com.learnwithke.prescriptionApp.model.User;
import com.learnwithke.prescriptionApp.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> findByDoctor(User doctor) {
        return prescriptionRepository.findByDoctor(doctor);
    }

    public List<Prescription> findByPatient(User patient) {
        return prescriptionRepository.findByPatient(patient);
    }

    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }

    public List<Prescription> getAll(){
        return prescriptionRepository.findAll();
    }
}
