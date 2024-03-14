package com.softuni.mobilele.web;

import com.softuni.mobilele.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping("/forgot-password")
    public String processForgotPassword(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String email = request.getParameter("email");
        // Methode zum Senden des Passwort-Zurücksetz-Links
        boolean success = userService.sendPasswordResetEmail(email);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "Ein Link zum Zurücksetzen Ihres Passworts wurde gesendet.");
        } else {
            redirectAttributes.addFlashAttribute("error", "E-Mail konnte nicht gefunden werden.");
        }
        return "redirect:/users/forgot-password";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        if (model.containsAttribute("firstName") && model.containsAttribute("lastName")) {
            String firstName = (String) model.asMap().get("firstName");
            String lastName = (String) model.asMap().get("lastName");
            model.addAttribute("welcomeMessage", "Welcome, " + firstName + " " + lastName + "! You have successfully registered. Please sign in to continue.");
        }
        return "auth-login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        return "redirect:/users/login";
    }


    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";
    }


}
