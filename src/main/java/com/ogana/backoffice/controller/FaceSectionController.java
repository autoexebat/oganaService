package com.ogana.backoffice.controller;

import com.ogana.backoffice.domain.FaceSection;
import com.ogana.backoffice.domain.FaceSectionDetail;
import com.ogana.backoffice.service.FSService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boc")
public class FaceSectionController {
    private final FSService fsService;

    @GetMapping("/face-section")
    public String searchFaceSection() {
        return "/boc/face-section";
    }

//    @GetMapping("/test/face-section")
//    @ResponseBody
//    public List<FaceSection> test() {
//        return fsService.test();
//    }
}
