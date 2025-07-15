package com.learnwithke.prescriptionApp.repository;

import com.learnwithke.prescriptionApp.model.Prescription;
import com.learnwithke.prescriptionApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByPatient(User patient);
    List<Prescription> findByDoctor(User doctor);
}
