package com.softuni.mobilele.services;


import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserService userService;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private EmailService emailService;

    @Captor

    private ArgumentCaptor<UserEntity> userEntityArgumentCaptor;




    @BeforeEach
    void  setUp(){
        this.userService = new UserService(roleRepository, userRepository, mockPasswordEncoder, emailService);
    }


    @Test
    void testUserSave(){
        UserRegisterFormDto userToSaveTest = new UserRegisterFormDto();
        userToSaveTest.setEmail("test@example.de");
        userToSaveTest.setFirstName("example");
        userToSaveTest.setLastName("examplev");

        this.userService.registerUser(userToSaveTest);

        Mockito.verify(userRepository).save(any());
    }

    @Test
    void testUserSaveVersion2(){
        String encodedPassword = "encodedPassword";

        UserRegisterFormDto testRegistrationDTO = new UserRegisterFormDto();
        testRegistrationDTO.setEmail("test@example.de");
        testRegistrationDTO.setFirstName("example");
        testRegistrationDTO.setLastName("examplev");
        testRegistrationDTO.setPassword("topsecret");

        when(mockPasswordEncoder.encode(testRegistrationDTO.getPassword()))
                .thenReturn(encodedPassword);

        userService.registerUser(testRegistrationDTO);

        Mockito.verify(userRepository).save(userEntityArgumentCaptor.capture());

        UserEntity actualSavedUser = userEntityArgumentCaptor.getValue();
        Assertions.assertEquals(testRegistrationDTO.getEmail(), actualSavedUser.getEmail());
        Assertions.assertEquals(encodedPassword, actualSavedUser.getPassword());

        Mockito.verify(emailService).sendRegistrationEmail(testRegistrationDTO.getEmail(), testRegistrationDTO.getFirstName() + " " + testRegistrationDTO.getLastName());
    }
}
