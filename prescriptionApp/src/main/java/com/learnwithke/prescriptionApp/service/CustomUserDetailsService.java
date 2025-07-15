package com.learnwithke.prescriptionApp.service;

import com.learnwithke.prescriptionApp.model.User;
// import com.learnwithke.prescriptionApp.service.SecurityUser;
import com.learnwithke.prescriptionApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new SecurityUser(user); // You must have SecurityUser implemented
    }
}
