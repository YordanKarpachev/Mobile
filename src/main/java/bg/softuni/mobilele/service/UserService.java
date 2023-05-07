package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.entiti.Dto.UserLoginDTO;
import bg.softuni.mobilele.model.entiti.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(userLoginDTO.getUsername());

        if (userOpt.isEmpty()) {

            logger.debug("user with name [{}] not found", userLoginDTO.getUsername());
            return false;
        }

        return userOpt.get().getPassword().equals(userLoginDTO.getPassword());

    }


}
