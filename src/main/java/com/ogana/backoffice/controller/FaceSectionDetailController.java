package com.ogana.backoffice.controller;

import com.ogana.backoffice.domain.FaceSectionDetail;
import com.ogana.backoffice.domain.GridDto;
import com.ogana.backoffice.dto.FaceSectionDetailDto;
import com.ogana.backoffice.dto.ResDto;
import com.ogana.backoffice.service.FSDService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boc")
public class FaceSectionDetailController {
    private final FSDService fsdService;


    @GetMapping("/face-section-detail")
    public String faceSectionDetail() {
        return "/boc/face-section-detail";
    }

    @GetMapping("/search/face-section-detail")
    @ResponseBody
    public GridDto<FaceSectionDetail> searchFaceSectionDetail() {
        List<FaceSectionDetail> list = fsdService.select();
        return new GridDto<>(1, list.size(), true, list);
    }

    @PutMapping("/update/face-section-detail")
    @ResponseBody
    public Map<String, Object> updateFaceSectionDetail(@RequestBody ResDto<FaceSectionDetailDto> update) {
        List<FaceSectionDetailDto> updatedRows = update.getUpdatedRows();
        fsdService.update(updatedRows);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", true);
        return resultMap;
    }

    @DeleteMapping("/delete/face-section-detail")
    @ResponseBody
    public Map<String, Object> deleteFaceSectionDetail(@RequestBody ResDto<FaceSectionDetailDto> delete) {
        List<FaceSectionDetailDto> deletedRows = delete.getDeletedRows();
        fsdService.delete(deletedRows);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", true);
        return resultMap;
    }

    @GetMapping("/test/face-section-detail")
    @ResponseBody
    public List<FaceSectionDetail> test() {
        return fsdService.test();
    }
}
