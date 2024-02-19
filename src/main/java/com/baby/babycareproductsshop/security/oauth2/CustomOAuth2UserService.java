package com.baby.babycareproductsshop.security.oauth2;

import com.baby.babycareproductsshop.common.ProviderTypeEnum;
import com.baby.babycareproductsshop.common.RoleEnum;
import com.baby.babycareproductsshop.entity.user.UserEntity;
import com.baby.babycareproductsshop.security.MyPrincipal;
import com.baby.babycareproductsshop.security.MyUserDetails;
import com.baby.babycareproductsshop.security.oauth2.userinfo.OAuth2UserInfo;
import com.baby.babycareproductsshop.security.oauth2.userinfo.OAuth2UserInfoFactory;
import com.baby.babycareproductsshop.user.UserMapper;
import com.baby.babycareproductsshop.user.model.UserSignInDto;
import com.baby.babycareproductsshop.user.model.UserSignInProcDto;
import com.baby.babycareproductsshop.user.model.UserSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserMapper mapper;
    private final OAuth2UserInfoFactory factory;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        try {
            return this.process(userRequest, user);
        } catch (AuthenticationException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User process(OAuth2UserRequest userRequest, OAuth2User user) {
        ProviderTypeEnum socialProviderType = ProviderTypeEnum.valueOf(userRequest.getClientRegistration()
                .getRegistrationId()
                .toUpperCase());

        Map<String, Object> attributes = user.getAttributes();
        OAuth2UserInfo oAuth2UserInfo = factory.getOAuth2UserInfo(socialProviderType, attributes);

        UserSignInDto dto = UserSignInDto.builder()
                .providerType(socialProviderType.name())
                .uid(oAuth2UserInfo.getId())
                .build();
        UserSignInProcDto savedUser = mapper.selSignInInfoByUid(dto.getUid(), dto.getProviderType());
        UserEntity entity = new UserEntity();
        if (savedUser == null) {
            entity = signupUser(oAuth2UserInfo, socialProviderType);
        }
        MyPrincipal myPrincipal = MyPrincipal.builder()
                .iuser(entity.getIuser().intValue())
                .build();
        myPrincipal.getRoles().add(entity.getRole().name());

        return MyUserDetails.builder()
                .userEntity(entity)
                .attributes(user.getAttributes())
                .myPrincipal(myPrincipal)
                .build();
    }

    private UserEntity signupUser(OAuth2UserInfo oAuth2UserInfo, ProviderTypeEnum socialProviderType) {
        UserSignUpDto dto = UserSignUpDto.builder()
                .providerType(socialProviderType.name())
                .uid(oAuth2UserInfo.getId())
                .upw("social")
                .nm(oAuth2UserInfo.getName())
                .role("USER")
                .build();
        int insResult = mapper.insUser(dto);

        UserEntity entity = new UserEntity();
        entity.setIuser((long)dto.getIuser());
        entity.setRole(RoleEnum.USER);
        entity.setNm(dto.getNm());
        entity.setUid(dto.getUid());
        return entity;
    }
}
