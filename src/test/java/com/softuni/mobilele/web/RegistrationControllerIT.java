package com.softuni.mobilele.web;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
           .andExpect(redirectedUrl("/users/login"))
    ;




    }
}
