package com.softuni.mobilele.services;


import com.softuni.mobilele.domain.dtoS.model.UserRegisterFormDto;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private EmailService emailService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    //  private final String defaultAdminPass;


    @Autowired

    public UserService(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder
            , EmailService emailService
                       // , @Value("${mobile.admin.defaultpass}") String defaultAdminPass
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;

        this.passwordEncoder = passwordEncoder;
        //   this.defaultAdminPass = defaultAdminPass;
    }


    public void registerUser(UserRegisterFormDto registerDto) {
        UserEntity userEntity = new UserEntity()
                .setFirstName(registerDto.getFirstName())
                .setLastName(registerDto.getLastName())
                .setEmail(registerDto.getEmail())
                .setPassword(passwordEncoder.encode(registerDto.getPassword()));

        userRepository.save(userEntity);

        this.emailService.sendRegistrationEmail(userEntity.getEmail(), userEntity.getFirstName() + " " + userEntity.getLastName());
    }


    public UserEntity findUserEntityByUsername(String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }
}