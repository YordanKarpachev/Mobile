package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtoS.model.UserRegisterFormDto;
import com.softuni.mobilele.services.EmailService;
import com.softuni.mobilele.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegistrationController {


    @Autowired
    private  EmailService emailService;

    public RegistrationController(EmailService emailService) {
        this.emailService = emailService;
    }
    @ModelAttribute(name = "userRegisterForm")
    public UserRegisterFormDto initUserRegisterFormDto() {
        return new UserRegisterFormDto();
    }
    private UserService userService;
    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        return "auth-register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterForm") UserRegisterFormDto userRegisterInfo,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterForm", userRegisterInfo)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

            return "redirect:/users/register";
        }

    this.userService.registerUser(userRegisterInfo);
    this.emailService.sendRegistrationEmail(userRegisterInfo.getEmail(), userRegisterInfo.getFirstName() + userRegisterInfo.getLastName());
        redirectAttributes.addFlashAttribute("firstName", userRegisterInfo.getFirstName());
        redirectAttributes.addFlashAttribute("lastName", userRegisterInfo.getLastName());
        return "redirect:/users/login";
    }



}
