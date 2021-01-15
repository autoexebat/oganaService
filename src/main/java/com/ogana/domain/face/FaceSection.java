package com.ogana.domain.face;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class FaceSection {
    private String name;
    private List<FaceDetailSection> sectionList;

    /**
     * 총 금액 구하기
     * @return
     */
    public BigDecimal getTotalPrice() {
        return sectionList.stream().map(FaceDetailSection::getPrice)
                .reduce((fs1, fs2) -> fs1.add(fs2))
                .orElse(new BigDecimal(0));
    }
}
