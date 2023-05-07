package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.entiti.Dto.UserLoginDTO;
import bg.softuni.mobilele.model.entiti.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private CurrentUser currentUser;
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;


    public UserService(CurrentUser currentUser, UserRepository userRepository) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(userLoginDTO.getUsername());

        if (userOpt.isEmpty()) {

            logger.debug("user with name [{}] not found", userLoginDTO.getUsername());
            return false;
        }

        boolean success = userOpt.get().getPassword().equals(userLoginDTO.getPassword());

        if (success) {
        login(userOpt.get());
        } else {
    logout();
        }

        return success;
    }

    private void login(UserEntity user){
        currentUser.setLoggedIn(true);
        currentUser.setName(user.getFirstName() + " " +  user.getLastName());
    }

    public void logout(){
        currentUser.clear();
    }

}
