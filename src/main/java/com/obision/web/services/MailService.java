package com.obision.web.services;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class MailService {
    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean sendMail(String from, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from); // If from account is incorrect throws exception
            message.setTo("contact@obision.com");
            message.setSubject(subject);
            message.setText(body);

            javaMailSender.send(message);

            return true;
        } catch (Exception e) {
            log.error("Error sending mail", e);

            return false;
        }
    }
}
