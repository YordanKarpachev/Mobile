package com.softuni.mobilele.services;

import com.softuni.mobilele.config.TokenGenerator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;


    private static final String hostRailwayApp = "//https://red-pull-production.up.railway.app/";
    private static final String localhost = "http://localhost:8080/";

    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine
    ) {

        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;

    }

    public void sendRegistrationEmail(String userEmail, String userName) {


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom("mobileprojectyk@gmail.com");
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setSubject("Welcome to Mobile");
            mimeMessageHelper.setText(generateEmailText(userName), true);

            javaMailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    private String generateEmailText(String username) {
        Context ctx = new Context();
        ctx.setLocale(Locale.getDefault());
        ctx.setVariable("userName", username);

        return templateEngine.process("email/registration", ctx);
    }

    public boolean sendPasswordResetEmail(String userEmail, String token) {



        String resetLink = hostRailwayApp +"users/reset-password?token=" + token;

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try {
            mimeMessageHelper.setFrom("mobileprojectyk@gmail.com");
            mimeMessageHelper.setTo(userEmail);
            mimeMessageHelper.setSubject("Password Reset");
            mimeMessageHelper.setText(resetLink);


            javaMailSender.send(mimeMessageHelper.getMimeMessage());
            return true;
        } catch (MessagingException e) {
            return false;

        }
    }

}
