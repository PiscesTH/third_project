package com.baby.babycareproductsshop.mail;

import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.mail.model.EmailMessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "메일 API", description = "메일 관련 파트")
public class MailController {
    private final ConsoleMailService consoleMailService;
    private final HtmlMailService htmlMailService;

    @Operation(summary = "메일 발송 기능 테스트(console-log)")
    @PostMapping("/console-test")
    public void consoleTest(@RequestBody EmailMessageDto dto) {
        consoleMailService.send(dto);
    }

    @Operation(summary = "회원 메일 발송 기능")
    @PostMapping("/send")
    public void sendTest(@RequestBody EmailMessageDto dto) {
        htmlMailService.send(dto);
    }
}
