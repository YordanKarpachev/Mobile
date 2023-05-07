package bg.softuni.mobilele.WEB;


import bg.softuni.mobilele.model.entiti.Dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegisterController {


    @GetMapping("/users/register")
    public String register() {


        return "auth-register";
    }


    @PostMapping("/users/register")
    public String register(UserRegisterDTO userRegisterDTO){


        return "redirect:/";

    }


}
