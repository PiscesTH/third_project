package com.baby.babycareproductsshop.admin.user;

import com.baby.babycareproductsshop.response.ApiResponse;
import com.baby.babycareproductsshop.user.model.UserSignInDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@Tag(name = "관리자 기능 - 회원 관리 API")
public class AdminUserController {
    private final AdminUserService service;

    @PostMapping
    public ApiResponse<?> postSigninAdmin(HttpServletResponse res, @RequestBody UserSignInDto dto) {
        log.info("admin login dto : {}", dto);
        return service.postSigninAdmin(res, dto);
    }
}
