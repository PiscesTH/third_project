package com.baby.babycareproductsshop.mail;

import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.mail.model.EmailMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/mail")
public class MailController {
    private final ConsoleMailService consoleMailService;
    private final HtmlMailService htmlMailService;

    @PostMapping("/test")
    public void consoleTest(@RequestBody EmailMessageDto dto) {
        consoleMailService.send(dto);
    }

    @PostMapping("/send-test")
    public void sendTest(@RequestBody EmailMessageDto dto) {
        htmlMailService.send(dto);
    }
}
