package com.ogana.backoffice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class FaceDetailSection {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;

    public FaceDetailSection(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
