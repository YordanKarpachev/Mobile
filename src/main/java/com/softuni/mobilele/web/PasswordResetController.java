package com.softuni.mobilele.web;

import com.softuni.mobilele.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/users")
public class PasswordResetController {


    @Autowired
    private UserService userService;


    @GetMapping("/reset-password")
    public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
        if (!userService.isTokenValid(token)) {
            model.addAttribute("error", "Password could not be reset. The token may be invalid or has expired. Please try again!");
            return "forgot-password";
        }
        model.addAttribute("token", token);
        return "reset-password";
    }



    @PostMapping("/reset-password")
    public String processResetPassword(
            @RequestParam("token") String token,
            @RequestParam("password") String password,
            @RequestParam("confirm") String confirmPassword,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("token", token);
            model.addAttribute("message", "Passwords do not match.");
            return "reset-password";
        }


        if (!userService.resetUserPassword(token, password)) {
            model.addAttribute("message", "Password could not be reset. The token may be invalid or has expired.");
            return "redirect:forgot-password";
        }


        redirectAttributes.addFlashAttribute("welcomeMessage", "Password has been successfully reset. You can now log in.");
        return "redirect:/users/login";
    }


    @PostMapping("/forgot-password")
    public String processForgotPassword(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String email = request.getParameter("email");

        boolean success = userService.sendPasswordResetEmail(email);
        if (success) {
            redirectAttributes.addFlashAttribute("error", "A link to reset your password has been sent." + email);
        } else {
            redirectAttributes.addFlashAttribute("error", "Email " + email +" could not be found.");
        }



        return "redirect:/users/forgot-password";
    }


    @GetMapping("/forgot-password")
    public String showForgotPasswordForm(Model model) {

        return "forgot-password";
    }


}
