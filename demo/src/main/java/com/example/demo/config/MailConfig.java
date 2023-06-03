package com.example.demo.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {



/*
    @Bean
    public JavaMailSender javaMailSender(
            @Value("${spring.mail.host}") String mailHost,
            @Value("${spring.mail.port}") Integer mailPort,
            @Value("${spring.mail.username}") String userName,
            @Value("${spring.mail.password}") String password
    ){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(mailPort);
        javaMailSender.setUsername(userName);
        javaMailSender.setPassword(password);
        javaMailSender.setJavaMailProperties(mailProperties());

        return javaMailSender;
    }

    private Properties mailProperties(){
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");

        return properties;
    }
*/
}
