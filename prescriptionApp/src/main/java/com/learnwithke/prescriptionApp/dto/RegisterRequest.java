package com.learnwithke.prescriptionApp.dto;

import com.learnwithke.prescriptionApp.model.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role; // DOCTOR or PATIENT
}
