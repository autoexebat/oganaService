package com.ogana.backoffice.service;

import com.ogana.backoffice.domain.Admin;
import com.ogana.backoffice.domain.UserAdmin;
import com.ogana.backoffice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUserId(userId);
        if(admin == null) {
            throw new UsernameNotFoundException(admin.getUserId());
        }
        return new UserAdmin(admin);
    }
}
