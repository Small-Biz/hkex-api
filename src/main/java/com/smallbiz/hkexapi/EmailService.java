package com.smallbiz.hkexapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	public String sendEmail() {
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setFrom("ray101682@gmail.com");
		message.setTo("ray101682@gmail.com");
		message.setSubject("[HkexApi]-downloader result");
		message.setText("Hello world");
		
		javaMailSender.send(message);
		return "Mail send successfully";
	}
	
}
