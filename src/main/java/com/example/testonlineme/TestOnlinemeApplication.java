package com.example.testonlineme;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class TestOnlinemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestOnlinemeApplication.class, args);
	}

	@Bean
	public JavaMailSender getJavamailSender(){
		JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
		mailsender.setHost("smtp.gmail.com");
		mailsender.setPort(587);
		mailsender.setUsername("testtime89@gmail.com");
		mailsender.setPassword("Testtime89()");
		Properties p = mailsender.getJavaMailProperties();
		p.put("mail.transport.protocol","smtp");
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.debug","true");
		return mailsender;
	}
	@Bean
	public SimpleMailMessage getTemplet(){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("selamat Datang%s");
		return message;
	}
}