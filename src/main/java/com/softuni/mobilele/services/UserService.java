package com.softuni.mobilele.services;


import com.softuni.mobilele.config.TokenGenerator;
import com.softuni.mobilele.domain.dtoS.model.UserRegisterFormDto;
import com.softuni.mobilele.domain.entities.PasswordResetToken;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.PasswordResetTokenRepository;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UserService {

    private EmailService emailService;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    private final PasswordResetTokenRepository passwordResetTokenRepository;


    @Autowired

    public UserService(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder
            , EmailService emailService, PasswordResetTokenRepository passwordResetTokenRepository
                       // , @Value("${mobile.admin.defaultpass}") String defaultAdminPass
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;

        this.passwordEncoder = passwordEncoder;
        //   this.defaultAdminPass = defaultAdminPass;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }


    public void registerUser(UserRegisterFormDto registerDto) {
        UserEntity userEntity = new UserEntity()
                .setFirstName(registerDto.getFirstName())
                .setLastName(registerDto.getLastName())
                .setEmail(registerDto.getEmail())
                .setPassword(passwordEncoder.encode(registerDto.getPassword()));

        userRepository.save(userEntity);

        this.emailService.sendRegistrationEmail(registerDto.getEmail(), registerDto.getFirstName() + registerDto.getLastName());
    }

    public boolean sendPasswordResetEmail(String userEmail) {

        Optional<UserEntity> userOptional = userRepository.findByEmail(userEmail);
        if (!userOptional.isPresent()) {
            return false;
        }

        UserEntity user = userOptional.get();
        TokenGenerator tokenGenerator = new TokenGenerator();
      String   token = tokenGenerator.generateToken();

        savePasswordResetToken(user, token);
        emailService.sendPasswordResetEmail(user.getEmail(), token);
    return true;
    }

    private void savePasswordResetToken(UserEntity user, String token) {
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setToken(token);
        resetToken.setUserEntity(user);
        resetToken.setExpiryDate(LocalDateTime.now().plusHours(24));

        passwordResetTokenRepository.save(resetToken);
    }


    public UserEntity findUserEntityByUsername(String username) {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }



    public boolean isTokenExpired(PasswordResetToken token) {
        return LocalDateTime.now().isAfter(token.getExpiryDate());
    }
}