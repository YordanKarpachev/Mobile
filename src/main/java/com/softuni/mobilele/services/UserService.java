package com.softuni.mobilele.services;


import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements DataBaseInitService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
  //  private final String defaultAdminPass;


    @Autowired

    public UserService(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder
           // , @Value("${mobile.admin.defaultpass}") String defaultAdminPass
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;


        this.passwordEncoder = passwordEncoder;
     //   this.defaultAdminPass = defaultAdminPass;
    }

    @Override
    public void dbInit() {
        UserEntity admin = new UserEntity()
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setEmail("admin@example.com")
                .setPassword(passwordEncoder.encode("topsecret"))
              //  .setPassword(passwordEncoder.encode(defaultAdminPass))
                .setRoles(this.roleRepository.findAll());
        userRepository.save(admin);
    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() == 0;
    }

    public void registerUser(UserRegisterFormDto registerDto){
        UserEntity userEntity = new UserEntity()
                .setFirstName(registerDto.getFirstName())
                .setLastName(registerDto.getLastName())
                .setEmail(registerDto.getEmail())
                .setPassword(registerDto.getPassword());

        userRepository.save(userEntity);
    }


}