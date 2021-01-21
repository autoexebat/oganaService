package com.ogana.backoffice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaceSectionDetail {
    private Long id;
    private String detailName;
    private BigDecimal price;
    private String fsCode;

    public FaceSectionDetail(String detailName, BigDecimal price) {
        this.detailName = detailName;
        this.price = price;
    }
}
