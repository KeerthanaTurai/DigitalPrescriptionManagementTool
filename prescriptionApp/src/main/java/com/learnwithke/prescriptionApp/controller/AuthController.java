package com.learnwithke.prescriptionApp.controller;

import com.learnwithke.prescriptionApp.dto.*;
import com.learnwithke.prescriptionApp.model.User;
import com.learnwithke.prescriptionApp.service.UserService;
import com.learnwithke.prescriptionApp.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        // 1. Encode the password
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        // 2. Create new User object
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(hashedPassword);
        user.setRole(request.getRole());

        // 3. Save to database
        userService.saveUser(user);

        // 4. Generate JWT token
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        // 1. Authenticate credentials
        System.out.println("LOGIN REQUEST RECEIVED: " + request.getEmail());
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2. Load user from database
       User user = userService.findByEmail(request.getEmail())
    .orElseThrow(() -> new RuntimeException("User not found"));

        // 3. Generate JWT token
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token);
    }
}
