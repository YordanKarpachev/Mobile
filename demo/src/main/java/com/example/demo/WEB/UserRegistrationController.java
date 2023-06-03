package com.example.demo.WEB;



import com.example.demo.model.Dto.UserRegisterDTO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    @ModelAttribute("userModel")
    private UserRegisterDTO initUserModel(Model model){
       return new UserRegisterDTO();


    }

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String register(Model model) {


        return "auth-register";
    }


    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult );
            return "redirect:/users/register";
        }
        this.userService.registerAndLogin(userModel);

        return "index";

    }
}