package com.hrms.adminservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hrms.adminservice.domain.User;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(User user){

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmail());

        msg.setSubject("Your Company Log In Information");
        msg.setText("Account: "+user.getName()+"\nEmail: "+user.getEmail()+"\nPassword: "+user.getPassword()+"\n");
        javaMailSender.send(msg);
        
    }
}
