package com.ogana.domain.face;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class FaceDetailSection {
    private String name;
    private BigDecimal price;
}
