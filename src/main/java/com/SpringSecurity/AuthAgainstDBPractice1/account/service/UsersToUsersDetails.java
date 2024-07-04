package com.SpringSecurity.AuthAgainstDBPractice1.account.service;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersToUsersDetails implements UserDetails {
    private String email;
    private int phone;
    private String password;
    private List<GrantedAuthority> roles;
    public UsersToUsersDetails(Users users) {
        this.email = users.getEmail();
        this.phone = users.getPhone();
        this.password = users.getPassword();
        this.roles = Arrays.stream(users.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
