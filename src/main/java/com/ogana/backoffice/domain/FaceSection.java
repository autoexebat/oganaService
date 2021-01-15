package com.ogana.backoffice.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class FaceSection {
    @Id
    private String code;
    private String name;

}
