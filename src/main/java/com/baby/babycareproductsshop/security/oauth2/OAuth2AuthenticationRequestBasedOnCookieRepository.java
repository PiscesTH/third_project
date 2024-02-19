package com.baby.babycareproductsshop.security.oauth2;

import com.baby.babycareproductsshop.common.MyCookieUtils;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationRequestBasedOnCookieRepository
        implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {
    public static final String OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME = "oauth2_auth_request";
    public static final String REDIRECT_URI_PARAM_COOKIE_NAME = "redirect_uri";
    private static final int COOKIE_EXPIRE_SECONDS = 180;
    public final MyCookieUtils cookieUtils;

    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        log.info("OAuth2AuthenticationRequestCookieRepository - loadAuthorizationRequest");
        return cookieUtils.getCookie(request, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME)
                .map(cookie -> cookieUtils.deserialize(cookie, OAuth2AuthorizationRequest.class))
                .orElse(null);  //리턴값 존재하지 않으면 other value 리턴
    }

    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest,
                                         HttpServletRequest request,
                                         HttpServletResponse response) {
        log.info("saveAuthorizationRequest");
        if (authorizationRequest == null) {
            removeAuthorizationRequestCookies(response);
            return;
        }
        String serializeAuthReq = cookieUtils.serialize(authorizationRequest);

        cookieUtils.setCookie(response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME, serializeAuthReq, COOKIE_EXPIRE_SECONDS);

        String redirectUriAfterLogin = request.getParameter(REDIRECT_URI_PARAM_COOKIE_NAME);
        log.info("redirectUriAfterLogin : {}", redirectUriAfterLogin);
        if (StringUtils.isNotBlank(redirectUriAfterLogin)) {
            cookieUtils.setCookie(response, REDIRECT_URI_PARAM_COOKIE_NAME, redirectUriAfterLogin, COOKIE_EXPIRE_SECONDS);
        }
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request,
                                                                 HttpServletResponse response) {
        log.info("removeAuthorizationRequest");
        return this.loadAuthorizationRequest(request);
    }

    public void removeAuthorizationRequestCookies(HttpServletResponse response) {
        log.info("removeAuthorizationRequest");
        cookieUtils.deleteCookie(response, OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME);
        cookieUtils.deleteCookie(response, REDIRECT_URI_PARAM_COOKIE_NAME);
    }
}
