package com.softuni.mobilele.services;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TempEmailTest implements CommandLineRunner {

    private EmailService emailService;

    public TempEmailTest(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) throws Exception {

        emailService.sendRegistrationEmail("yordam@example.com", "yordan");
    }
}
