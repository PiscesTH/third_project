package com.baby.babycareproductsshop.security;

import com.baby.babycareproductsshop.security.oauth2.CustomOAuth2UserService;
import com.baby.babycareproductsshop.security.oauth2.OAuth2AuthenticationFailureHandler;
import com.baby.babycareproductsshop.security.oauth2.OAuth2AuthenticationRequestBasedOnCookieRepository;
import com.baby.babycareproductsshop.security.oauth2.OAuth2AuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OAuth2AuthenticationFailureHandler failureHandler;
    private final OAuth2AuthenticationRequestBasedOnCookieRepository requestCookieRepository;
    private final OAuth2AuthenticationSuccessHandler successHandler;
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(http -> http.disable())
                .formLogin(formLogin -> formLogin.disable())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(author -> author.requestMatchers(
                                        "/api/order",
                                        "/api/order/**",
                                        "/api/comment",
                                        "/api/user/address",
                                        "/api/user/modify",
                                        "/api/user/signout",
                                        "/apu/user/refresh-token",
                                        "/api/user/my-page",
                                        "/api/review",
                                        "/api/review/**",
                                        "/api/board/image-upload",
                                        "/api/product/wish",
                                        "/api/product/cart",
                                        "/api/product/login-main"
                                ).authenticated()
                                .requestMatchers(HttpMethod.PUT, "/api/board").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/api/board").authenticated()
                                .requestMatchers(HttpMethod.GET, "/api/board/write").authenticated()
                                .anyRequest().permitAll()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(except -> {
                    except.authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                            .accessDeniedHandler(new JwtAccessDeniedHandler());
                })
                .oauth2Login(oath2 -> oath2.authorizationEndpoint(auth -> auth.baseUri("/oauth2/authorization")
                                        .authorizationRequestRepository(requestCookieRepository)
                                ).redirectionEndpoint(redirection -> redirection.baseUri("/*/oauth2/code/*"))
                                .userInfoEndpoint(userinfo -> userinfo.userService(customOAuth2UserService))
                                .successHandler(successHandler)
                                .failureHandler(failureHandler)
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
