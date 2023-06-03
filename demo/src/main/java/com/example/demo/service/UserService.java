package com.example.demo.service;



import com.example.demo.model.Dto.UserRegisterDTO;
import com.example.demo.model.entiti.UserEntity;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserDetailsService userDetailsService;
    private final EmailService emailService;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper,
                       UserDetailsService userDetailsService, EmailService emailService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userDetailsService = userDetailsService;
        this.emailService = emailService;
    }


    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = userMapper.userDTOoUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);
      //  emailService.sendRegistrationEmail(newUser.getEmail(), newUser.getFirstName() + " " + newUser.getLastName());

    }


    private void login(UserEntity userEntity) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);

    }


}
