package elinext.mail.test.service;

import elinext.mail.test.presentation.dto.MessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {
    private final JavaMailSender mailSender;

    public MailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Value("${spring.mail.username}")
    private String userName;

    public void send(MessageDto messageDto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(userName);
        mailMessage.setTo(messageDto.getEmailTo());
        mailMessage.setSubject(messageDto.getSubject());
        mailMessage.setText(messageDto.getMessage());
        mailSender.send(mailMessage);
    }
}
