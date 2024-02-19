package com.baby.babycareproductsshop.security.oauth2.userinfo;

import com.baby.babycareproductsshop.common.ProviderTypeEnum;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OAuth2UserInfoFactory {    //factory : 객체 생성하는 공장 ?
    public OAuth2UserInfo getOAuth2UserInfo(ProviderTypeEnum socialProviderType,
                                            Map<String, Object> attribute) {
        return switch (socialProviderType) {
            case KAKAO -> new KakaoOAuth2UserInfo(attribute);
            case NAVER -> new NaverOAuth2UserInfo(attribute);
            default -> throw new IllegalArgumentException("Invalid Provider Type.");
        };  //switch문 에서 넘어오는 값 리턴 가능
    }
}
