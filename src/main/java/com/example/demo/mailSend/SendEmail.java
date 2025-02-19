package com.example.demo.mailSend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class SendEmail {
    @Autowired
    private JavaMailSender mailSender;


    @Value("${mail.sender}")
    private String youMail;
    @Value("${mail.massage}")
    private String mailMassag;

    @Value("${mail.sendTo}")
    private String [] sendTo;

    public void sendSimpleEmail(/*String[] toWhom, String youMassage*/) {




        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(youMail);
        message.setTo(sendTo);
        message.setText(mailMassag);

        mailSender.send(message);



    }

}
