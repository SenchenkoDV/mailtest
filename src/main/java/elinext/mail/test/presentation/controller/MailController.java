package elinext.mail.test.presentation.controller;

import elinext.mail.test.presentation.dto.MessageDto;
import elinext.mail.test.service.MailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mail")
public class MailController {
    private final MailSender mailSender;

    public MailController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping
    public void sendMessage(@RequestBody MessageDto messageDto) {
        mailSender.send(messageDto);
    }
}
