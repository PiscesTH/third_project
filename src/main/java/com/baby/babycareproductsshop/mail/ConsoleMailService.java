package com.baby.babycareproductsshop.mail;

import com.baby.babycareproductsshop.mail.model.EmailMessageDto;
import com.baby.babycareproductsshop.mail.model.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsoleMailService implements MailSender {
    private final JavaMailSender javaMailSender;

    @Override
    public void send(EmailMessageDto emailMessageDto) {
        log.info("send email: {}", emailMessageDto.getMessage());
    }
}
