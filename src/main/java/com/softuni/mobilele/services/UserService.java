package com.softuni.mobilele.services;


import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements DataBaseInitService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;


        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void dbInit() {
        UserEntity admin = new UserEntity()
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setEmail("admin@example.de")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setRoles(this.roleRepository.findAll());
        userRepository.save(admin);
    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() == 0;
    }


}