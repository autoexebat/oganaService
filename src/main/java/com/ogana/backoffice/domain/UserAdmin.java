package com.ogana.backoffice.domain;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserAdmin extends User {

    private Admin admin;

    public UserAdmin(Admin admin) {
        super(admin.getUserId(), admin.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        this.admin = admin;
    }
}