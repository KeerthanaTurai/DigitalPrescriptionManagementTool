package com.learnwithke.prescriptionApp.service;

import com.learnwithke.prescriptionApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Wrap the role in a Spring-compatible format: ROLE_DOCTOR or ROLE_PATIENT
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword(); // use the hashed password
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // use email as username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // always active
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // never expired
    }

    @Override
    public boolean isEnabled() {
        return true; // account is enabled
    }
}
