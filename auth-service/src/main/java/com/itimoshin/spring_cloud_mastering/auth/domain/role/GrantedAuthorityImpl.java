package com.itimoshin.spring_cloud_mastering.auth.domain.role;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;

@Value
public class GrantedAuthorityImpl implements GrantedAuthority {

    private final String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
