package com.ogana.backoffice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FaceSection {
    private Long id;
    private String fsCode;
    private String sectionName;

    public FaceSection(String sectionName) {
        this.sectionName = sectionName;
    }

}
