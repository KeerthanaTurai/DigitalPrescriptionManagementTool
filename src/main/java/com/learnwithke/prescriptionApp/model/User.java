package com.learnwithke.prescriptionApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true) // no two users should have same email
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Prescription> prescriptionsWritten;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Prescription> prescriptionsReceived;
}
