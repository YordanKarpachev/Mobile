package bg.softuni.mobilele.service;


import bg.softuni.mobilele.model.Dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entiti.UserEntity;

import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }


    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = userMapper.userDTOoUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);

    }


    private void login(UserEntity userEntity) {


    }


}
