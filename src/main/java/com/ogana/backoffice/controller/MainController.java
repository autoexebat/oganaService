package com.ogana.backoffice.controller;

import com.ogana.backoffice.domain.Admin;
import com.ogana.backoffice.repository.AdminRepository;
import com.ogana.backoffice.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boc")
public class MainController {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/main")
    public String main() {
        return "boc/main";
    }

    @GetMapping("/login")
    public String login(Authentication authentication) {
        if(authentication != null) {
            return "redirect:/boc/main";
        }

        Admin test = new Admin();
        test.setUserId("admin");
        test.setPassword(passwordEncoder.encode("admin"));
        if(adminRepository.findByUserId("admin") == null) {
            adminRepository.save(test);
        }
        return "boc/login";
    }

    @GetMapping("/password-change")
    public String passwordChange() {
        return "boc/password-change";
    }
    @PostMapping("/password-change")
    public String changePassword(String password1) {
        return "redirect:/boc/login";
    }
}
