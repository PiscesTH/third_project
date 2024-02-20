package com.baby.babycareproductsshop.admin.user;

import com.baby.babycareproductsshop.response.ApiResponse;
import com.baby.babycareproductsshop.common.*;
import com.baby.babycareproductsshop.entity.user.UserEntity;
import com.baby.babycareproductsshop.exception.AuthErrorCode;
import com.baby.babycareproductsshop.exception.RestApiException;
import com.baby.babycareproductsshop.security.AuthenticationFacade;
import com.baby.babycareproductsshop.security.JwtTokenProvider;
import com.baby.babycareproductsshop.security.MyPrincipal;
import com.baby.babycareproductsshop.user.UserRepository;
import com.baby.babycareproductsshop.user.model.UserSignInDto;
import com.baby.babycareproductsshop.user.model.UserSignInVo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.baby.babycareproductsshop.common.Const.rtName;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminUserService {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppProperties appProperties;
    private final MyCookieUtils myCookieUtils;
    private final AuthenticationFacade authenticationFacade;
    private final RedisTemplate<String, String> redisTemplate;
    private final UserRepository userRepository;

    public ApiResponse<?> postSigninAdmin(HttpServletResponse res, UserSignInDto dto) {
        Optional<UserEntity> optEntity = userRepository.findByProviderTypeAndUid(ProviderTypeEnum.LOCAL, dto.getUid());
        UserEntity entity = optEntity.orElseThrow(() -> new RestApiException(AuthErrorCode.LOGIN_FAIL));
        if (!RoleEnum.ADMIN.equals(entity.getRole())) {
            throw new RestApiException(AuthErrorCode.UNAUTHORIZED_USER);
        }
        if (!passwordEncoder.matches(dto.getUpw(), entity.getUpw())) {
            throw new RestApiException(AuthErrorCode.LOGIN_FAIL);
        }

        MyPrincipal myPrincipal = MyPrincipal.builder()
                .iuser(entity.getIuser().intValue())
                .build();
        myPrincipal.getRoles().add(entity.getRole().name());

        String at = jwtTokenProvider.generateAccessToken(myPrincipal);
        String rt = jwtTokenProvider.generateRefreshToken(myPrincipal);

        int rtCookieMaxAge = appProperties.getJwt().getRefreshCookieMaxAge();
        myCookieUtils.deleteCookie(res, rtName);
        myCookieUtils.setCookie(res, rtName, rt, rtCookieMaxAge);
        log.info("rt : {}", rt);

        String iuser = String.valueOf(entity.getIuser());
        redisTemplate.opsForValue().set(iuser, rt, 1296000, TimeUnit.SECONDS);

        String redisRt = redisTemplate.opsForValue().get(iuser);
        log.info("redisRt : {}", redisRt);
        HttpStatus httpStatus = HttpStatus.OK;
        UserSignInVo result = UserSignInVo.builder()
                .result(1)
                .nm(entity.getNm())
                .accessToken(at)
                .build();
        return new ApiResponse<>(String.valueOf(httpStatus.value()), httpStatus.getReasonPhrase(), result);
    }
}
