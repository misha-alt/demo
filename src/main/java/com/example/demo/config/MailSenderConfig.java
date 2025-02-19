package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailSenderConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // Укажите ваш SMTP-сервер
        mailSender.setPort(587); // Укажите порт SMTP-сервера
        mailSender.setUsername("mihailnadia27@gmail.com"); // Укажите ваш адрес электронной почты
        mailSender.setPassword("akgpstrbjkvcoqxa"); // Укажите пароль от вашей почты

        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}
