package com.taskManager.domain.usuario;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    user("user"),
    admin("admin");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
