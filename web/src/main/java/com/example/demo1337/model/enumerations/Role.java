package com.example.demo1337.model.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_BASIC, ROLE_PREMIUM,ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
