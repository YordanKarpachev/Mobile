package bg.softuni.mobilele.WEB;

import bg.softuni.mobilele.model.Dto.UserLoginDTO;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public String logout(){
        this.userService.logout();

        return "redirect:/";

    }

    @GetMapping("/login")
    public String login(){

        return "auth-login";
    };

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO){
        this.userService.login(userLoginDTO);
    //  System.out.println("User is logged " + userService.login(userLoginDTO));
        return "redirect:/";
    }



}
