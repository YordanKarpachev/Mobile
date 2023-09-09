package com.softuni.mobilele.web;



import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import jakarta.mail.internet.MimeMessage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
public class RegistrationControllerIT {
    @Autowired
    MockMvc mockMvc;
    private GreenMail greenMail;



    @Value("${mail.port}")
    Integer port;
    @Value("${mail.host}")
    String host;

    @Value("${mail.username}")
    String mailUserName;


    @Value("${mail.password}")
    String mailPassword;

    @BeforeEach
    void setUp() {
        greenMail = new GreenMail(new ServerSetup(port, host, "smtp"));
        greenMail.start();
        greenMail.setUser(mailUserName, mailPassword);
    }

    @AfterEach
    void stop(){
        greenMail.stop();
    }


    @Test
    void testRegister() throws Exception {

        mockMvc.perform(post("/users/register")
                        .param("email", "admin@example.com")
                        .param("firstName", "admin")
                        .param("lastName", "adminov")
                        .param("password", "topsecret")
                        .param("confirmPassword", "topsecret")
                        .with(csrf())
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/login"));

      MimeMessage[] receivedMessages = greenMail.getReceivedMessages();

        Assert.assertEquals(1, receivedMessages.length);

       Assert.assertTrue( receivedMessages[0].getContent().toString().contains("admin adminov"));

    }
}
