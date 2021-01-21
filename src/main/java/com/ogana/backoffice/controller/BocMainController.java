package com.ogana.backoffice.controller;

import com.ogana.backoffice.domain.Admin;
import com.ogana.backoffice.domain.FaceSectionDetail;
import com.ogana.backoffice.domain.GridDto;
import com.ogana.backoffice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boc")
public class BocMainController {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/main")
    public String main() {
        return "boc/main";
    }

    @GetMapping("/search/faceInfo")
    @ResponseBody
    public GridDto<FaceSectionDetail> searchFaceInfo() {
        FaceSectionDetail f1 = new FaceSectionDetail("f1", new BigDecimal(100));
        FaceSectionDetail f2 = new FaceSectionDetail("f2", new BigDecimal(200));
        FaceSectionDetail f3 = new FaceSectionDetail("f3", new BigDecimal(300));
        FaceSectionDetail f4 = new FaceSectionDetail("f4", new BigDecimal(400));

        List<FaceSectionDetail> list = List.of(f1, f2, f3, f4);
        return new GridDto<>(1, list.size(), true, list);
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
