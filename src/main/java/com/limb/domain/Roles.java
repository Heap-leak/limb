package com.limb.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
