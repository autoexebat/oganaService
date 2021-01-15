package com.ogana.front.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Estimate {
    private CustomerInfo user;
    private List<FaceSectionDto> faceSectionDto;
    private BigDecimal totalPrice;
    private LocalDateTime startReserveDt;
    private LocalDateTime endReserveDt;
    private LocalDateTime creatDate = LocalDateTime.now();

    public Estimate(CustomerInfo user, List<FaceSectionDto> faceSectionDto) {
        this.user = user;
        this.faceSectionDto = faceSectionDto;
    }

    /**
     * 총 부위 개수 가져오
     * @return
     */
    public int totalFaceSectionCount() {
        return faceSectionDto.size();
    }

    /**
     * 총 시술 부위 개수 가져오기
     * @return
     */
    public int totalFaceDetailSectionCount() {
        return faceSectionDto.stream().map(detail -> detail.getSectionList().size())
                .reduce((size1, size2) -> size1 + size2)
                .orElse(0);
    }
    /**
     * 총 금액 구하기
     * @return
     */
    public BigDecimal getTotalPrice() {
        return faceSectionDto.stream().map(detail -> detail.getTotalPrice())
                .reduce((fs1, fs2) -> fs1.add(fs2))
                .orElse(new BigDecimal(0));
    }
}
