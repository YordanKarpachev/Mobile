package bg.softuni.mobilele.WEB;

import bg.softuni.mobilele.model.entiti.Dto.UserLoginDTO;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){

        return "auth-login";
    };

    @PostMapping("/user/login")
    public String login(UserLoginDTO userLoginDTO){
      System.out.println("User is logged " + userService.login(userLoginDTO));
        return "redirect:/";
    }
}
