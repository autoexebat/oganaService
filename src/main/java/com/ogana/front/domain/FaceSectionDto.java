package com.ogana.front.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class FaceSectionDto {
    private String name;
    private List<FaceSectionDetailDto> sectionList;

    /**
     * 총 금액 구하기
     * @return
     */
    public BigDecimal getTotalPrice() {
        return sectionList.stream().map(FaceSectionDetailDto::getPrice)
                .reduce((fs1, fs2) -> fs1.add(fs2))
                .orElse(new BigDecimal(0));
    }
}
