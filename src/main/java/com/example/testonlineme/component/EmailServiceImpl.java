package com.example.testonlineme.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
    @Autowired
    public JavaMailSender mailsender;
    @Autowired
    SimpleMailMessage message;

    public void sendMessage(String to, String subject,String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setText(text);
        message.setSubject(subject);
        mailsender.send(message);
    }
}
