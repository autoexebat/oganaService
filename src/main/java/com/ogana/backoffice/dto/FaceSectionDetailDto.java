package com.ogana.backoffice.dto;

import com.ogana.backoffice.domain.FaceSectionDetail;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class FaceSectionDetailDto {
    private Long id;
    private String detailName;
    private BigDecimal price;

    public FaceSectionDetail toEntity() {
        return new FaceSectionDetail(id, detailName, price);
    }

}
