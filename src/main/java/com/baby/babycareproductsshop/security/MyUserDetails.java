package com.baby.babycareproductsshop.security;


import com.baby.babycareproductsshop.entity.user.UserEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Data
@Builder
public class MyUserDetails implements UserDetails, OAuth2User {

    private MyPrincipal myPrincipal;
    private Map<String, Object> attributes;
    private UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {    //권한
        if (myPrincipal == null) {
            return null;
        }
        return this.myPrincipal.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .toList();
    }

    @Override
    public String getPassword() {   //시큐리티 루틴 이용하면 구현 필요
        return null;
    }

    @Override
    public String getUsername() {   //시큐리티 루틴 이용하면 구현 필요
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
