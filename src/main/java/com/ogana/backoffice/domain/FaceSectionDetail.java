package com.ogana.backoffice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaceSectionDetail {
    private Long id;
    private String detailName;
    private BigDecimal price;
    private String fsCode;
    private LocalDateTime regDts;
    private LocalDateTime modDts;

    public FaceSectionDetail(Long id, String detailName, BigDecimal price) {
        this.id = id;
        this.detailName = detailName;
        this.price = price;
    }

    public FaceSectionDetail(String detailName, BigDecimal price) {
        this.detailName = detailName;
        this.price = price;
    }
}
