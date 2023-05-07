package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.entiti.Dto.UserLoginDTO;
import bg.softuni.mobilele.model.entiti.Dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entiti.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final CurrentUser currentUser;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(CurrentUser currentUser, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setActive(true);
        newUser.setEmail(userRegisterDTO.getEmail());
        newUser.setFirstName(userRegisterDTO.getFirstName());
        newUser.setLastName(userRegisterDTO.getLastName());
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        newUser = this.userRepository.save(newUser);

        login(newUser);

    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(userLoginDTO.getUsername());

        if (userOpt.isEmpty()) {

            logger.debug("user with name [{}] not found", userLoginDTO.getUsername());
            return false;
        }

        String rawPassword = userLoginDTO.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity user) {
        currentUser.setLoggedIn(true);
        currentUser.setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }

}
