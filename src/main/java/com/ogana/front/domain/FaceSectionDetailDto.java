package com.ogana.front.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class FaceSectionDetailDto {
    private String name;
    private BigDecimal price;
}
